package com.suckless;


import java.util.List;
import java.util.LinkedList;
import java.util.Random;

import com.badlogic.gdx.math.Vector2;

public class Infantry extends MoveAble {
	
	public double damage;
	public double range = 0.5;
	Random rn;
	
	public Infantry(Vector2 pos, double hp, float speed, double damage) {
		super(pos, hp, speed);
		rn = new Random();
		
		this.damage = damage;
	}
	
	private void DealDamage(List<GameObject> objlist){
		GameObject gameobj = objlist.get(rn.nextInt(objlist.size()));
		gameobj.hp = gameobj.hp-damage;
	}
	
	public void FindInteraction(Field[][] states){
		// Attack close random object
		List<GameObject> objlist = new LinkedList<GameObject>();
		for (int i = Math.max(this.getXTile()-(int)Math.ceil(range),0); i<Math.min(this.getXTile()+(int)Math.ceil(range)+1,states.length);i++){
			for (int j = Math.max(this.getYTile()-(int)Math.ceil(range),0); j<Math.min(this.getYTile()+(int)Math.ceil(range)+1,states[0].length);j++){
				if (states[i][j].gameobject.isEmpty() == false)
				{
					for(GameObject gameobj : states[i][j].gameobject){
						if (gameobj.owner != this.owner)
						{
							if (withinCirle(gameobj)){
								objlist.add(gameobj);
							}
							
						}
					}
				}
			}
		}
		if (objlist.isEmpty() == false){
			DealDamage(objlist);
		}
	}
	
	private boolean withinCirle(GameObject target)
	{
		double distance = Math.sqrt(Math.pow(this.pos.x-target.pos.x, 2)+Math.pow(this.pos.y-target.pos.y, 2));
		if(distance < range){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void Update(Field[][] states) {
		// Implement special cases for infantry
		FindInteraction(states);
		super.Update(states);
	}
}
