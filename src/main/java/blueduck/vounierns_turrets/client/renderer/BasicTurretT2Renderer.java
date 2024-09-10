package blueduck.vounierns_turrets.client.renderer;

import blueduck.vounierns_turrets.VouniernTurrets;
import blueduck.vounierns_turrets.client.model.BasicTurretT1Model;
import blueduck.vounierns_turrets.client.model.BasicTurretT2Model;
import blueduck.vounierns_turrets.entity.BasicTurret;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BasicTurretT2Renderer extends GeoEntityRenderer<BasicTurret> {
    public BasicTurretT2Renderer(EntityRendererProvider.Context renderManager, AnimatedGeoModel<BasicTurret> modelProvider) {
        super(renderManager, modelProvider);
        this.shadowRadius = 0.4f;
    }
    public BasicTurretT2Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BasicTurretT2Model());
        this.shadowRadius = 0.4f;
    }

    @Override
    public ResourceLocation getTextureLocation(BasicTurret animatable) {
        return new ResourceLocation(VouniernTurrets.MODID, "textures/entity/stone_turret_tier_2.png");
    }

    @Override
    public RenderType getRenderType(BasicTurret animatable, float partialTick, PoseStack poseStack, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, int packedLight, ResourceLocation texture) {
        return RenderType.entityTranslucent(new ResourceLocation(VouniernTurrets.MODID, "textures/entity/stone_turret_tier_2.png"));
    }
}
