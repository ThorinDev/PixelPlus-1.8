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
		
		for(String s : Coordinator.supporters)
		{
			if(event.message.getFormattedText().contains(s))
			{
				new ChatMessageComposer(event.message.getFormattedText().replace(s, s + EnumChatFormatting.RED + "" + EnumChatFormatting.BOLD +" [S]")).send(false);
				event.setCanceled(true);
			}
		}
	}

}
