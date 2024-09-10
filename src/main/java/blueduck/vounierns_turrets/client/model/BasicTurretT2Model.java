package blueduck.vounierns_turrets.client.model;

import blueduck.vounierns_turrets.VouniernTurrets;
import blueduck.vounierns_turrets.entity.BasicTurret;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BasicTurretT2Model extends GeoModel<BasicTurret> {
    @Override
    public ResourceLocation getModelResource(BasicTurret object) {
        return new ResourceLocation(VouniernTurrets.MODID, "geo/stone_turret_tier_2.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BasicTurret object) {
        return new ResourceLocation(VouniernTurrets.MODID, "textures/entity/stone_turret_tier_2.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BasicTurret animatable) {
        return new ResourceLocation(VouniernTurrets.MODID, "animations/turret_animation.json");
    }
}
