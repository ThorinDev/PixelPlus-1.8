package com.sirhuntpredator.pixelplus.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.EnumChatFormatting;

import com.sirhuntpredator.pixelplus.misc.ChatMessageComposer;

public class ToggleCombatLog extends CommandBase {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "combatlogger";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "/combatlogger";
	}

	@Override
	public void execute(ICommandSender sender, String[] args)
			throws CommandException {
		if(com.sirhuntpredator.pixelplus.features.combatlog.Coordinator.enabled)
		{
			new ChatMessageComposer(EnumChatFormatting.RED + "Disabled the Combat Logger!").send();
			com.sirhuntpredator.pixelplus.features.combatlog.Coordinator.enabled = false;
		}
		else
		{
			new ChatMessageComposer(EnumChatFormatting.GREEN + "Enabled the Combat Logger!").send();
			com.sirhuntpredator.pixelplus.features.combatlog.Coordinator.enabled = true;
		}
		
	}
	@Override
	public int getRequiredPermissionLevel() {
		// TODO Auto-generated method stub
		return 0;
	}@Override
	public boolean canCommandSenderUse(ICommandSender sender) {
		// TODO Auto-generated method stub
		return true;
	}

}
