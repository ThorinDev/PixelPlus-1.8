package com.sirhuntpredator.pixelplus.config;

import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public class ConfigUtils {
	public static int basicInfoHudMainColor = 13;
	public static int basicInfoHudItemColor = 6;
	public static Configuration config;
	public static void preInit(FMLPreInitializationEvent event)
	{
	       config = new Configuration(event.getSuggestedConfigurationFile());

           config.load();

           Property basicInfoHudMainColorPro = config.get(Configuration.CATEGORY_GENERAL, "InfoHudMainColor", 13);
           basicInfoHudMainColorPro.comment = "Main color of the Info HUD.";
           basicInfoHudMainColor = basicInfoHudMainColorPro.getInt(13);

           Property basicInfoHudItemColorPro = config.get(Configuration.CATEGORY_GENERAL, "InfoHudItemColor", 6);
           basicInfoHudItemColorPro.comment = "Item color of the Info HUD.";
           basicInfoHudItemColor = basicInfoHudItemColorPro.getInt(6);
           
           config.save();
	}
	public static EnumChatFormatting getColorFromConfig(int id)
	{
		switch(id)
		{
			case 0:
				return EnumChatFormatting.BLACK;
				
			case 1:
				return EnumChatFormatting.DARK_BLUE;
				
			case 2:
				return EnumChatFormatting.DARK_GREEN;
				
			case 3:
				return EnumChatFormatting.DARK_AQUA;
				
			case 4:
				return EnumChatFormatting.DARK_RED;
				
			case 5:
				return EnumChatFormatting.DARK_PURPLE;
				
			case 6:
				return EnumChatFormatting.GOLD;
				
			case 7:
				return EnumChatFormatting.GRAY;
			 
			case 8:
				return EnumChatFormatting.DARK_GRAY;
				
			case 9:
				return EnumChatFormatting.BLUE;
				
			case 10:
				return EnumChatFormatting.GREEN; //a
				
			case 11:
				return EnumChatFormatting.AQUA; //b
				
			case 12:
				return EnumChatFormatting.RED; //c
				
			case 13:
				return EnumChatFormatting.LIGHT_PURPLE; //d
				
			case 14:
				return EnumChatFormatting.YELLOW; //e
				
			case 15:
				return EnumChatFormatting.WHITE; //f
				
			default:
				
		}
		return EnumChatFormatting.RESET;
	}

}
