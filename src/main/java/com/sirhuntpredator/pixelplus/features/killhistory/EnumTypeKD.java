package com.sirhuntpredator.pixelplus.features.killhistory;

public enum EnumTypeKD 
{
	KILL,
	DEATH;
	public String getCanonName()
	{
		return this == KILL ? "killed" : "was killed by";
	}
	
}
