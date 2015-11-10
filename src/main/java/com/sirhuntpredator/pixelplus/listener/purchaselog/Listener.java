package com.sirhuntpredator.pixelplus.listener.purchaselog;

import java.util.Date;

import com.sirhuntpredator.pixelplus.listener.scoreboard.ScoreboardUtils;

import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Listener {

	public static final String MESSAGE_PURCHASE_1 = "You purchased";
	@SubscribeEvent
	public static void chat(ClientChatReceivedEvent event)
	{
		String message = event.message.getUnformattedTextForChat();
		String game = "";
		String game2 = "";
		String delta = "";
		String purchase = "";
		String level = "";
		try
		{
			game = ScoreboardUtils.returnSbName(ScoreboardUtils.returnSbInSidebar());
			game2 = game;
			for (int i = 0; i < game.length(); i++) 
			{
				if(game.charAt(i) == '§')
				{
					delta = game.substring(i, i+1);
					game2.replace(delta, "");
				}
			}
		}
		catch (Exception e) 
		{
			//noop
		}
		
		//Games that use this message:
		//BSG, 
		if(message.contains(MESSAGE_PURCHASE_1))
		{
			purchase = message.substring(13, message.length() - 1)
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
					}
					else if(purchase.contains("III") && !purchase.contains("VIII"))
					{
						level = "3";
					}
					else if(purchase.contains("IV"))
					{
						level = "4";
					}
					else if(purchase.contains("V") && !purchase.contains("VI") && !purchase.contains("VII") && !purchase.contains("VIII"))
					{
						level = "5";
					}
					else if(purchase.contains("VI") && !purchase.contains("VII") && !purchase.contains("VIII"))
					{
						level = "6";
					}
					else if(purchase.contains("VII") && !purchase.contains("VIII"))
					{
						level = "7";
					}
					else if(purchase.contains("VIII"))
					{
						level = "8";
					}
					else if(purchase.contains("IX"))
					{
						level = "9";
					}
					else if(purchase.contains("X"))
					{
						level = "10";
					}
						
				}
			}
			Coordinator.addTransacation(game2, purchase, cost, new Date().toString());
		}
	
	}

}
