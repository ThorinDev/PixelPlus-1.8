package com.sirhuntpredator.pixelplus.command;

import com.sirhuntpredator.pixelplus.hud.HudRegistry;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

public class HudStateSetCommand extends CommandBase {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "hudset";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "/hudset <id> <state>";
	}

	@Override
	public void execute(ICommandSender sender, String[] args)
			throws CommandException {
		HudRegistry.setState(Integer.valueOf(args[0]), args[1] == "true" ? true : false);
		
	}
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
}
