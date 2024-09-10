package blueduck.vounierns_turrets.client.renderer;

import blueduck.vounierns_turrets.VouniernTurrets;
import blueduck.vounierns_turrets.client.model.SeedTurretT2Model;
import blueduck.vounierns_turrets.client.model.SeedTurretT3Model;
import blueduck.vounierns_turrets.entity.SeedTurret;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SeedTurretT3Renderer extends GeoEntityRenderer<SeedTurret> {
    public SeedTurretT3Renderer(EntityRendererProvider.Context renderManager, AnimatedGeoModel<SeedTurret> modelProvider) {
        super(renderManager, modelProvider);
        this.shadowRadius = 0.4f;
    }
    public SeedTurretT3Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SeedTurretT3Model());
        this.shadowRadius = 0.4f;
    }

    @Override
    public ResourceLocation getTextureLocation(SeedTurret animatable) {
        return new ResourceLocation(VouniernTurrets.MODID, "textures/entity/seed_turret_tier_3.png");

    }


}
