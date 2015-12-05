package com.sirhuntpredator.pixelplus.features.purchaselog;

public class CoinsTransacation {

	public int cost = 0;
	public String timestamp = "";
	public String purchase = "";
	public String game = "";
	
	public CoinsTransacation(String game, int cost, String timestamp,
			String purchase) {
		super();
		this.game = game;
		this.cost = cost;
		this.timestamp = timestamp;
		this.purchase = purchase;
	}
	
	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getPurchase() {
		return purchase;
	}

	public void setPurchase(String purchase) {
		this.purchase = purchase;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}


	

	

}
