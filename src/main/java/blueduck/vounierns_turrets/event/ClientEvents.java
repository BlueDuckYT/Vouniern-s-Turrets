package blueduck.vounierns_turrets.event;

import blueduck.vounierns_turrets.VouniernTurrets;
import blueduck.vounierns_turrets.client.renderer.*;
import blueduck.vounierns_turrets.registry.TurretEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = VouniernTurrets.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {



    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(TurretEntities.BASIC_TURRET_T1.get(), BasicTurretT1Renderer::new);
        event.registerEntityRenderer(TurretEntities.BASIC_TURRET_T2.get(), BasicTurretT2Renderer::new);
        event.registerEntityRenderer(TurretEntities.BASIC_TURRET_T3.get(), BasicTurretT3Renderer::new);

        event.registerEntityRenderer(TurretEntities.SEED_TURRET_T1.get(), SeedTurretT1Renderer::new);
        event.registerEntityRenderer(TurretEntities.SEED_TURRET_T2.get(), SeedTurretT2Renderer::new);
        event.registerEntityRenderer(TurretEntities.SEED_TURRET_T3.get(), SeedTurretT3Renderer::new);

        event.registerEntityRenderer(TurretEntities.SNIPER_TURRET_T1.get(), SniperTurretT1Renderer::new);
        event.registerEntityRenderer(TurretEntities.SNIPER_TURRET_T2.get(), SniperTurretT2Renderer::new);
        event.registerEntityRenderer(TurretEntities.SNIPER_TURRET_T3.get(), SniperTurretT3Renderer::new);

        event.registerEntityRenderer(TurretEntities.LASER_TURRET_T1.get(), LaserTurretT1Renderer::new);
        event.registerEntityRenderer(TurretEntities.LASER_TURRET_T2.get(), LaserTurretT2Renderer::new);
        event.registerEntityRenderer(TurretEntities.LASER_TURRET_T3.get(), LaserTurretT3Renderer::new);

        event.registerEntityRenderer(TurretEntities.STONE_PROJECTILE.get(), StoneShotRenderer::new);
        event.registerEntityRenderer(TurretEntities.SEED_PROJECTILE.get(), SeedShotRenderer::new);
        event.registerEntityRenderer(TurretEntities.LASER_PROJECTILE.get(), LaserShotRenderer::new);
    }

}
