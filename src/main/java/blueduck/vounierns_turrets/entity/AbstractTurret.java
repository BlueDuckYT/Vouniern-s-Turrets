package blueduck.vounierns_turrets.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.players.OldUsersConverter;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import software.bernie.geckolib.core.animation.RawAnimation;

import java.util.Optional;
import java.util.UUID;

public class AbstractTurret extends AbstractGolem {

    protected static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(AbstractTurret.class, EntityDataSerializers.BYTE);

    private boolean orderedToSit;

    public int tier;


    public static final RawAnimation MOVE = RawAnimation.begin().thenPlay("animation.model.move");
    public static final RawAnimation IDLE = RawAnimation.begin().thenPlay("animation.model.idle");
    public static final RawAnimation STAY = RawAnimation.begin().thenPlay("animation.model.stay");

    public static final RawAnimation FIRE = RawAnimation.begin().thenPlay("animation.model.fire");

    protected AbstractTurret(EntityType<? extends AbstractGolem> p_27508_, Level p_27509_) {
        super(p_27508_, p_27509_);

        this.getPersistentData().putBoolean("PersistenceRequired", true);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_FLAGS_ID, (byte)0);
    }

    public void addAdditionalSaveData(CompoundTag p_21819_) {
        super.addAdditionalSaveData(p_21819_);
        p_21819_.putBoolean("SittingTurret", this.orderedToSit);
    }

    public void readAdditionalSaveData(CompoundTag p_21815_) {
        super.readAdditionalSaveData(p_21815_);


        this.orderedToSit = p_21815_.getBoolean("SittingTurret");
        this.setInSittingPose(this.orderedToSit);
    }

    public boolean isInSittingPose() {
        return (this.entityData.get(DATA_FLAGS_ID) & 1) != 0;
    }

    public void setInSittingPose(boolean p_21838_) {
        byte b0 = this.entityData.get(DATA_FLAGS_ID);
        if (p_21838_) {
            this.entityData.set(DATA_FLAGS_ID, (byte)(b0 | 1));
        } else {
            this.entityData.set(DATA_FLAGS_ID, (byte)(b0 & -2));
        }

    }

    public boolean isOrderedToSit() {
        return this.orderedToSit;
    }

    public void setOrderedToSit(boolean p_21840_) {
        this.orderedToSit = p_21840_;
    }

    public InteractionResult mobInteract(Player p_30412_, InteractionHand p_30413_) {
        ItemStack itemstack = p_30412_.getItemInHand(p_30413_);
        Item item = itemstack.getItem();
        if (!this.level().isClientSide) {
                if (item.equals(Items.COPPER_INGOT) && this.getHealth() < this.getMaxHealth()) {
                    this.heal(5);
                    if (!p_30412_.getAbilities().instabuild) {
                        itemstack.shrink(1);
                    }

                    this.gameEvent(GameEvent.EAT, this);
                    return InteractionResult.SUCCESS;
                }
                if (item.equals(Items.ECHO_SHARD) && this.getHealth() < this.getMaxHealth()) {
                    this.heal(40);
                    if (!p_30412_.getAbilities().instabuild) {
                        itemstack.shrink(1);
                    }

                    this.gameEvent(GameEvent.EAT, this);
                    return InteractionResult.SUCCESS;
                }
                if (item.equals(Items.COPPER_INGOT) || item.equals(Items.ECHO_SHARD)) {
                    return InteractionResult.PASS;
                }

            }
            if (p_30413_.equals(InteractionHand.MAIN_HAND) && tier >= 3) {
                if (!this.level().isClientSide) {
                    this.setOrderedToSit(!this.isOrderedToSit());
                    this.jumping = !this.isOrderedToSit();
                    if (this.isOrderedToSit()) {
                        this.navigation.stop();
                        this.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, -1, 100, true, true));
                    }
                }
                this.setInSittingPose(this.isOrderedToSit());

                return InteractionResult.SUCCESS;
            }


            return super.mobInteract(p_30412_, p_30413_);
    }

    public void aiStep() {

        if (this.isOrderedToSit()) {
            this.navigation.stop();
            this.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, -1, 100, true, true));

        }
        else {
            if (this.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
                this.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
            }
        }
        super.aiStep();
    }
}
