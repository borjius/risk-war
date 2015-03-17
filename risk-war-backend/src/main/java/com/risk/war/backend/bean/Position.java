package com.risk.war.backend.bean;

public enum Position {
	
	PO(1.3), LATD(1), DC(1), LATI(1), MCD(1), MC(1), MD(1), MI(1), EXTD(1.2), EXTI(1.2), MP(1.3), D(1.4);
	
	private double positionPrice;
	
	public double getPositionPrice() {
		return positionPrice;
	}

	private Position(double positionPrice) {
		this.positionPrice = positionPrice;
	}
	
	

}
