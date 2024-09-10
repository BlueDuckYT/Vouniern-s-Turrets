package blueduck.vounierns_turrets.client.renderer;

import blueduck.vounierns_turrets.VouniernTurrets;
import blueduck.vounierns_turrets.client.model.BasicTurretT1Model;
import blueduck.vounierns_turrets.client.model.SeedTurretT1Model;
import blueduck.vounierns_turrets.entity.BasicTurret;
import blueduck.vounierns_turrets.entity.SeedTurret;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SeedTurretT1Renderer extends GeoEntityRenderer<SeedTurret> {
    public SeedTurretT1Renderer(EntityRendererProvider.Context renderManager, GeoModel<SeedTurret> modelProvider) {
        super(renderManager, modelProvider);
        this.shadowRadius = 0.4f;
    }
    public SeedTurretT1Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SeedTurretT1Model());
        this.shadowRadius = 0.4f;
    }

    @Override
    public ResourceLocation getTextureLocation(SeedTurret animatable) {
        return new ResourceLocation(VouniernTurrets.MODID, "textures/entity/seed_turret_tier_1.png");

    }


}
