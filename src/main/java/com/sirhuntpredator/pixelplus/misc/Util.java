package com.sirhuntpredator.pixelplus.misc;


public class Util {

		public static String removeFormattingCodes(String name)
		{
			String game = name;
			
			for (int i = 0; i < 9; i++) {
				game.replaceAll("§" + (i + 1), "");
			}
			game = game.replaceAll("\u00a7\\w", "");
			//#BlameWire
		
			return game;
		}
		public static String getProperlyCapitalizedGameName(String name)
		{
			boolean caps = true;
			String result = "";
			for (int i = 0; i < name.length(); i++) 
			{
				if(caps)
				{
					result += name.charAt(i);
					caps = false;
				}
				else if(name.charAt(i) == ' ')
				{
					result += ' ';
					caps = true;
				}
				else
				{
					result += String.valueOf(name.charAt(i)).toLowerCase();
				}
			}
			return result;
		}

}
