package com.suckless;

import com.badlogic.gdx.math.Vector2;


public class MoveAble extends GameObject {
	
	public double speed;
	public Vector2 target;

	public MoveAble(Vector2 pos, double hp, double speed) {
		super(pos, hp);
		// TODO Auto-generated constructor stub
		this.speed = speed;
	}
	
	/**
	 * Updates objects position
	 */
	public void Move() {
		// Check if object not at target
		if(this.pos.dst(this.target) != 0.0) {
			
		}
	}

}
