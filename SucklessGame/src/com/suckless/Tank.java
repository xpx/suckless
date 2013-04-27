package com.suckless;

import com.badlogic.gdx.math.Vector2;


public class Tank extends MoveAble {

	public double damage;
	public double range;
	
	public Tank(Vector2 pos, double hp, double speed, double damage, double range) {
		super(pos, hp, speed);
		// TODO Auto-generated constructor stub
		
		this.damage = damage;
		this.range = range;
	}

}
