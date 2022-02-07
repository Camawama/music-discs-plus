package com.camawama.musicdiscsplus;

import com.camawama.musicdiscsplus.item.MDPItems;
import com.camawama.musicdiscsplus.sound.MDPSoundEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MusicDiscsPlus.MOD_ID)
public class MusicDiscsPlus {
    public static final String MOD_ID = "musicdiscsplus";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public MusicDiscsPlus() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register SoundEvents
        MDPSoundEvents.SOUND_EVENTS.register(modEventBus);
        // Register Items
        MDPItems.ITEMS.register(modEventBus);

        // Register the setup method for modloading
        modEventBus.addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
    }

    /**
     * Helper method for getting files or registering Items/Mobs/SoundEvents/etc for the mod.
     */
    public static ResourceLocation locate(String name) {
        return new ResourceLocation(MOD_ID, name);
    }
}
