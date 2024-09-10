package blueduck.vounierns_turrets.entity;

import blueduck.vounierns_turrets.entity.goal.TurretSitGoal;
import blueduck.vounierns_turrets.entity.projectile.LaserProjectile;
import blueduck.vounierns_turrets.entity.projectile.StoneProjectile;
import blueduck.vounierns_turrets.registry.TurretEntities;
import blueduck.vounierns_turrets.registry.TurretSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import javax.annotation.Nullable;

public class LaserTurret extends AbstractTurret implements RangedAttackMob, IAnimatable {

    private AnimationFactory factory = GeckoLibUtil.createFactory(this);



    public LaserTurret(EntityType<? extends AbstractGolem> p_27508_, Level p_27509_) {
        super(p_27508_, p_27509_);
        tier = this.getTier();
    }

    @Override
    public void performRangedAttack(LivingEntity p_29912_, float p_29913_) {
        LaserProjectile snowball = new LaserProjectile(this.level, this);
        double d0 = p_29912_.getEyeY() - (double)1.1F;
        double d1 = p_29912_.getX() - this.getX();
        double d2 = d0 - snowball.getY();
        double d3 = p_29912_.getZ() - this.getZ();
        double d4 = Math.sqrt(d1 * d1 + d3 * d3) * (double)0.2F;
        snowball.setDamage(3 + (this.tier - 1) * 2);
        shootLaser(d1, d2 + d4, d3, 1.6F, 12.0F, snowball);
        //this.playSound(SoundEvents.SNOW_GOLEM_SHOOT, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level.addFreshEntity(snowball);
        this.swing(InteractionHand.MAIN_HAND);
        this.playSound(TurretSounds.LASER_TURRET_SHOOT.get(), 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));


    }

    public void shootLaser(double p_37266_, double p_37267_, double p_37268_, float p_37269_, float p_37270_, LaserProjectile arrow) {
        Vec3 vec3 = (new Vec3(p_37266_, p_37267_, p_37268_)).normalize().add(this.random.triangle(0.0D, 0.001D * (double)p_37270_), this.random.triangle(0.0D, 0.001D * (double)p_37270_), this.random.triangle(0.0D, 0.001D * (double)p_37270_)).scale((double)p_37269_);
        arrow.setDeltaMovement(vec3);
        double d0 = vec3.horizontalDistance();
        arrow.setYRot((float)(Mth.atan2(vec3.x, vec3.z) * (double)(180F / (float)Math.PI)));
        arrow.setXRot((float)(Mth.atan2(vec3.y, d0) * (double)(180F / (float)Math.PI)));
        arrow.yRotO = arrow.getYRot();
        arrow.xRotO = arrow.getXRot();
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 2, 10.0F));
//        if (this.getTier() >= 3) {
//            this.goalSelector.addGoal(1, new TurretSitGoal(this));
//        }
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Mob.class, 20, true, false, (p_29932_) -> {
            return p_29932_ instanceof Enemy;
        }));
    }

    public static AttributeSupplier.Builder createT1Attributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.MOVEMENT_SPEED, (double)0.0F).add(Attributes.KNOCKBACK_RESISTANCE, 1.0D);
    }
    public static AttributeSupplier.Builder createT2Attributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 40.0D).add(Attributes.MOVEMENT_SPEED, (double)0.0F).add(Attributes.KNOCKBACK_RESISTANCE, 1.0D);
    }
    public static AttributeSupplier.Builder createT3Attributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 80.0D).add(Attributes.MOVEMENT_SPEED, (double)0.1F).add(Attributes.KNOCKBACK_RESISTANCE, 0.9D);
    }

    protected float getStandingEyeHeight(Pose p_29917_, EntityDimensions p_29918_) {
        return 0.7F;
    }

    @Nullable
    protected SoundEvent getAmbientSound() {
        return null;
    }

    @Nullable
    protected SoundEvent getHurtSound(DamageSource p_29929_) {
        return TurretSounds.TURRET_HURT.get();
    }

    @Nullable
    protected SoundEvent getDeathSound() {
        return TurretSounds.TURRET_DEATH.get();
    }


    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (this.swinging && this.swingTime != -1) {
            return PlayState.STOP;
        }

        if (tier >= 3) {
            if (event.isMoving()) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.model.move", ILoopType.EDefaultLoopTypes.LOOP));
            }
            else {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.model.idle", ILoopType.EDefaultLoopTypes.LOOP));

            }
        }

       return PlayState.CONTINUE;

    }

    private <E extends IAnimatable> PlayState attackPredicate(AnimationEvent<E> event) {
        if (this.swinging && this.swingTime != -1) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.model.fire", ILoopType.EDefaultLoopTypes.LOOP));
            return PlayState.CONTINUE;
        }

        event.getController().markNeedsReload();

        return PlayState.STOP;

    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
        data.addAnimationController(new AnimationController(this, "attackController",
                0, this::attackPredicate));
    }

    public int getTier() {
        EntityType<?> type = this.getType();
        if (type.equals(TurretEntities.LASER_TURRET_T1.get())) {
            return 1;
        } else if (type.equals(TurretEntities.LASER_TURRET_T2.get())) {
            return 2;
        } else if (type.equals(TurretEntities.LASER_TURRET_T3.get())) {
            return 3;
        }
        return 0;
    }





    public void aiStep() {

        this.updateSwingTimeTurret();
        super.aiStep();
    }

    protected void updateSwingTimeTurret() {
        int i = 10;
        if (this.swinging) {
            ++this.swingTime;
            if (this.swingTime >= i) {
                this.swingTime = 0;
                this.swinging = false;
            }
        } else {
            this.swingTime = 0;
        }

        this.attackAnim = (float)this.swingTime / (float)i;
    }


}
