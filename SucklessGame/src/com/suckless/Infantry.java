package com.suckless;

import com.badlogic.gdx.math.Vector2;

public class Infantry extends MoveAble {
	
	public double damage;
	public int range = 1;

	public Infantry(Vector2 pos, double hp, float speed, double damage) {
		super(pos, hp, speed);
		
		this.damage = damage;
	}
	
	public void DealDamage(Field[][] states){
/*		// Attack close random object
		for (int i = this.getXTile()-range; i<this.getXTile()+range;i++){
			for (int j = this.getXTile()-range; j<this.getXTile()+range;j++);{
				if (states[i][j].gameobject.)
			}
		}*/
	}
	
	public void Update(Field[][] states) {
		// Implement special cases for infantry
		super.Update(states);
		DealDamage(states);
	}
}
