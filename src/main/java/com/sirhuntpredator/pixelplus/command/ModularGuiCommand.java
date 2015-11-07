package com.sirhuntpredator.pixelplus.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

import com.sirhuntpredator.pixelplus.hud.modular.Element;
import com.sirhuntpredator.pixelplus.hud.modular.GuiUtils;
import com.sirhuntpredator.pixelplus.misc.ChatMessageComposer;

public class ModularGuiCommand extends CommandBase
{

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
		return "gui";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "/gui <name> <value>";
	}

	@Override
	public void execute(ICommandSender sender, String[] args)
			throws CommandException {
		Boolean isValid = false;
		
		//Error code #1
		if(!(args.length == 2))
		{
			new ChatMessageComposer("Invalid arguments. Error code 1.").send(true);
			
			return;
		}
		String text = args[0];
		String name = args[1];
		
		
		
		if(GuiUtils.elements.size() == 12)
		{
			new ChatMessageComposer("Too many GUI elements!").send(true);
			return;
		}
		
		Element element = new Element(text, " " + name);
		GuiUtils.elements.add(element);
		

		
		
		
	}

}
