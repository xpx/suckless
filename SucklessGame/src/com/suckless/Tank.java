package com.suckless;

import com.badlogic.gdx.math.Vector2;


public class Tank extends MoveAble {

	public double damage;
	public double range;
	
	public Tank(Vector2 pos, double hp, boolean destroyable, float speed, double damage, double range) {
		super(pos, hp, destroyable, speed);
		// TODO Auto-generated constructor stub
		
		this.damage = damage;
		this.range = range;
	}
	
	public void Update(Field[][] states) {
		// Implement special cases for infantry
		super.Update(states);
	}

}
