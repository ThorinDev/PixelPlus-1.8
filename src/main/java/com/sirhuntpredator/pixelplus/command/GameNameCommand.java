package com.sirhuntpredator.pixelplus.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

import com.sirhuntpredator.pixelplus.features.scoreboard.ScoreboardUtils;
import com.sirhuntpredator.pixelplus.misc.ChatMessageComposer;
import com.sirhuntpredator.pixelplus.misc.Util;

public class GameNameCommand extends CommandBase{

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
		return "gname";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "/gname";
	}

	@Override
	public void execute(ICommandSender sender, String[] args)
			throws CommandException {
	/*	String game = "";
		String game2 = "";
		String delta = "";
		
			game = ScoreboardUtils.returnOSbName(ScoreboardUtils.returnSbInSidebar());
			game2 = game;
			for (int i = 0; i < game.length(); i++) 
			{
				if(game.charAt(i) == '§')
				{
					delta = game.substring(i, i+2);
					new ChatMessageComposer(delta).send();
					game2.replace(delta, "");
				}
			}
	*/
		new ChatMessageComposer(Util.getProperlyCapitalizedGameName(Util.removeFormattingCodes(ScoreboardUtils.returnSbName(ScoreboardUtils.returnSbInSidebar())))).send();
		
	}

}
