package com.camawama.musicdiscsplus.item;

import com.camawama.musicdiscsplus.MusicDiscsPlus;
import com.camawama.musicdiscsplus.sound.MDPSoundEvents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

/**
 * We will use this class to create Items.
 *
 * Every Item will need a model, texture and translation in the language file.
 *
 * Items can also be added to ItemTags, like we've done with the music discs.
 * (We've added the 'Summer' music disc to our own 'music_discs' Tag. Then we add all our music discs in that Tag to the ItemTag that Minecraft uses.)
 * (We've also added our music discs to the Tag 'creeper_drop_music_discs'. This should cause Creepers to drop our music discs.)
 */
public class MDPItems {
    // We call this in the main mod class to register all the Items at the right time.
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MusicDiscsPlus.MOD_ID);

    // Register the Item for the 'Summer' music disc.
    public static final RegistryObject<Item> MUSIC_DISC_SUMMER = registerMusicDisc("music_disc_summer", 1, () -> MDPSoundEvents.MUSIC_DISC_SUMMER.get());
    public static final RegistryObject<Item> MUSIC_DISC_CLIMB = registerMusicDisc("music_disc_climb", 1, () -> MDPSoundEvents.MUSIC_DISC_CLIMB.get());
    public static final RegistryObject<Item> MUSIC_DISC_SYNERGY = registerMusicDisc("music_disc_synergy", 1, () -> MDPSoundEvents.MUSIC_DISC_SYNERGY.get());
    public static final RegistryObject<Item> MUSIC_DISC_JUKEBOX = registerMusicDisc("music_disc_jukebox", 1, () -> MDPSoundEvents.MUSIC_DISC_JUKEBOX.get());
    public static final RegistryObject<Item> MUSIC_DISC_MAYBE = registerMusicDisc("music_disc_maybe", 1, () -> MDPSoundEvents.MUSIC_DISC_MAYBE.get());
    public static final RegistryObject<Item> MUSIC_DISC_ZWELT = registerMusicDisc("music_disc_zwelt", 1, () -> MDPSoundEvents.MUSIC_DISC_ZWELT.get());
    public static final RegistryObject<Item> MUSIC_DISC_FLIGHT = registerMusicDisc("music_disc_flight", 1, () -> MDPSoundEvents.MUSIC_DISC_FLIGHT.get());
    // More music discs can go here...

    /**
     * Helper method for registering all music discs.
     * The registry name must be the same as the name of all the related files.
     *
     * @param comparatorStrength The value this music disc should output on the comparator. Must be between 0 and 15.
     */
    private static RegistryObject<Item> registerMusicDisc(String registryName, int comparatorStrength, Supplier<SoundEvent> soundEvent) {
        // Create a new music disc with the registry name and correct SoundEvent.
        RecordItem musicDisc = new RecordItem(comparatorStrength, soundEvent, (new Item.Properties()).stacksTo(1).tab(MDPTab.DISC_TAB).rarity(Rarity.RARE));
        // Register this music disc with the registry name.
        return registerItem(registryName, musicDisc);
    }

    /**
     * Helper method for registering all Items.
     */
    private static RegistryObject<Item> registerItem(String registryName, Item item) {
        // Register this Item with the registry name.
        return ITEMS.register(registryName, () -> item);
    }
}
