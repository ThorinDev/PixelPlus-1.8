package com.sirhuntpredator.pixelplus.features.purchaselog;

import java.util.Date;

import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.sirhuntpredator.pixelplus.features.scoreboard.ScoreboardUtils;
import com.sirhuntpredator.pixelplus.misc.Util;

public class Listener {

	public static final String MESSAGE_PURCHASE_1 = "You purchased";
	@SubscribeEvent
	public void chat(ClientChatReceivedEvent event)
	{
		String message = event.message.getUnformattedTextForChat();
		String game2 = "";
		String purchase = "";
		String level = "";
		int cost = 0;

		game2 = Util.removeFormattingCodes(ScoreboardUtils.returnSbName(ScoreboardUtils.returnSbInSidebar()));
		
		//Games that use this message:
		//BSG, 
		if(message.contains(MESSAGE_PURCHASE_1))
		{
			purchase = message.substring(13, message.length() - 1);
			if(game2 == "Blitz SG")
			{
				if(purchase.contains("Snowman"))
				{
					//Holiday pack, here to make my life miserable
				}
				else
				{
					if(purchase.contains("II") && !purchase.contains("III") && !purchase.contains("VII"))
					{
						level = "2";
						cost = 80;
					}
					else if(purchase.contains("III") && !purchase.contains("VIII"))
					{
						level = "3";
						cost = 400;
					}
					else if(purchase.contains("IV"))
					{
						level = "4";
						cost = 1000;
					}
					else if(purchase.contains("V") && !purchase.contains("VI") && !purchase.contains("VII") && !purchase.contains("VIII"))
					{
						level = "5";
						cost = 3000;
					}
					else if(purchase.contains("VI") && !purchase.contains("VII") && !purchase.contains("VIII"))
					{
						level = "6";
						cost = 12000;
					}
					else if(purchase.contains("VII") && !purchase.contains("VIII"))
					{
						level = "7";
						cost = 50000;
					}
					else if(purchase.contains("VIII"))
					{
						level = "8";
						cost = 100000;
					}
					else if(purchase.contains("IX"))
					{
						level = "9";
						cost = 250000;
					}
					else if(purchase.contains("X"))
					{
						level = "10";
						cost = 1000000;
					}
					
						
				}
			}
			Coordinator.addTransacation(game2, purchase, cost, new Date().toString());
		}
	
	}

}
