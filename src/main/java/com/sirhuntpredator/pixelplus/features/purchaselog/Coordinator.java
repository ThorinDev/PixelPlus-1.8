package com.sirhuntpredator.pixelplus.features.purchaselog;

import java.util.ArrayList;

public class Coordinator {


	public static ArrayList<CoinsTransacation> transacations = new ArrayList<CoinsTransacation>();
	public static void addTransacation(String game, String purchase, int cost, String timestamp)
	{
		transacations.add(new CoinsTransacation(purchase, cost, game, timestamp));
	}
	public static String returnTransacationsAsString()
	{
		StringBuilder b = new StringBuilder();
		for(CoinsTransacation t : transacations)
		{
			b.append("Bought " + t.purchase + " in " + t.game + " for " + t.cost + " on " + t.timestamp);
		
		}
		if(b.toString() == "")
		{
			return "None yet!";
		}
		return b.toString();
		
	}
	public static String returnTransacationsAsString(ArrayList<CoinsTransacation> list)
	{
		StringBuilder b = new StringBuilder();
		for(CoinsTransacation t : list)
		{
			b.append("Bought " + t.purchase + " in " + t.game + " for " + t.cost + " on " + t.timestamp);
		
		}
		if(b.toString() == "")
		{
			return "None yet!";
		}
		return b.toString();
		
	}

}
