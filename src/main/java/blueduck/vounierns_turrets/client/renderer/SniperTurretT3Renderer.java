package blueduck.vounierns_turrets.client.renderer;

import blueduck.vounierns_turrets.VouniernTurrets;
import blueduck.vounierns_turrets.client.model.SniperTurretT2Model;
import blueduck.vounierns_turrets.client.model.SniperTurretT3Model;
import blueduck.vounierns_turrets.entity.SniperTurret;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SniperTurretT3Renderer extends GeoEntityRenderer<SniperTurret> {
    public SniperTurretT3Renderer(EntityRendererProvider.Context renderManager, AnimatedGeoModel<SniperTurret> modelProvider) {
        super(renderManager, modelProvider);
        this.shadowRadius = 0.4f;
    }
    public SniperTurretT3Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SniperTurretT3Model());
        this.shadowRadius = 0.4f;
    }

    @Override
    public ResourceLocation getTextureLocation(SniperTurret animatable) {
        return new ResourceLocation(VouniernTurrets.MODID, "textures/entity/sniper_turret_tier_3.png");

    }

    @Override
    public void render(SniperTurret animatable, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        //poseStack.translate(0, 1, 0);
        super.render(animatable, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
