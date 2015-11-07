package com.sirhuntpredator.pixelplus.command;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

import com.sirhuntpredator.pixelplus.hud.modular.Element;
import com.sirhuntpredator.pixelplus.hud.modular.GuiUtils;

public class CplayCommand extends CommandBase{

	@Override
	public int getRequiredPermissionLevel() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean canCommandSenderUse(ICommandSender sender) {
		// TODO Auto-generated method stub
	return true;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "cplay";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "/cplay";
	}

	@Override
	public void execute(ICommandSender sender, String[] args)
			throws CommandException {

		for(Element s : GuiUtils.elements)
		{
			if(s.element.equalsIgnoreCase("Game"))
			{
				Minecraft.getMinecraft().thePlayer.sendChatMessage("/play" + s.value);
				return;
			}
		}
		
		
	}

	
}
