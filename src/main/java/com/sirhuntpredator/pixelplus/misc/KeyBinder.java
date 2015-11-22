package com.sirhuntpredator.pixelplus.misc;


import java.util.UUID;

import org.lwjgl.input.Keyboard;

import com.mojang.authlib.GameProfile;
import com.sirhuntpredator.pixelplus.command.CplayCommand;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.command.CommandException;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class KeyBinder {

	public static final String KEY_CATEGORY = "PixelPlus";
	private static KeyBinding pToPlay = new KeyBinding("Sends you to a game server for the gamemode specified in the Element Game in the modular GUI system.", Keyboard.KEY_P, KEY_CATEGORY);
	
	public static void registerALLTheKeyBindings()
	{
		ClientRegistry.registerKeyBinding(pToPlay);
	}
	public static void doKeybindings(KeyInputEvent event)
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
	}
}
