package com.sirhuntpredator.pixelplus;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sirhuntpredator.pixelplus.hud.BasicInfoHud;
import com.sirhuntpredator.pixelplus.hud.modular.GuiUtils;

@Mod(modid = PixelPlus.MODID, version = PixelPlus.VERSION, name = PixelPlus.NAME)
public class PixelPlus
{
    public static final String MODID = "PixelPlus";
    public static final String VERSION = "1.0";
    public static final String NAME = "PixelPlus";
	public static final boolean IS_DEBUGGING = false;
	private Logger LOGGER;
	private static PixelPlus instance;
    
	@EventHandler
	public void init(FMLPreInitializationEvent event)
	{
		instance = this;
		GuiUtils.addBasicsToList();
		MinecraftForge.EVENT_BUS.register(this);
		FMLCommonHandler.instance().bus().register(this);
	}
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	this.LOGGER = LogManager.getLogger("ChromaPixel");
        
    }
	public static PixelPlus instance() {
		return instance;
	}

	public void logDebug(String s) {
		if(IS_DEBUGGING) {
			this.LOGGER.info("[DEBUG] "  + s);
		}
	}

	public void logInfo(String s) {
		this.LOGGER.info(s);
	}

	public void logWarn(String s) {
		this.LOGGER.warn(s);
	}
	@SubscribeEvent
	public void onClientTick(ClientTickEvent event) {
		try {
			if(Minecraft.getMinecraft().inGameHasFocus) {  
							
			}  
		}
		catch(Exception e) {
			logWarn("An exception occured in onClientTick(). Stacktrace below.");
			e.printStackTrace();
		}
	}
	

	@SubscribeEvent
	public void onRenderTick(RenderTickEvent event)
	{
		//PixelPlus.instance().logInfo("Working!");
		try {
			if(Minecraft.getMinecraft().getCurrentServerData() != null || (Minecraft.getMinecraft().theWorld != null && Minecraft.getMinecraft().theWorld.isRemote)){

				if ((!Minecraft.getMinecraft().gameSettings.showDebugInfo) && (Minecraft.getMinecraft().inGameHasFocus) && (!(Minecraft.getMinecraft().currentScreen instanceof GuiChat))) {
				 new BasicInfoHud().render();	
				}
			}
		} catch(Exception e) {
			logWarn("An exception occured in onRenderTick(). Stacktrace below.");
			e.printStackTrace();
		}
	}
}
