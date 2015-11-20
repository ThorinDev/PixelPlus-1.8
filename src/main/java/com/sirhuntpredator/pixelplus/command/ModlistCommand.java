package com.sirhuntpredator.pixelplus.command;

import com.sirhuntpredator.pixelplus.PixelPlus;
import com.sirhuntpredator.pixelplus.misc.ChatMessageComposer;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

public class ModlistCommand extends CommandBase {

	@Override
	public boolean canCommandSenderUse(ICommandSender sender) {
		// TODO Auto-generated method stub
	return true;
	}
	@Override
	public int getRequiredPermissionLevel() {
		// TODO Auto-generated method stub
	return 0;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "modlist";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "/modlist";
	}

	@Override
	public void execute(ICommandSender sender, String[] args)
			throws CommandException {
		for (String string : PixelPlus.modlist) {
			new ChatMessageComposer(string).send();			
		}

		
	}

}
