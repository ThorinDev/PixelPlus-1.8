package com.sirhuntpredator.pixelplus.hud.modular;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;

import com.sirhuntpredator.pixelplus.misc.AdminUtils;

public class GuiUtils
{
	public static List<Element> elements = new ArrayList<Element>();
	
	public static void addBasicsToList(String name) throws Exception
	{
		Element facing  = new Element("Facing", "facing");
		Element ping  = new Element("Ping", "ping");
		Element time  = new Element("Time", "time");
	//	Element players  = new Element("Players", "players");
		Element ip  = new Element("IP", "ip");
		Element fps = new Element("FPS", "fps");
		Element ign = new Element("IGN", "ign");
		try
		{
			if(AdminUtils.isSirHunt(name))
			{
				Element dankMemes = new Element ("Dank", "memes");
				elements.add(dankMemes);
			}
		}
		catch(Exception e)
		{
			//NOOP. Probably running on a development environment.
		}
		elements.add(players);
		elements.add(ping);
		elements.add(time);
		elements.add(facing);
		elements.add(ip);
		elements.add(fps);
		elements.add(ign);
		
	}
}
