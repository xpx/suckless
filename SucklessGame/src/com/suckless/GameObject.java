package com.suckless;

import com.badlogic.gdx.math.Vector2;


public class GameObject {
	
	// Position
	public Vector2 pos;
	
	// HP
	public double hp;
	
	public GameObject(Vector2 pos, double hp) {
		this.pos = pos;
		this.hp = hp;
	}
	
	// Returns x pos rounded to nearest int
	public int getXTile() {
		return (int)Math.round(pos.x);
	}
	// Returns x pos rounded to nearest int
	public int getYTile() {
		return (int)Math.round(pos.y);
	}
	
}
