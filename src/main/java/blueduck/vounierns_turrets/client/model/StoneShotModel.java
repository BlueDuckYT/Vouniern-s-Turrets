package blueduck.vounierns_turrets.client.model;

import blueduck.vounierns_turrets.VouniernTurrets;
import blueduck.vounierns_turrets.entity.projectile.StoneProjectile;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class StoneShotModel extends AnimatedGeoModel<StoneProjectile> {
    @Override
    public ResourceLocation getModelResource(StoneProjectile object) {
        return new ResourceLocation(VouniernTurrets.MODID, "geo/stone_shot.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(StoneProjectile object) {
        return new ResourceLocation(VouniernTurrets.MODID, "textures/entity/stone_shot.png");
    }

    @Override
    public ResourceLocation getAnimationResource(StoneProjectile animatable) {
        return new ResourceLocation(VouniernTurrets.MODID, "animations/stone_shot_animation.json");
    }
}
