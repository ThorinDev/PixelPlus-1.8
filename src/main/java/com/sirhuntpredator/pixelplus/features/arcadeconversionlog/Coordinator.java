package com.sirhuntpredator.pixelplus.features.arcadeconversionlog;

import java.util.ArrayList;

public class Coordinator 
{
	public static ArrayList<ArcadeTransacation> transacations = new ArrayList<ArcadeTransacation>();
	public static void addTransacation(String game, int value, int cost, String timestamp)
	{
		transacations.add(new ArcadeTransacation(value, cost, game, timestamp));
	}
	public static String returnTransacationsAsString()
	{
		StringBuilder b = new StringBuilder();
		for(ArcadeTransacation t : transacations)
		{
			b.append("Converted " + t.cost + " Arcade coins into " + t.value + " " + t.name + " coins on " + t.timestamp + ", ");
		
		}
		if(b.toString() == "")
		{
			return "None yet!";
		}
		return b.toString();
		
	}
	public static String returnTransacationsAsString(ArrayList<ArcadeTransacation> list)
	{
		StringBuilder b = new StringBuilder();
		for(ArcadeTransacation t : list)
		{
			b.append("Converted " + t.cost + " Arcade coins into " + t.value + " " + t.name + " coins on " + t.timestamp + ", ");
		
		}
		if(b.toString() == "")
		{
			return "None yet!";
		}
		return b.toString();
		
	}
}
