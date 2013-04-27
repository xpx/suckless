package com.suckless;

import com.badlogic.gdx.math.Vector2;

public class Infantry extends MoveAble {
	
	public double damage;

	public Infantry(Vector2 pos, double hp, float speed, double damage) {
		super(pos, hp, speed);
		
		this.damage = damage;
	}
	
	public void Update() {
		// Implement special cases for infantry
		super.Update();
	}
}
