package blueduck.vounierns_turrets.entity.projectile;

import blueduck.vounierns_turrets.entity.LaserTurret;
import blueduck.vounierns_turrets.entity.SeedTurret;
import blueduck.vounierns_turrets.registry.TurretEntities;
import net.minecraft.sounds.SoundEvents;
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
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class LaserProjectile extends ThrowableProjectile implements IAnimatable {

    private AnimationFactory factory = GeckoLibUtil.createFactory(this);

    private int damage = 3;

    public LaserProjectile(EntityType<? extends ThrowableProjectile> p_37466_, Level p_37467_) {
        super(p_37466_, p_37467_);
    }

    public LaserProjectile(Level p_37419_, LivingEntity p_37420_) {
        super(TurretEntities.LASER_PROJECTILE.get(), p_37420_, p_37419_);
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
        if (livingentity instanceof LaserTurret)
            damageToDeal = ((LaserTurret) livingentity).tier != 0 ? ((LaserTurret) livingentity).tier : 1;

        boolean flag =  entity.hurt(DamageSource.thrown(this, livingentity), damageToDeal);
        if (livingentity instanceof LaserTurret && ((LaserTurret) livingentity).tier >= 2)
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
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.model.loop", ILoopType.EDefaultLoopTypes.LOOP));
        return PlayState.CONTINUE;
    }
}
