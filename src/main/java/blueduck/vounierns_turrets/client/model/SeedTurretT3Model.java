package blueduck.vounierns_turrets.client.model;

import blueduck.vounierns_turrets.VouniernTurrets;
import blueduck.vounierns_turrets.entity.SeedTurret;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SeedTurretT3Model extends GeoModel<SeedTurret> {
    @Override
    public ResourceLocation getModelResource(SeedTurret object) {
        return new ResourceLocation(VouniernTurrets.MODID, "geo/seed_turret_tier_3.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SeedTurret object) {
        return new ResourceLocation(VouniernTurrets.MODID, "textures/entity/seed_turret_tier_3.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SeedTurret animatable) {
        return new ResourceLocation(VouniernTurrets.MODID, "animations/seed_turret_tier_3_animation.json");
    }
}
