package com.sirhuntpredator.pixelplus.features.supporterrecognition;

import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.sirhuntpredator.pixelplus.misc.ChatMessageComposer;

public class Listener 
{

	@SubscribeEvent
	public void chat(ClientChatReceivedEvent event)
	{
		EnumChatFormatting e;
		if(event.message.getUnformattedText().contains("deliveries") || event.message.getUnformattedText().contains("joined") || event.message.getUnformattedText().contains("left"))
		{
			e = EnumChatFormatting.YELLOW;
		}
		else if(event.message.getFormattedText().contains("from") || event.message.getUnformattedText().contains("to"))
		{
			e = EnumChatFormatting.GRAY;
		}
		else
		{
			e = EnumChatFormatting.WHITE;
		}
		for(String b : Coordinator.supporters)
		{
			String s = b.replace(" ", "");
			boolean dont = false;
			if(s.equals("") || s.equals(" "))
			{
				dont = true;
			}
			if(event.message.getFormattedText().contains(s) && !dont)
			{
				new ChatMessageComposer(event.message.getFormattedText().replace(s, s + EnumChatFormatting.RED + "" + EnumChatFormatting.BOLD +" [S]" + e)).send(false);
				event.setCanceled(true);
				return;
			}
		}
	}

}
