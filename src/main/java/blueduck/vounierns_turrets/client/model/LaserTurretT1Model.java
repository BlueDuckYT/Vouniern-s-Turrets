package blueduck.vounierns_turrets.client.model;

import blueduck.vounierns_turrets.VouniernTurrets;
import blueduck.vounierns_turrets.entity.LaserTurret;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class LaserTurretT1Model extends GeoModel<LaserTurret> {
    @Override
    public ResourceLocation getModelResource(LaserTurret object) {
        return new ResourceLocation(VouniernTurrets.MODID, "geo/laser_turret_tier_1.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LaserTurret object) {
        return new ResourceLocation(VouniernTurrets.MODID, "textures/entity/laser_turret_tier_1.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LaserTurret animatable) {
        return new ResourceLocation(VouniernTurrets.MODID, "animations/laser_turret_animation.json");
    }
}
