package com.sirhuntpredator.pixelplus.features.killhistory;

import java.util.List;

import com.google.common.collect.Lists;

public class Coordinator 
{
	public static List<KDEvent> history = Lists.newArrayList();
	
	
	public static void init()
	{
		try
		{
			read();
			//Read ALL the code!
			
		}
		catch(Exception e)
		{
			System.err.println("An exception has occured while trying to initalize Kill History!");
		}
	}
	
	public static void write()
	{
		
	}
	
	public static void read()
	{
		
	}
	
}
