package com.camawama.musicdiscsplus.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class MDPTab {
    public static final CreativeModeTab DISC_TAB = new CreativeModeTab("disctab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(MDPItems.MUSIC_DISC_CLIMB.get());
        }
    };
}
