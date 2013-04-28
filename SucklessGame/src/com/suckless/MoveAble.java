package com.suckless;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.math.Vector2;
import com.suckless.Selecter.StateDirection;

public class MoveAble extends GameObject {
	
	public float speed;
	public Vector2 target;

	public List<Command> GetAvailableCommands(){
		LinkedList<Command> out = new LinkedList<Command>();
		
		StateDirection dir = StateDirection.RIGHT;
		out.add(new MoveCommand(this,dir));
		out.addAll(super.GetAvailableCommands());
		return out;
	}
	
	public MoveAble(Vector2 pos, double hp, float speed) {
		super(pos, hp);
		// TODO Auto-generated constructor stub
		this.speed = speed;
		this.target = pos;
	}
	
	Random rnd = new Random();
	float jitter = 1.0f;
	boolean moving = false;
	/**
	 * Updates objects position
	 */
	public void Move(Field[][] states) {
		
		Vector2 tmp;
		if(moving){
			
			float restX =  Math.round(target.x);
			target.x = restX + (rnd.nextFloat() - 0.5f)*jitter;
			float restY =  Math.round(target.y);
			target.y = restY + (rnd.nextFloat() - 0.5f)*jitter;
			
			
		}
		// Check if object not at target
		if(this.pos.cpy().dst(this.target) != 0.0) {
			
			// Check if object is closer to target than step distance
			tmp = this.pos.cpy().sub(target);
			if (tmp.len() < (TickControl.gameSpeed*this.speed)) {
				this.pos = target;
				moving = false;
			} else {
				moving = true;
				// Calculate and update position new position
				// TODO check is we are to add or sub distance
				if (pos.x < target.x){
					this.pos.x = this.pos.x + TickControl.gameSpeed*this.speed*(Math.abs(this.pos.x-target.x)/tmp.len());					
				} else {
					this.pos.x = this.pos.x - TickControl.gameSpeed*this.speed*(Math.abs(this.pos.x-target.x)/tmp.len());
				}
				if (pos.y < target.y){
					this.pos.y = this.pos.y + TickControl.gameSpeed*this.speed*(Math.abs(this.pos.y-target.y)/tmp.len());
				} else {
					this.pos.y = this.pos.y - TickControl.gameSpeed*this.speed*(Math.abs(this.pos.y-target.y)/tmp.len());
				}
			}
			
		}
	}

	@Override
	public void Update(Field[][] states) {
		Move(states);
	}

}
