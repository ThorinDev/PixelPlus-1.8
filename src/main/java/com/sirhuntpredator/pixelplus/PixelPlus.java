package com.sirhuntpredator.pixelplus;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sirhuntpredator.pixelplus.command.AddTransacationCommand;
import com.sirhuntpredator.pixelplus.command.CplayCommand;
import com.sirhuntpredator.pixelplus.command.GuiRemoveCommand;
import com.sirhuntpredator.pixelplus.command.HudStateSetCommand;
import com.sirhuntpredator.pixelplus.command.ModularGuiCommand;
import com.sirhuntpredator.pixelplus.command.ViewTransacationsCommand;
import com.sirhuntpredator.pixelplus.hud.BasicInfoHud;
import com.sirhuntpredator.pixelplus.hud.EffectHud;
import com.sirhuntpredator.pixelplus.hud.HudRegistry;
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
    private static boolean areBasicsAdded = false;
	@EventHandler
	public void init(FMLPreInitializationEvent event) throws Exception
	{
		instance = this;
		MinecraftForge.EVENT_BUS.register(this);
		FMLCommonHandler.instance().bus().register(this);
		
	}
	@EventHandler
	public void init(FMLPostInitializationEvent event)
	{
		ClientCommandHandler.instance.registerCommand(new CplayCommand());
		ClientCommandHandler.instance.registerCommand(new GuiRemoveCommand());
		ClientCommandHandler.instance.registerCommand(new ModularGuiCommand());
		ClientCommandHandler.instance.registerCommand(new HudStateSetCommand());
		ClientCommandHandler.instance.registerCommand(new AddTransacationCommand());
		ClientCommandHandler.instance.registerCommand(new ViewTransacationsCommand());
		
	}
    @EventHandler
    public void init(FMLInitializationEvent event) throws Exception
    {
    	this.LOGGER = LogManager.getLogger("ChromaPixel");
    	HudRegistry.registerHud(new BasicInfoHud());
    	HudRegistry.registerHud(new EffectHud());
    	
        
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
		
		try {
			if(Minecraft.getMinecraft().getCurrentServerData() != null || (Minecraft.getMinecraft().theWorld != null && Minecraft.getMinecraft().theWorld.isRemote)){

				if ((!Minecraft.getMinecraft().gameSettings.showDebugInfo) && (Minecraft.getMinecraft().inGameHasFocus) && (!(Minecraft.getMinecraft().currentScreen instanceof GuiChat))) {
				 new BasicInfoHud().render();	
				 new EffectHud().render();
				 if(!isBasicsAdded){
					 GuiUtils.addBasicsToList(Minecraft.getMinecraft().thePlayer.getName());
					 isBasicsAdded = true;
				 }
				}
			}
		} catch(Exception e) {
			logWarn("An exception occured in onRenderTick(). Stacktrace below.");
			e.printStackTrace();
		}
	}
}
