package blueduck.vounierns_turrets.registry;

import blueduck.vounierns_turrets.VouniernTurrets;
import blueduck.vounierns_turrets.entity.BasicTurret;
import blueduck.vounierns_turrets.entity.LaserTurret;
import blueduck.vounierns_turrets.entity.SeedTurret;
import blueduck.vounierns_turrets.entity.SniperTurret;
import blueduck.vounierns_turrets.entity.projectile.LaserProjectile;
import blueduck.vounierns_turrets.entity.projectile.SeedProjectile;
import blueduck.vounierns_turrets.entity.projectile.StoneProjectile;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TurretEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES,
            VouniernTurrets.MODID);


    public static final RegistryObject<EntityType<BasicTurret>> BASIC_TURRET_T1 = ENTITIES.register("basic_turret_t1",
            () -> EntityType.Builder.of(BasicTurret::new, MobCategory.MISC).sized(0.85f, 1.1f)
                    .build(new ResourceLocation(VouniernTurrets.MODID, "basic_turret_t1").toString()));

    public static final RegistryObject<EntityType<BasicTurret>> BASIC_TURRET_T2 = ENTITIES.register("basic_turret_t2",
            () -> EntityType.Builder.of(BasicTurret::new, MobCategory.MISC).sized(0.85f, 1.3f)
                    .build(new ResourceLocation(VouniernTurrets.MODID, "basic_turret_t2").toString()));

    public static final RegistryObject<EntityType<BasicTurret>> BASIC_TURRET_T3 = ENTITIES.register("basic_turret_t3",
            () -> EntityType.Builder.of(BasicTurret::new, MobCategory.MISC).sized(0.85f, 1.5f)
                    .build(new ResourceLocation(VouniernTurrets.MODID, "basic_turret_t3").toString()));

    public static final RegistryObject<EntityType<SeedTurret>> SEED_TURRET_T1 = ENTITIES.register("seed_turret_t1",
            () -> EntityType.Builder.of(SeedTurret::new, MobCategory.MISC).sized(0.85f, 1.3f)
                    .build(new ResourceLocation(VouniernTurrets.MODID, "seed_turret_t1").toString()));

    public static final RegistryObject<EntityType<SeedTurret>> SEED_TURRET_T2 = ENTITIES.register("seed_turret_t2",
            () -> EntityType.Builder.of(SeedTurret::new, MobCategory.MISC).sized(0.85f, 1.3f)
                    .build(new ResourceLocation(VouniernTurrets.MODID, "seed_turret_t2").toString()));

    public static final RegistryObject<EntityType<SeedTurret>> SEED_TURRET_T3 = ENTITIES.register("seed_turret_t3",
            () -> EntityType.Builder.of(SeedTurret::new, MobCategory.MISC).sized(0.85f, 1.3f)
                    .build(new ResourceLocation(VouniernTurrets.MODID, "seed_turret_t3").toString()));

    public static final RegistryObject<EntityType<SniperTurret>> SNIPER_TURRET_T1 = ENTITIES.register("sniper_turret_t1",
            () -> EntityType.Builder.of(SniperTurret::new, MobCategory.MISC).sized(0.85f, 1.6f)
                    .build(new ResourceLocation(VouniernTurrets.MODID, "sniper_turret_t1").toString()));

    public static final RegistryObject<EntityType<SniperTurret>> SNIPER_TURRET_T2 = ENTITIES.register("sniper_turret_t2",
            () -> EntityType.Builder.of(SniperTurret::new, MobCategory.MISC).sized(0.85f, 1.6f)
                    .build(new ResourceLocation(VouniernTurrets.MODID, "sniper_turret_t2").toString()));

    public static final RegistryObject<EntityType<SniperTurret>> SNIPER_TURRET_T3 = ENTITIES.register("sniper_turret_t3",
            () -> EntityType.Builder.of(SniperTurret::new, MobCategory.MISC).sized(0.85f, 1.8f)
                    .build(new ResourceLocation(VouniernTurrets.MODID, "sniper_turret_t3").toString()));

    public static final RegistryObject<EntityType<LaserTurret>> LASER_TURRET_T1 = ENTITIES.register("laser_turret_t1",
            () -> EntityType.Builder.of(LaserTurret::new, MobCategory.MISC).sized(0.85f, 1.2f)
                    .build(new ResourceLocation(VouniernTurrets.MODID, "laser_turret_t1").toString()));

    public static final RegistryObject<EntityType<LaserTurret>> LASER_TURRET_T2 = ENTITIES.register("laser_turret_t2",
            () -> EntityType.Builder.of(LaserTurret::new, MobCategory.MISC).sized(0.925f, 1.2f)
                    .build(new ResourceLocation(VouniernTurrets.MODID, "laser_turret_t2").toString()));

    public static final RegistryObject<EntityType<LaserTurret>> LASER_TURRET_T3 = ENTITIES.register("laser_turret_t3",
            () -> EntityType.Builder.of(LaserTurret::new, MobCategory.MISC).sized(0.925f, 1.2f)
                    .build(new ResourceLocation(VouniernTurrets.MODID, "laser_turret_t3").toString()));


    public static final RegistryObject<EntityType<StoneProjectile>> STONE_PROJECTILE = ENTITIES.register("stone_shot",
            () -> EntityType.Builder.<StoneProjectile>of(StoneProjectile::new, MobCategory.MISC).sized(.6f, .6f)
                    .build(new ResourceLocation(VouniernTurrets.MODID, "stone_shot").toString()));

    public static final RegistryObject<EntityType<SeedProjectile>> SEED_PROJECTILE = ENTITIES.register("seed_shot",
            () -> EntityType.Builder.<SeedProjectile>of(SeedProjectile::new, MobCategory.MISC).sized(.3f, .3f)
                    .build(new ResourceLocation(VouniernTurrets.MODID, "seed_shot").toString()));

    public static final RegistryObject<EntityType<LaserProjectile>> LASER_PROJECTILE = ENTITIES.register("laser_shot",
            () -> EntityType.Builder.<LaserProjectile>of(LaserProjectile::new, MobCategory.MISC).sized(.3f, .3f)
                    .build(new ResourceLocation(VouniernTurrets.MODID, "laser_shot").toString()));
}
