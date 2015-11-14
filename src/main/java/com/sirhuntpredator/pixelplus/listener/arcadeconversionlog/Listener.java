package com.sirhuntpredator.pixelplus.listener.arcadeconversionlog;

import java.util.Date;

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
		
				//Mega Walls
				if(message.contains("Converted 5000 Arcade coins into 500 Mega Walls coins."))
				Coordinator.addTransacation("Mega Walls", 500, 5000, new Date().toString());
				
				if(message.contains("Converted 15000 Arcade coins into 1500 Mega Walls coins."))
				Coordinator.addTransacation("Mega Walls", 1500, 15000, new Date().toString());
				
				if(message.contains("Converted 100000 Arcade coins into 10000 Mega Walls coins."))
				Coordinator.addTransacation("Mega Walls", 10000, 100000, new Date().toString());
				
				//Walls
				if(message.contains("Converted 5000 Arcade coins into 500 Walls coins."))
				Coordinator.addTransacation("Walls", 500, 5000, new Date().toString());
				
				if(message.contains("Converted 15000 Arcade coins into 1500 Walls coins."))
				Coordinator.addTransacation("Walls", 1500, 15000, new Date().toString());
				
				if(message.contains("Converted 100000 Arcade coins into 10000 Walls coins."))
				Coordinator.addTransacation("Walls", 10000, 100000, new Date().toString());

				//TntGames
				if(message.contains("Converted 5000 Arcade coins into 2500 TNT Games coins."))
				Coordinator.addTransacation("TNT Games", 2500, 5000, new Date().toString());
				
				if(message.contains("Converted 15000 Arcade coins into 7500 TNT Games coins."))
				Coordinator.addTransacation("TNT Games", 7500, 15000, new Date().toString());
				
				if(message.contains("Converted 100000 Arcade coins into 50000 TNT Games coins."))
				Coordinator.addTransacation("TNT Games", 50000, 100000, new Date().toString());
				
				//Warlords
				if(message.contains("Converted 5000 Arcade coins into 500 Warlords coins."))
				Coordinator.addTransacation("Warlords", 500, 5000, new Date().toString());
				
				if(message.contains("Converted 15000 Arcade coins into 1500 Warlords coins."))
				Coordinator.addTransacation("Warlords", 1500, 15000, new Date().toString());
				
				if(message.contains("Converted 100000 Arcade coins into 10000 Warlords coins."))
				Coordinator.addTransacation("Warlords", 10000, 100000, new Date().toString());
				
				//Blitz
				if(message.contains("Converted 5000 Arcade coins into 750 Blitz Survival Games coins."))
				Coordinator.addTransacation("Blitz Survival Games", 750, 5000, new Date().toString());
				
				if(message.contains("Converted 15000 Arcade coins into 2250 Blitz Survival Games coins."))
				Coordinator.addTransacation("Blitz Survival Games", 2250, 15000, new Date().toString());
				
				if(message.contains("Converted 100000 Arcade coins into 15000 Blitz Survival Games coins."))
				Coordinator.addTransacation("Blitz Survival Games", 15000, 10000, new Date().toString());
				
				//Paintball Warfare
				if(message.contains("Converted 5000 Arcade coins into 2500 Paintball coins."))
				Coordinator.addTransacation("Paintball", 2500, 5000, new Date().toString());
				
				if(message.contains("Converted 15000 Arcade coins into 7500 Paintball coins."))
				Coordinator.addTransacation("Paintball", 7500, 15000, new Date().toString());
				
				if(message.contains("Converted 100000 Arcade coins into 50000 Paintball coins."))
				Coordinator.addTransacation("Paintball", 50000, 100000, new Date().toString());
				
				//V-Z
				if(message.contains("Converted 5000 Arcade coins into 2500 VampireZ coins."))
				Coordinator.addTransacation("VampireZ", 2500, 5000, new Date().toString());
				
				if(message.contains("Converted 15000 Arcade coins into 7500 VampireZ coins."))
				Coordinator.addTransacation("VampireZ", 7500, 15000, new Date().toString());
				
				if(message.contains("Converted 100000 Arcade coins into 50000 VampireZ coins."))
				Coordinator.addTransacation("VampireZ", 50000, 100000, new Date().toString());
				
				//CaC
				if(message.contains("Converted 5000 Arcade coins into 750 Cops and Crims coins."))
				Coordinator.addTransacation("Cops and Crims", 750, 5000, new Date().toString());
				
				if(message.contains("Converted 15000 Arcade coins into 2250 Cops and Crims coins."))
				Coordinator.addTransacation("Cops and Crims", 2250, 15000, new Date().toString());
				
				if(message.contains("Converted 100000 Arcade coins into 15000 Cops and Crims coins."))
				Coordinator.addTransacation("Cops and Crims", 15000, 10000, new Date().toString());
				
				//Quakecraft
				if(message.contains("Converted 5000 Arcade coins into 750 Quakecraft coins."))
				Coordinator.addTransacation("Quakecraft", 750, 5000, new Date().toString());
				
				if(message.contains("Converted 15000 Arcade coins into 2250 Quakecraft coins."))
				Coordinator.addTransacation("Quakecraft", 2250, 15000, new Date().toString());
				
				if(message.contains("Converted 100000 Arcade coins into 15000 Quakecraft coins."))
				Coordinator.addTransacation("Quakecraft", 15000, 10000, new Date().toString());
				
				//UHC
				if(message.contains("Converted 5000 Arcade coins into 500 UHC Champions coins."))
				Coordinator.addTransacation("UHC Champions", 500, 5000, new Date().toString());
				
				if(message.contains("Converted 15000 Arcade coins into 1500 UHC Champions coins."))
				Coordinator.addTransacation("UHC Champions", 1500, 15000, new Date().toString());
				
				if(message.contains("Converted 100000 Arcade coins into 10000 UHC Champions coins."))
				Coordinator.addTransacation("UHC Champions", 10000, 100000, new Date().toString());
				
				//Arena Brawl
				if(message.contains("Converted 5000 Arcade coins into 750 Arena Brawl coins."))
				Coordinator.addTransacation("Arena Brawl", 750, 5000, new Date().toString());
				
				if(message.contains("Converted 15000 Arcade coins into 2250 Arena Brawl coins."))
				Coordinator.addTransacation("Arena Brawl", 2250, 15000, new Date().toString());
				
				if(message.contains("Converted 100000 Arcade coins into 15000 Arena Brawl coins."))
				Coordinator.addTransacation("Arena Brawl", 15000, 10000, new Date().toString());
		}
	}
	
}
