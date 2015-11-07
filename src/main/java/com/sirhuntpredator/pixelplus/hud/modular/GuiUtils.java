package com.sirhuntpredator.pixelplus.hud.modular;

import java.util.ArrayList;
import java.util.List;

public class GuiUtils
{
	public static List<Element> elements = new ArrayList<Element>();
	
	public static void addBasicsToList()
	{
		Element facing  = new Element("Facing", "facing");
		Element ping  = new Element("Ping", "ping");
		Element time  = new Element("Time", "time");
		Element players  = new Element("Players", "players");
		Element ip  = new Element("IP", "ip");
		Element fps = new Element("FPS", "fps");
		Element ign = new Element("IGN", "ign");
		
		elements.add(players);
		elements.add(ping);
		elements.add(time);
		elements.add(facing);
		elements.add(ip);
		elements.add(fps);
		elements.add(ign);
	}
}
