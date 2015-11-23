package com.sirhuntpredator.pixelplus.command;

import com.sirhuntpredator.pixelplus.misc.ChatMessageComposer;
import com.sirhuntpredator.pixelplus.misc.IOUtils;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

public class TestCommand extends CommandBase {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "test";
	}
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
	public String getCommandUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "/test";
	}

	@Override
	public void execute(ICommandSender sender, String[] args)
			throws CommandException {
		String b = "";
		for(String s : args)
		{
			b += s;
			new ChatMessageComposer(s + "fdfdd").send();
		}
		for(String s : IOUtils.getListFromFormattedFileUsingSpaces(b))
		{
			new ChatMessageComposer(s).send();
		}
		
	}

}
