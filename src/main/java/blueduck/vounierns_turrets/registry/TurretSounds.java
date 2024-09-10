package blueduck.vounierns_turrets.registry;

import blueduck.vounierns_turrets.VouniernTurrets;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TurretSounds {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS,
            VouniernTurrets.MODID);


    public static final RegistryObject<SoundEvent> TURRET_AMBIENT = SOUNDS.register("entity.turret.ambient", () -> new SoundEvent(new ResourceLocation(VouniernTurrets.MODID, "entity.turret.ambient")));
    public static final RegistryObject<SoundEvent> TURRET_PROPELLER = SOUNDS.register("entity.turret.propeller", () -> new SoundEvent(new ResourceLocation(VouniernTurrets.MODID, "entity.turret.propeller")));
    public static final RegistryObject<SoundEvent> TURRET_HURT = SOUNDS.register("entity.turret.hurt", () -> new SoundEvent(new ResourceLocation(VouniernTurrets.MODID, "entity.turret.hurt")));
    public static final RegistryObject<SoundEvent> TURRET_DEATH = SOUNDS.register("entity.turret.death", () -> new SoundEvent(new ResourceLocation(VouniernTurrets.MODID, "entity.turret.death")));

    public static final RegistryObject<SoundEvent> BASIC_TURRET_SHOOT = SOUNDS.register("entity.turret.basic_shoot", () -> new SoundEvent(new ResourceLocation(VouniernTurrets.MODID, "entity.turret.basic_shoot")));
    public static final RegistryObject<SoundEvent> SEED_TURRET_SHOOT = SOUNDS.register("entity.turret.seed_shoot", () -> new SoundEvent(new ResourceLocation(VouniernTurrets.MODID, "entity.turret.seed_shoot")));
    public static final RegistryObject<SoundEvent> SNIPER_TURRET_SHOOT = SOUNDS.register("entity.turret.sniper_shoot", () -> new SoundEvent(new ResourceLocation(VouniernTurrets.MODID, "entity.turret.sniper_shoot")));
    public static final RegistryObject<SoundEvent> LASER_TURRET_SHOOT = SOUNDS.register("entity.turret.laser_shoot", () -> new SoundEvent(new ResourceLocation(VouniernTurrets.MODID, "entity.turret.laser_shoot")));

}
