package blueduck.vounierns_turrets.client.renderer;

import blueduck.vounierns_turrets.VouniernTurrets;
import blueduck.vounierns_turrets.client.model.LaserTurretT1Model;
import blueduck.vounierns_turrets.client.model.LaserTurretT2Model;
import blueduck.vounierns_turrets.entity.LaserTurret;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class LaserTurretT2Renderer extends GeoEntityRenderer<LaserTurret> {
    public LaserTurretT2Renderer(EntityRendererProvider.Context renderManager, GeoModel<LaserTurret> modelProvider) {
        super(renderManager, modelProvider);
        this.shadowRadius = 0.4f;
    }
    public LaserTurretT2Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new LaserTurretT2Model());
        this.shadowRadius = 0.4f;
    }

    @Override
    public ResourceLocation getTextureLocation(LaserTurret animatable) {
        return new ResourceLocation(VouniernTurrets.MODID, "textures/entity/laser_turret_tier_2.png");

    }


}
