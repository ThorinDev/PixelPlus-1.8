package com.sirhuntpredator.pixelplus.listener.arcadeconversionlog;

public class ArcadeTransacation {

	public int value;
	public int cost;
	public String name;
	public String timestamp;
	
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public ArcadeTransacation(int value, int cost, String name, String timestamp) {
		
		this.value = value;
		this.cost = cost;
		this.name = name;
		this.timestamp = timestamp;
	}
	
	
	

}
