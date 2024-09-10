package blueduck.vounierns_turrets.client.model;

import blueduck.vounierns_turrets.VouniernTurrets;
import blueduck.vounierns_turrets.entity.SniperTurret;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SniperTurretT2Model extends GeoModel<SniperTurret> {
    @Override
    public ResourceLocation getModelResource(SniperTurret object) {
        return new ResourceLocation(VouniernTurrets.MODID, "geo/sniper_turret_tier_2.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SniperTurret object) {
        return new ResourceLocation(VouniernTurrets.MODID, "textures/entity/sniper_turret_tier_2.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SniperTurret animatable) {
        return new ResourceLocation(VouniernTurrets.MODID, "animations/sniper_turret_animation.json");
    }
}
