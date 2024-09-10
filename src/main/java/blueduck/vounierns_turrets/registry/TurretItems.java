package blueduck.vounierns_turrets.registry;

import blueduck.vounierns_turrets.VouniernTurrets;
import blueduck.vounierns_turrets.item.TurretItem;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TurretItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            VouniernTurrets.MODID);

    public static final RegistryObject<Item> BASIC_TURRET_CORE = ITEMS.register("basic_turret_core",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> SEED_TURRET_CORE = ITEMS.register("seed_turret_core",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> SNIPER_TURRET_CORE = ITEMS.register("sniper_turret_core",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> LASER_TURRET_CORE = ITEMS.register("laser_turret_core",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> BASIC_TURRET_T1 = ITEMS.register("basic_turret_t1",
            () -> new TurretItem(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT), TurretEntities.BASIC_TURRET_T1::get));

    public static final RegistryObject<Item> BASIC_TURRET_T2 = ITEMS.register("basic_turret_t2",
            () -> new TurretItem(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT), TurretEntities.BASIC_TURRET_T2::get));

    public static final RegistryObject<Item> BASIC_TURRET_T3 = ITEMS.register("basic_turret_t3",
            () -> new TurretItem(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT), TurretEntities.BASIC_TURRET_T3::get));


    public static final RegistryObject<Item> SEED_TURRET_T1 = ITEMS.register("seed_turret_t1",
            () -> new TurretItem(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT), TurretEntities.SEED_TURRET_T1::get));

    public static final RegistryObject<Item> SEED_TURRET_T2 = ITEMS.register("seed_turret_t2",
            () -> new TurretItem(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT), TurretEntities.SEED_TURRET_T2::get));

    public static final RegistryObject<Item> SEED_TURRET_T3 = ITEMS.register("seed_turret_t3",
            () -> new TurretItem(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT), TurretEntities.SEED_TURRET_T3::get));


    public static final RegistryObject<Item> SNIPER_TURRET_T1 = ITEMS.register("sniper_turret_t1",
            () -> new TurretItem(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT), TurretEntities.SNIPER_TURRET_T1::get));

    public static final RegistryObject<Item> SNIPER_TURRET_T2 = ITEMS.register("sniper_turret_t2",
            () -> new TurretItem(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT), TurretEntities.SNIPER_TURRET_T2::get));

    public static final RegistryObject<Item> SNIPER_TURRET_T3 = ITEMS.register("sniper_turret_t3",
            () -> new TurretItem(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT), TurretEntities.SNIPER_TURRET_T3::get));


    public static final RegistryObject<Item> LASER_TURRET_T1 = ITEMS.register("laser_turret_t1",
            () -> new TurretItem(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT), TurretEntities.LASER_TURRET_T1::get));

    public static final RegistryObject<Item> LASER_TURRET_T2 = ITEMS.register("laser_turret_t2",
            () -> new TurretItem(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT), TurretEntities.LASER_TURRET_T2::get));

    public static final RegistryObject<Item> LASER_TURRET_T3 = ITEMS.register("laser_turret_t3",
            () -> new TurretItem(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT), TurretEntities.LASER_TURRET_T3::get));

}
