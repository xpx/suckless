package com.suckless;

import com.badlogic.gdx.math.Vector2;

public class Infantry extends MoveAble {
	
	public double damage;
	public int range = 4;

	public Infantry(Vector2 pos, double hp, float speed, double damage) {
		super(pos, hp, speed);
		
		this.damage = damage;
	}
	
	private void DealDamage(GameObject gameobj){
		gameobj.hp = gameobj.hp-damage;
		//System.out.print("Game HP: " + gameobj.hp + "\n");
	}
	
	public void FindInteraction(Field[][] states){
		// Attack close random object
		// System.out.printf("koord: " + Math.max(this.getXTile()-range,0) + " : "+ Math.min(this.getXTile()+range,states.length) + " - " + Math.max(this.getYTile()-range,0) + " : " + Math.min(this.getYTile()+range,states[0].length) + " \n");
		for (int i = Math.max(this.getXTile()-range,0); i<Math.min(this.getXTile()+range,states.length);i++){
			for (int j = Math.max(this.getYTile()-range,0); j<Math.min(this.getYTile()+range,states[0].length);j++){
				if (states[i][j].gameobject.isEmpty() == false)
				{
					for(GameObject gameobj : states[i][j].gameobject){
						if (gameobj.owner != this.owner)
						{
							DealDamage(gameobj);
							return;
						}
					}
				}
			}
		}
	}
	
	public void Update(Field[][] states) {
		// Implement special cases for infantry
		super.Update(states);
		FindInteraction(states);
	}
}
