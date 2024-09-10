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
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import javax.annotation.Nullable;

public class BasicTurretT2Renderer extends GeoEntityRenderer<BasicTurret> {
    public BasicTurretT2Renderer(EntityRendererProvider.Context renderManager, GeoModel<BasicTurret> modelProvider) {
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
    public RenderType getRenderType(BasicTurret animatable, ResourceLocation texture,
                                    @Nullable MultiBufferSource bufferSource,
                                    float partialTick) {
        return RenderType.entityTranslucent(new ResourceLocation(VouniernTurrets.MODID, "textures/entity/stone_turret_tier_2.png"));
    }
}
