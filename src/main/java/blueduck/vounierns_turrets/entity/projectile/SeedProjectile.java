package blueduck.vounierns_turrets.entity.projectile;

import blueduck.vounierns_turrets.entity.BasicTurret;
import blueduck.vounierns_turrets.entity.SeedTurret;
import blueduck.vounierns_turrets.registry.TurretEntities;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class SeedProjectile extends ThrowableProjectile implements GeoEntity {

    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

    private int damage = 3;

    public SeedProjectile(EntityType<? extends ThrowableProjectile> p_37466_, Level p_37467_) {
        super(p_37466_, p_37467_);
    }

    public SeedProjectile(Level p_37419_, LivingEntity p_37420_) {
    super(TurretEntities.SEED_PROJECTILE.get(), p_37420_, p_37419_);
    }

    public void setDamage (int newDamage) {
        damage = newDamage;
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    public void onHitEntity(EntityHitResult p_37259_) {
        super.onHitEntity(p_37259_);
        Entity entity = p_37259_.getEntity();
        Entity entity1 = this.getOwner();
        LivingEntity livingentity = entity1 instanceof LivingEntity ? (LivingEntity)entity1 : null;

        int damageToDeal = 1;
        if (livingentity instanceof SeedTurret)
            damageToDeal += ((SeedTurret) livingentity).tier;

        boolean flag =  entity.hurt(this.damageSources().thrown(this, livingentity), damageToDeal);

        this.discard();
        Vec3 vec3 = this.getDeltaMovement();
        double d5 = vec3.x;
        double d6 = vec3.y;
        double d1 = vec3.z;
        for(int i = 0; i < 2; ++i) {
            //this.level.addParticle(ParticleTypes.BLOCK, this.getRandomX(0.5D), this.getRandomY() - 0.25D, this.getRandomZ(0.5D), (this.random.nextDouble() - 0.5D) * .5D, -this.random.nextDouble() * 0.25 + .1, (this.random.nextDouble() - 0.5D) * .5D);
        }
    }

    public void shoot(double p_37266_, double p_37267_, double p_37268_, float p_37269_, float p_37270_) {
        Vec3 vec3 = (new Vec3(p_37266_, p_37267_, p_37268_)).normalize().add(this.random.triangle(0.0D, 0.019D * (double)p_37270_), this.random.triangle(0.0D, 0.019D * (double)p_37270_), this.random.triangle(0.0D, 0.019D * (double)p_37270_)).scale((double)p_37269_);
        this.setDeltaMovement(vec3);
        double d0 = vec3.horizontalDistance();
        this.setYRot((float)(Mth.atan2(vec3.x, vec3.z) * (double)(180F / (float)Math.PI)));
        this.setXRot((float)(Mth.atan2(vec3.y, d0) * (double)(180F / (float)Math.PI)));
        this.yRotO = this.getYRot();
        this.xRotO = this.getXRot();
    }

    protected void onHitBlock(BlockHitResult p_36755_) {
        this.discard();
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController(this, "controller",
                0, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return factory;
    }

    public static final RawAnimation LOOP = RawAnimation.begin().thenPlay("animation.model.loop");

    private <E extends GeoAnimatable> PlayState predicate(software.bernie.geckolib.core.animation.AnimationState event) {

        event.getController().setAnimation(LOOP);
        return PlayState.CONTINUE;

    }
}
