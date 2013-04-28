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
		float newXPos;
		float newYPos;
		
		// Check if object not at target
		if(this.pos.cpy().dst(this.target) != 0.0) {
			
			// Check if object is closer to target than step distance
			tmp = this.pos.cpy().sub(target);
			if (tmp.len() < (TickControl.gameSpeed*this.speed)) {
				this.pos = target;
				moving = false;
			} else {
				if(!moving){
					
					float restX =  Math.round(target.x);
					target.x = restX + (rnd.nextFloat() - 0.5f)*jitter;
					float restY =  Math.round(target.y);
					target.y = restY + (rnd.nextFloat() - 0.5f)*jitter;
				}
				moving = true;
				// Calculate and update position new position
				// TODO check is we are to add or sub distance
				newXPos = 0.0f;
				newYPos = 0.0f;
				if (pos.x < target.x && pos.y < target.y){
					newXPos = this.pos.x + TickControl.gameSpeed*this.speed*(Math.abs(this.pos.x-target.x)/tmp.len());
					newYPos = this.pos.y + TickControl.gameSpeed*this.speed*(Math.abs(this.pos.y-target.y)/tmp.len());
				} else if (pos.x > target.x && pos.y < target.y) {
					newXPos = this.pos.x - TickControl.gameSpeed*this.speed*(Math.abs(this.pos.x-target.x)/tmp.len());
					newYPos = this.pos.y + TickControl.gameSpeed*this.speed*(Math.abs(this.pos.y-target.y)/tmp.len());
				} else if (pos.x < target.x && pos.y > target.y) {
					newXPos = this.pos.x + TickControl.gameSpeed*this.speed*(Math.abs(this.pos.x-target.x)/tmp.len());
					newYPos = this.pos.y - TickControl.gameSpeed*this.speed*(Math.abs(this.pos.y-target.y)/tmp.len());
				} else if (pos.x > target.x && pos.y > target.y) {
					newXPos = this.pos.x - TickControl.gameSpeed*this.speed*(Math.abs(this.pos.x-target.x)/tmp.len());
					newYPos = this.pos.y - TickControl.gameSpeed*this.speed*(Math.abs(this.pos.y-target.y)/tmp.len());
				}
				if (ValidMove(newXPos, newYPos, states)) {
					this.pos.x = newXPos;
					this.pos.y = newYPos;
				}
			}
			
		}
	}
	
	public boolean ValidMove(float x, float y, Field[][] states) {
		Static tmp;
		if (states[Math.min(9, Math.round(x))][Math.min(9,Math.round(y))].gameobject.isEmpty() == false) {
			for (GameObject gameObj : states[Math.min(9, Math.round(x))][Math.min(9,Math.round(y))].gameobject) {
				if (gameObj instanceof Static) {
					tmp = (Static)gameObj;
					if (tmp.passAble == false) {
						return false;
					}
				}
			}
		}
		
		return true;
	}

	@Override
	public void Update(Field[][] states) {
		Move(states);
	}

}
