package com.camawama.musicdiscsplus.sound;

import com.camawama.musicdiscsplus.MusicDiscsPlus;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * We will use this class to create SoundEvents.
 *
 * All SoundEvents must also be in the 'sounds.json' file. (Use the wiki and Forge Documentation to help you with this)
 * The actual files must be in .ogg format.
 */
public class MDPSoundEvents {
    // We call this in the main mod class to register all the SoundEvents at the right time.
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MusicDiscsPlus.MOD_ID);

    // Register the 'Summer' music disc.
    public static final RegistryObject<SoundEvent> MUSIC_DISC_SUMMER = registerSoundEvent("music_disc.summer");
    public static final RegistryObject<SoundEvent> MUSIC_DISC_SYNERGY = registerSoundEvent("music_disc.synergy");
    public static final RegistryObject<SoundEvent> MUSIC_DISC_ZWELT = registerSoundEvent("music_disc.zwelt");
    public static final RegistryObject<SoundEvent> MUSIC_DISC_MAYBE = registerSoundEvent("music_disc.maybe");
    public static final RegistryObject<SoundEvent> MUSIC_DISC_JUKEBOX = registerSoundEvent("music_disc.jukebox");
    public static final RegistryObject<SoundEvent> MUSIC_DISC_CLIMB = registerSoundEvent("music_disc.climb");
    public static final RegistryObject<SoundEvent> MUSIC_DISC_FLIGHT = registerSoundEvent("music_disc.flight");
    // More discs go here...

    /**
     * Helper method for registering all SoundEvents.
     * The registry name must be the same as the name of the SoundEvent in the 'sound.json' file.
     *
     * I like using these to make coding easier for myself.
     */
    private static RegistryObject<SoundEvent> registerSoundEvent(String registryName) {
        // Create a new SoundEvent with the registry name.
        SoundEvent soundEvent = new SoundEvent(MusicDiscsPlus.locate(registryName));
        // Register this SoundEvent with the registry name.
        return SOUND_EVENTS.register(registryName, () -> soundEvent);
    }
}
