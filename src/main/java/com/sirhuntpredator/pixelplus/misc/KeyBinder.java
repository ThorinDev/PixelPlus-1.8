package com.sirhuntpredator.pixelplus.misc;


import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.command.CommandException;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

import org.lwjgl.input.Keyboard;

import com.sirhuntpredator.pixelplus.command.CplayCommand;
import com.sirhuntpredator.pixelplus.config.PixelPlusGuiConfig;

public class KeyBinder {

	public static final String KEY_CATEGORY = "PixelPlus";
	private static KeyBinding pToPlay = new KeyBinding("Sends you to a game server for the gamemode specified in the Element Game in the modular GUI system.", Keyboard.KEY_P, KEY_CATEGORY);
	private static KeyBinding config = new KeyBinding("Opens le config!", Keyboard.KEY_I, KEY_CATEGORY);
	private static KeyBinding taunt = new KeyBinding("Taunts (BSG)", Keyboard.KEY_V, KEY_CATEGORY);
	public static void registerALLTheKeyBindings()
	{
		ClientRegistry.registerKeyBinding(pToPlay);
		ClientRegistry.registerKeyBinding(config);
		ClientRegistry.registerKeyBinding(taunt);
	}
	public static void doKeybindings(KeyInputEvent event) throws Exception
	{
		if(pToPlay.isPressed()) {
			CplayCommand drc = new CplayCommand();
			try {
				drc.execute(Minecraft.getMinecraft().thePlayer, new String[]{});
			} catch (CommandException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		if(config.isPressed()) {
			
			FMLClientHandler.instance().getClient().displayGuiScreen(new PixelPlusGuiConfig(Minecraft.getMinecraft().currentScreen));
		}
		if(taunt.isPressed()) {
			
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/taunt");
		}
	}
}
