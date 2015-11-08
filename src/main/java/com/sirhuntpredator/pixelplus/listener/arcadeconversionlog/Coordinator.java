package com.sirhuntpredator.pixelplus.listener.arcadeconversionlog;

import java.util.ArrayList;

public class Coordinator 
{
	public static ArrayList<ArcadeTransacation> transacations = new ArrayList<ArcadeTransacation>();
	public static void addTransacation(String game, int value, int cost)
	{
		transacations.add(new ArcadeTransacation(value, cost, game));
	}
	public static String returnTransacationsAsString()
	{
		StringBuilder b = new StringBuilder();
		for(ArcadeTransacation t : transacations)
		{
			b.append("Converted " + t.cost + "Arcade coins into " + t.value + t.name + "coins,");
		
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
			b.append("Converted " + t.cost + "Arcade coins into " + t.value + t.name + "coins,");
		
		}
		if(b.toString() == "")
		{
			return "None yet!";
		}
		return b.toString();
		
	}
}
