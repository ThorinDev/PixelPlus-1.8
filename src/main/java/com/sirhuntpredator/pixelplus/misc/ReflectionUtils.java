package com.sirhuntpredator.pixelplus.misc;

import net.minecraftforge.fml.relauncher.ReflectionHelper;

public class ReflectionUtils {

	
	  public static Object reflectGetField(String clazz, String name)
	    {
			try {
				return ReflectionHelper.findField(Class.forName(clazz), name);
			} catch (ClassNotFoundException e) {
				return null;
			}	
	    }
	    public static Object reflectGetField(Class clazz, String name)
	    {
			return ReflectionHelper.findField(clazz, name);	
	    }
	    public static void reflectSetField(Class clazz, Object obj, String name, Object value)
	    {
	    	ReflectionHelper.setPrivateValue(clazz, obj, value, name);
	    }
}
