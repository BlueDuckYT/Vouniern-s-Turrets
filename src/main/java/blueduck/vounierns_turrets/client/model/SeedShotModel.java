package blueduck.vounierns_turrets.client.model;

import blueduck.vounierns_turrets.VouniernTurrets;
import blueduck.vounierns_turrets.entity.projectile.SeedProjectile;
import blueduck.vounierns_turrets.entity.projectile.StoneProjectile;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SeedShotModel extends GeoModel<SeedProjectile> {
    @Override
    public ResourceLocation getModelResource(SeedProjectile object) {
        return new ResourceLocation(VouniernTurrets.MODID, "geo/seed_shot.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SeedProjectile object) {
        return new ResourceLocation(VouniernTurrets.MODID, "textures/entity/seed_shot.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SeedProjectile animatable) {
        return new ResourceLocation(VouniernTurrets.MODID, "animations/seed_shot_animation.json");
    }
}
