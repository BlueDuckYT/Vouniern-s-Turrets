package blueduck.vounierns_turrets.client.renderer;

import blueduck.vounierns_turrets.VouniernTurrets;
import blueduck.vounierns_turrets.client.model.SeedShotModel;
import blueduck.vounierns_turrets.client.model.StoneShotModel;
import blueduck.vounierns_turrets.entity.projectile.SeedProjectile;
import blueduck.vounierns_turrets.entity.projectile.StoneProjectile;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;

public class SeedShotRenderer extends GeoProjectilesRenderer<SeedProjectile> {
    public SeedShotRenderer(EntityRendererProvider.Context context) {
        super(context, new SeedShotModel());
    }

    @Override
    public ResourceLocation getTextureLocation(SeedProjectile pEntity) {
        return new ResourceLocation(VouniernTurrets.MODID, "textures/entity/seed_shot.png");
    }

    public void render(SeedProjectile p_116085_, float p_116086_, float p_116087_, PoseStack p_116088_, MultiBufferSource p_116089_, int p_116090_) {
       super.render(p_116085_,p_116086_,p_116087_,p_116088_,p_116089_,p_116090_);
    }

}