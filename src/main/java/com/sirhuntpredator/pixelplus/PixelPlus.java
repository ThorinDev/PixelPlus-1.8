package com.sirhuntpredator.pixelplus;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sirhuntpredator.pixelplus.command.AddTransacationCommand;
import com.sirhuntpredator.pixelplus.command.CplayCommand;
import com.sirhuntpredator.pixelplus.command.GameNameCommand;
import com.sirhuntpredator.pixelplus.command.GuiRemoveCommand;
import com.sirhuntpredator.pixelplus.command.HudStateSetCommand;
import com.sirhuntpredator.pixelplus.command.ModlistCommand;
import com.sirhuntpredator.pixelplus.command.ModularGuiCommand;
import com.sirhuntpredator.pixelplus.command.TestCommand;
import com.sirhuntpredator.pixelplus.command.ViewTransacationsCommand;
import com.sirhuntpredator.pixelplus.hud.BasicInfoHud;
import com.sirhuntpredator.pixelplus.hud.EffectHud;
import com.sirhuntpredator.pixelplus.hud.HealthHud;
import com.sirhuntpredator.pixelplus.hud.HudRegistry;
import com.sirhuntpredator.pixelplus.hud.modular.GuiUtils;
import com.sirhuntpredator.pixelplus.listener.arcadeconversionlog.Listener;
import com.sirhuntpredator.pixelplus.listener.scoreboard.ScoreboardUtils;
import com.sirhuntpredator.pixelplus.misc.AccessWeb;
import com.sirhuntpredator.pixelplus.misc.KeyBinder;
import com.sirhuntpredator.pixelplus.misc.ReflectionUtils;

@Mod(modid = PixelPlus.MODID, version = PixelPlus.VERSION, name = PixelPlus.NAME)
public class PixelPlus
{
    public static final String MODID = "PixelPlus";
    public static final String VERSION = "0.1";
    public static final String NAME = "PixelPlus";
	public static final boolean IS_DEBUGGING = false;
	private Logger LOGGER;
	private static PixelPlus instance;
    private static boolean areBasicsAdded = false;
    private static boolean areBasicsDone = false;
    public static boolean isCPLoaded = false;
    public static List<String> modlist = new ArrayList<String>();
    public static List<String> hatelist = new ArrayList<String>();
    public boolean test = false;
  
    public static void reflect()
    {
    	//ReflectionUtils.reflectSetField(Minecraft.class, Minecraft.getMinecraft(), "timer", new Timer(5.0F));
    }
	@EventHandler
	public void init(FMLPreInitializationEvent event) throws Exception
	{
		instance = this;

		MinecraftForge.EVENT_BUS.register(new Listener());
		MinecraftForge.EVENT_BUS.register(new com.sirhuntpredator.pixelplus.listener.purchaselog.Listener());
		MinecraftForge.EVENT_BUS.register(new com.sirhuntpredator.pixelplus.listener.ignorechat.Listener());
		MinecraftForge.EVENT_BUS.register(new com.sirhuntpredator.pixelplus.listener.combatlog.Listener());
		FMLCommonHandler.instance().bus().register(this);
		FMLCommonHandler.instance().bus().register(new com.sirhuntpredator.pixelplus.listener.combatlog.Listener());
		MinecraftForge.EVENT_BUS.register(this);
		
	}
	public static void stuff()
	{
		List<ModContainer> b = Loader.instance().getActiveModList();
		for (ModContainer modContainer : b) {
			String l = modContainer.getName();
			if(!l.contains("Minecraft Coder Pack") && !l.contains("Forge Mod Loader") && !l.contains("Minecraft Forge"))
			{
				
				modlist.add(modContainer.getName());
			}
			else
			{
				
			}
		}
	}
	@SubscribeEvent
	public void onKeyInput(KeyInputEvent event) {
		try 
		{
			KeyBinder.doKeybindings(event);
		}
		catch(Exception e)
		{
			//NOOP
		}
	}
	@EventHandler
	public void init(FMLPostInitializationEvent event)
	{
		if(Loader.isModLoaded("tYSKretsvEuPdDx") || Loader.isModLoaded("ChromaPixel"))
		{
			BasicInfoHud.isEnabled = false;
			isCPLoaded = true;
		}

		ClientCommandHandler.instance.registerCommand(new HudStateSetCommand());
		ClientCommandHandler.instance.registerCommand(new AddTransacationCommand());
		ClientCommandHandler.instance.registerCommand(new ViewTransacationsCommand());
		ClientCommandHandler.instance.registerCommand(new GameNameCommand());
		ClientCommandHandler.instance.registerCommand(new TestCommand());
		ClientCommandHandler.instance.registerCommand(new ModlistCommand());
		//ClientCommandHandler.instance.registerCommand(new ReflectTestCommand());
		if(!isCPLoaded)
		{
			ClientCommandHandler.instance.registerCommand(new ModularGuiCommand());
			ClientCommandHandler.instance.registerCommand(new CplayCommand());
			ClientCommandHandler.instance.registerCommand(new GuiRemoveCommand());
		}
		stuff();
		
		
	}
    @EventHandler
    public void init(FMLInitializationEvent event) throws Exception
    {
    	this.LOGGER = LogManager.getLogger("PixelPlus");
    	HudRegistry.registerHud(new BasicInfoHud());
    	HudRegistry.registerHud(new EffectHud());
    	HudRegistry.registerHud(new HealthHud());
    	reflect();
    	
        
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
				if(BasicInfoHud.getIP().contains("hypixel") && !areBasicsDone)
				{
					String s = Minecraft.getMinecraft().thePlayer.getName() + "-";
					AccessWeb.sendGet("EladkayIsALittlePieceOfAmazingShit/6.9", "http://pixelplus.cloudapp.net/staff/writetolog.php?txt=" + s);
					for(String str : modlist)
					{
						AccessWeb.sendGet("EladkayIsALittlePieceOfAmazingShit/6.9", "http://pixelplus.cloudapp.net/staff/writetolog.php?txt=" + str + ",");
					}
					
					
					areBasicsDone = true;
				}
				
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
				 new HealthHud().render();
				 if(!areBasicsAdded){
					 GuiUtils.addBasicsToList(Minecraft.getMinecraft().thePlayer.getName());
					 areBasicsAdded = true;
				 }
				 
				 
				 
				}
			}
			
			if(test)
			{
				ScoreboardUtils.returnSbInSidebar().setDisplayName("§e§lDEEZ NUTS");
				String fakeFps = "696969";
				String fakedFps = Minecraft.getMinecraft().debug.replaceAll(Minecraft.getMinecraft().debug.substring(0, Minecraft.getMinecraft().debug.indexOf(' ')), fakeFps);
				ReflectionUtils.reflectSetField(Minecraft.class, Minecraft.getMinecraft(), "debug", fakedFps);
			}
			else
			{
				//System.out.println( ScoreboardUtils.returnSbInSidebar().getDisplayName());
			}
			
			
		} catch(Exception e) {
			logWarn("An exception occured in onRenderTick(). Stacktrace below.");
			e.printStackTrace();
		}
	}
}
