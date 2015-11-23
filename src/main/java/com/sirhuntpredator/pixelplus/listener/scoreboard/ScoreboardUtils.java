package com.sirhuntpredator.pixelplus.listener.scoreboard;

import net.minecraft.client.Minecraft;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;

public class ScoreboardUtils {


	public static ScoreObjective returnSbInSidebar()
	{
		return Minecraft.getMinecraft().theWorld.getScoreboard().getObjectiveInDisplaySlot(1);
	}
	public static String returnSbName(ScoreObjective sb)
	{
		try
		{
			return sb.getDisplayName();
		}
		catch(Throwable t)
		{
			return null;
		}
	}
	

}
