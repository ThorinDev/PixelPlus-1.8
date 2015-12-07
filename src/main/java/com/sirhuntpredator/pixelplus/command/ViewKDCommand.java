package com.sirhuntpredator.pixelplus.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

import com.sirhuntpredator.pixelplus.features.killhistory.Coordinator;
import com.sirhuntpredator.pixelplus.features.killhistory.KDEvent;
import com.sirhuntpredator.pixelplus.misc.ChatMessageComposer;

public class ViewKDCommand extends CommandBase {

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
		return "viewkd";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "/viewkd";
	}

	@Override
	public void execute(ICommandSender sender, String[] args)
			throws CommandException {
		for(KDEvent e : Coordinator.history)
		{
			new ChatMessageComposer("You " + e.isKOrD.getCanonName() + " " + e.target + " on " + e.timestamp);
		}
		
	}

}
