package com.sirhuntpredator.pixelplus.misc;

public class AdminUtils 
{
	public static boolean isAdmin(String name) throws Exception
	{
		return (isSirHunt(name) || isEladkay(name));
	}
	public static boolean isSirHunt(String name) throws Exception
	{
		String uuid = UUIDFetcher.getUUIDOf(name).toString();
		if(uuid.equals("2622fe5a6ceb40f18edf092987043916")) return true;
		else
		return false;
	}
	public static boolean isEladkay(String name) throws Exception
	{
		String uuid = UUIDFetcher.getUUIDOf(name).toString();
		if(uuid.equals("c716cef1833b47e59d62a936a9552d0d") || uuid.equals("d77064b8cb704054b282200338f81b68")) return true;
		else
		return false;
	}
}
