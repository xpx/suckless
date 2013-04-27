package com.suckless;

import com.badlogic.gdx.math.Vector2;


public class Infantry extends MoveAble {
	
	public double damage;

	public Infantry(Vector2 pos, double hp, double speed, double damage) {
		super(pos, hp, speed);
		// TODO Auto-generated constructor stub
		
		this.damage = damage;
	}
}
