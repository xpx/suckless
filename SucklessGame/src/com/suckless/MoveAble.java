package com.suckless;

import com.badlogic.gdx.math.Vector2;

public class MoveAble extends GameObject {
	
	public float speed;
	public Vector2 target;

	public MoveAble(Vector2 pos, double hp, float speed) {
		super(pos, hp);
		// TODO Auto-generated constructor stub
		this.speed = speed;
	}
	
	public void Update() {
		Move();
	}
	
	/**
	 * Updates objects position
	 */
	public void Move() {
		Vector2 tmp;
		// Check if object not at target
		if(this.pos.dst(this.target) != 0.0) {
			
			// Check if object is closer to target than step distance
			tmp = this.pos.div(target);
			if (tmp.len() < (TickControl.gameSpeed*this.speed)) {
				this.pos = target;
			} else {
				// Calculate and update position new position
				// TODO check is we are to add or sub dist 
				this.pos.x = this.pos.x - TickControl.gameSpeed*this.speed;
			}
			
		}
	}

}
