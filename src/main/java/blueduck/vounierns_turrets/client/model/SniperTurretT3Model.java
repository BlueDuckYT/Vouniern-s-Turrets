package blueduck.vounierns_turrets.client.model;

import blueduck.vounierns_turrets.VouniernTurrets;
import blueduck.vounierns_turrets.entity.SniperTurret;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SniperTurretT3Model extends GeoModel<SniperTurret> {
    @Override
    public ResourceLocation getModelResource(SniperTurret object) {
        return new ResourceLocation(VouniernTurrets.MODID, "geo/sniper_turret_tier_3.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SniperTurret object) {
        return new ResourceLocation(VouniernTurrets.MODID, "textures/entity/sniper_turret_tier_3.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SniperTurret animatable) {
        return new ResourceLocation(VouniernTurrets.MODID, "animations/sniper_turret_tier_3_animation.json");
    }
}
