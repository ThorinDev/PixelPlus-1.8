package com.sirhuntpredator.pixelplus.command;

import java.util.Date;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

import com.sirhuntpredator.pixelplus.features.arcadeconversionlog.Coordinator;

public class AddTransacationCommand extends CommandBase {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "aatrans";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "/aatrans <name> <cost> <value>";
	}

	@Override
	public void execute(ICommandSender sender, String[] args)
			throws CommandException {
		Coordinator.addTransacation(args[0], Integer.parseInt(args[2]), Integer.parseInt(args[1]), new Date().toString());
		
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
