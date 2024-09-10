package blueduck.vounierns_turrets.event;

import blueduck.vounierns_turrets.VouniernTurrets;
import blueduck.vounierns_turrets.entity.BasicTurret;
import blueduck.vounierns_turrets.entity.LaserTurret;
import blueduck.vounierns_turrets.entity.SeedTurret;
import blueduck.vounierns_turrets.entity.SniperTurret;
import blueduck.vounierns_turrets.registry.TurretEntities;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = VouniernTurrets.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(TurretEntities.BASIC_TURRET_T1.get(), BasicTurret.createT1Attributes().build());
        event.put(TurretEntities.BASIC_TURRET_T2.get(), BasicTurret.createT2Attributes().build());
        event.put(TurretEntities.BASIC_TURRET_T3.get(), BasicTurret.createT3Attributes().build());

        event.put(TurretEntities.SEED_TURRET_T1.get(), SeedTurret.createT1Attributes().build());
        event.put(TurretEntities.SEED_TURRET_T2.get(), SeedTurret.createT2Attributes().build());
        event.put(TurretEntities.SEED_TURRET_T3.get(), SeedTurret.createT3Attributes().build());

        event.put(TurretEntities.SNIPER_TURRET_T1.get(), SniperTurret.createT1Attributes().build());
        event.put(TurretEntities.SNIPER_TURRET_T2.get(), SniperTurret.createT2Attributes().build());
        event.put(TurretEntities.SNIPER_TURRET_T3.get(), SniperTurret.createT3Attributes().build());

        event.put(TurretEntities.LASER_TURRET_T1.get(), LaserTurret.createT1Attributes().build());
        event.put(TurretEntities.LASER_TURRET_T2.get(), LaserTurret.createT2Attributes().build());
        event.put(TurretEntities.LASER_TURRET_T3.get(), LaserTurret.createT3Attributes().build());
    }

}
