package com.sirhuntpredator.pixelplus.features.shiftrightclick;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Listener {

	static IChatComponent name2 = new ChatComponentText("PixelPlus");
	static
	{
		name2.setChatStyle(new ChatStyle().setBold(true).setColor(EnumChatFormatting.DARK_PURPLE));	
	}
    
	@SubscribeEvent
	public void onplayerInteract(EntityInteractEvent event) {
		
		if (event.target instanceof EntityPlayer) {

			EntityPlayer player = (EntityPlayer) event.target;
			String name = player.getName();

			if (Minecraft.getMinecraft().thePlayer.getHeldItem() == null && Minecraft.getMinecraft().thePlayer.isSneaking()) 
			{
					//F add
					ChatStyle chatStyle = new ChatStyle().setChatClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/f add "+ name));
					chatStyle = chatStyle.setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,new ChatComponentText(EnumChatFormatting.BLUE+ "Click to " + EnumChatFormatting.YELLOW+ "add")));
					event.entityPlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GRAY + "["+ EnumChatFormatting.BLUE + name2.getFormattedText()+ EnumChatFormatting.GRAY + "] "+ EnumChatFormatting.BLUE+ "Click here to add "+ EnumChatFormatting.YELLOW + name).setChatStyle(chatStyle));
					
					//Msg
					ChatStyle chatStyle1 = new ChatStyle().setChatClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tell "+ name));
					chatStyle1 = chatStyle1.setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ChatComponentText(EnumChatFormatting.BLUE + "Click to "+ EnumChatFormatting.YELLOW+ "message")));
					event.entityPlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GRAY + "["+ EnumChatFormatting.BLUE + name2.getFormattedText()+ EnumChatFormatting.GRAY + "] "+ EnumChatFormatting.BLUE+ "Click here to send a message to "+ EnumChatFormatting.YELLOW + name).setChatStyle(chatStyle1));
				
			}

}
}}