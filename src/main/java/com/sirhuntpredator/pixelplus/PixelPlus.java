package com.sirhuntpredator.pixelplus;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = PixelPlus.MODID, version = PixelPlus.VERSION, name = PixelPlus.NAME)
public class PixelPlus
{
    public static final String MODID = "PixelPlus";
    public static final String VERSION = "1.0";
    public static final String NAME = "PixelPlus";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    }
}
