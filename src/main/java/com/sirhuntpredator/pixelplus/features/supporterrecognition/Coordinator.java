package com.sirhuntpredator.pixelplus.features.supporterrecognition;

import java.util.List;
import java.util.regex.Pattern;

import com.google.common.collect.Lists;
import com.sirhuntpredator.pixelplus.PixelPlus;
import com.sirhuntpredator.pixelplus.misc.AccessWeb;

public class Coordinator 
{
	public static List<String> supporters = Lists.newArrayList();
	
	public static void init()
	{
		supporters.add("Eladkay");
		supporters.add("SirHuntPredator");
		supporters.add("ManuBoss_of_City");
		String toDo = "";
		
		try
		{
			toDo = AccessWeb.downloadFile("http://pixelplus.cloudapp.net/supporters.md");
		}
		catch(Exception e)
		{}
		
		String[] names = toDo.split(Pattern.quote(","));
		for(String s : names)
		{
			System.out.println("Added " + s + " as a supporter!");
			supporters.add(s);
		}
	}
}
