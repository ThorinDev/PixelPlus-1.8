package com.sirhuntpredator.pixelplus.command;

import java.util.ArrayList;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

import com.sirhuntpredator.pixelplus.hud.modular.Element;
import com.sirhuntpredator.pixelplus.hud.modular.GuiUtils;
import com.sirhuntpredator.pixelplus.misc.ChatMessageComposer;

public class GuiRemoveCommand extends CommandBase {

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
	return "guiremove";
}

@Override
public String getCommandUsage(ICommandSender sender) {
	// TODO Auto-generated method stub
	return "/guiremove <index|all>";
}

@Override
public void execute(ICommandSender sender, String[] args)
		throws CommandException {
	
	if(args.length != 1)
	{
		new ChatMessageComposer("Invalid arguments. Error code 1.").send(true);
		return;
	}
	
	String arg0 = args[0];
	if(arg0.equals("all"))
	{
		new ChatMessageComposer("The Modular GUI system has been successfully reset.").send(true);
		GuiUtils.elements = new ArrayList<Element>();
	}
	else
	{
		GuiUtils.elements.remove(Integer.parseInt(arg0) - 1);
		new ChatMessageComposer("The provided element of the Modular GUI system has been successfully removed.").send(true);
	}
	
	
}
}
