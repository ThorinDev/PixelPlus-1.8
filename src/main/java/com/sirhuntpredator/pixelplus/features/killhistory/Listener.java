package com.sirhuntpredator.pixelplus.features.killhistory;

import java.util.Date;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.sirhuntpredator.pixelplus.misc.ChatMessageComposer;

public class Listener 
{
	@SubscribeEvent
	public void chat(ClientChatReceivedEvent event)
	{
		//new ChatMessageComposer("Pass 0").send();
		if(event.message.getUnformattedText().contains("killed") && event.message.getUnformattedText().contains(Minecraft.getMinecraft().thePlayer.getName()))
		{
			new ChatMessageComposer("Pass 1").send();
			KDEvent kd;
			if(event.message.getUnformattedText().contains("was killed by " + Minecraft.getMinecraft().thePlayer.getName()))
			{
				new ChatMessageComposer("Pass 2").send();
				if(event.message.getUnformattedText().contains("B-SG"))
				{
					new ChatMessageComposer("Pass 3").send();
					String message = event.message.getUnformattedText().replace("[B-SG]:", "");
					message = message.replace(" ", "");
					String target = message.substring(0, message.indexOf("was"));
			
					kd = new KDEvent(EnumTypeKD.KILL, target, new Date().toString(), "Blitz Survival");
					Coordinator.history.add(kd);
				}
			}
			else if(event.message.getUnformattedText().contains(Minecraft.getMinecraft().thePlayer.getName() + " was killed by"))
			{
				new ChatMessageComposer("Pass 2").send();
				if(event.message.getUnformattedText().contains("B-SG"))
				{
					new ChatMessageComposer("Pass 3").send();
					String message = event.message.getUnformattedText().replace("[B-SG]:", "");
					message = message.replace(" ", "");
					String target = message.substring(message.indexOf("by"));
			
					kd = new KDEvent(EnumTypeKD.DEATH, target, new Date().toString(), "Blitz Survival");
					Coordinator.history.add(kd);
				}
			}
		}
	}

}
