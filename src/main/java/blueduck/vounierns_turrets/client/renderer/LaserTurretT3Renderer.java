package blueduck.vounierns_turrets.client.renderer;

import blueduck.vounierns_turrets.VouniernTurrets;
import blueduck.vounierns_turrets.client.model.LaserTurretT1Model;
import blueduck.vounierns_turrets.client.model.LaserTurretT3Model;
import blueduck.vounierns_turrets.entity.LaserTurret;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class LaserTurretT3Renderer extends GeoEntityRenderer<LaserTurret> {
    public LaserTurretT3Renderer(EntityRendererProvider.Context renderManager, AnimatedGeoModel<LaserTurret> modelProvider) {
        super(renderManager, modelProvider);
        this.shadowRadius = 0.4f;
    }
    public LaserTurretT3Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new LaserTurretT3Model());
        this.shadowRadius = 0.4f;
    }

    @Override
    public ResourceLocation getTextureLocation(LaserTurret animatable) {
        return new ResourceLocation(VouniernTurrets.MODID, "textures/entity/laser_turret_tier_3.png");

    }


}
