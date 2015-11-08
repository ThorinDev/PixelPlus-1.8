package com.sirhuntpredator.pixelplus.listener.arcadeconversionlog;

import com.sirhuntpredator.pixelplus.PixelPlus;

import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Listener {

	public static final String CHAT_MESSAGE_ARCADE_CONVERSION = "Converted";
	public static final String CHAT_MESSAGE_ARCADE_CONVERSION_2 = "Arcade coins into";
	public static final String CHAT_MESSAGE_ARCADE_CONVERSION_3 = "coins.";
	@SubscribeEvent
	public static void chat(ClientChatReceivedEvent event)
	{
		if(event.message.getUnformattedTextForChat().contains(CHAT_MESSAGE_ARCADE_CONVERSION) && event.message.getUnformattedTextForChat().contains(CHAT_MESSAGE_ARCADE_CONVERSION_2) && event.message.getUnformattedTextForChat().contains(CHAT_MESSAGE_ARCADE_CONVERSION_3))
		{
			String message = event.message.getUnformattedTextForChat();
			if(message.contains("Walls") && !message.contains("Mega Walls"))
			{
				
			}
			else if(message.contains("TNT"))
			{
				
			}
			else if(message.contains("Cops"))
			{
				
			}
			else if(message.contains("Quakecraft"))
			{
				
			}
			else if(message.contains("Warlords"))
			{
				
			}
			else if(message.contains("Blitz"))
			{
				
			}
			else if(message.contains("VampireZ"))
			{
				
			}
			else if(message.contains("UHC"))
			{
				
			}
			else if(message.contains("Arena"))
			{
				
			}
			else if(message.contains("Paintball"))
			{
				
			}
			else if(message.contains("Mega Walls"))
			{
				
			}
			else 
			{
				PixelPlus.instance().logInfo("User converted coins into a game that doesn't exist?");
			}
			
		}
	}
}
