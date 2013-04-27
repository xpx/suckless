package com.suckless;

public class GameObject {
	
	// Position
	public double x;
	public double y;
	
	// HP
	public double hp;
	
	public GameObject(double x_pos, double y_pos, double hp) {
		this.x = x_pos;
		this.y = y_pos;
		this.hp = hp;
	}
	
	// Returns x pos rounded to nearest int
	public int getXTile() {
		return (int)Math.round(x);
	}
	// Returns x pos rounded to nearest int
	public int getYTile() {
		return (int)Math.round(y);
	}
	
}
