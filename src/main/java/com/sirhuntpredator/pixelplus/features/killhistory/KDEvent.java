package com.sirhuntpredator.pixelplus.features.killhistory;

public class KDEvent 
{
	
	public EnumTypeKD getIsKOrD() {
		return isKOrD;
	}
	public void setIsKOrD(EnumTypeKD isKOrD) {
		this.isKOrD = isKOrD;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getGame() {
		return game;
	}
	public void setGame(String game) {
		this.game = game;
	}
	
	public KDEvent(EnumTypeKD isKOrD, String timestamp, String target, String game) {
		super();
		this.isKOrD = isKOrD;
		this.timestamp = timestamp;
		this.target = target;
		this.game = game;
	}

	public EnumTypeKD isKOrD;
	public String timestamp;
	public String target;
	public String game;
	
	

}
