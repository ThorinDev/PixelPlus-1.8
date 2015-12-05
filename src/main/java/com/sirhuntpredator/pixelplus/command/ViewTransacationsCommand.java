package com.sirhuntpredator.pixelplus.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

import com.sirhuntpredator.pixelplus.features.arcadeconversionlog.Coordinator;
import com.sirhuntpredator.pixelplus.misc.ChatMessageComposer;

public class ViewTransacationsCommand extends CommandBase {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "vtrans";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "/vtrans";
	}

	@Override
	public void execute(ICommandSender sender, String[] args)
			throws CommandException {
		new ChatMessageComposer(Coordinator.returnTransacationsAsString()).send(false);
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
}
