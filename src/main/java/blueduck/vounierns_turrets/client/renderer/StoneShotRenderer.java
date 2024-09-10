package blueduck.vounierns_turrets.client.renderer;

import blueduck.vounierns_turrets.VouniernTurrets;
import blueduck.vounierns_turrets.client.model.StoneShotModel;
import blueduck.vounierns_turrets.entity.projectile.StoneProjectile;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class StoneShotRenderer extends GeoEntityRenderer<StoneProjectile> {
    public StoneShotRenderer(EntityRendererProvider.Context context) {
        super(context, new StoneShotModel());
    }

    @Override
    public ResourceLocation getTextureLocation(StoneProjectile pEntity) {
        return new ResourceLocation(VouniernTurrets.MODID, "textures/entity/stone_shot.png");
    }

    public void render(StoneProjectile p_116085_, float p_116086_, float p_116087_, PoseStack p_116088_, MultiBufferSource p_116089_, int p_116090_) {
       super.render(p_116085_,p_116086_,p_116087_,p_116088_,p_116089_,p_116090_);
    }

}