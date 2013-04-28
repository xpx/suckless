package com.suckless;

import com.badlogic.gdx.math.Vector2;

public class MoveAble extends GameObject {
	
	public float speed;
	public Vector2 target;

	public MoveAble(Vector2 pos, double hp, float speed) {
		super(pos, hp);
		// TODO Auto-generated constructor stub
		this.speed = speed;
		target = new Vector2(0,0);
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
				// TODO check is we are to add or sub distance
				if (pos.x < target.x){
					this.pos.x = this.pos.x + TickControl.gameSpeed*this.speed;
				} else {
					this.pos.x = this.pos.x - TickControl.gameSpeed*this.speed;
				}
				if (pos.y < target.y){
					this.pos.y = this.pos.y + TickControl.gameSpeed*this.speed;
				} else {
					this.pos.y = this.pos.y - TickControl.gameSpeed*this.speed;
				}
			}
			
		}
	}

}
