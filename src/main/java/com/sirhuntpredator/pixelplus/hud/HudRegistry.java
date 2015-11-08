package com.sirhuntpredator.pixelplus.hud;

import java.util.HashMap;
import java.util.Map;

public class HudRegistry {

	public static Map<Integer, HudBase> registry = new HashMap<Integer, HudBase>();
	
	public static void registerHud(HudBase hud)
	{
		registry.put(hud.id(), hud);
	}
	public static HudBase getHudByID(int id)
	{
		return registry.get(id);
	}
	public static void setState(int id, boolean state){
		
		registry.get(id).isEnabled = state;
	}
}
