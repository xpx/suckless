package com.suckless;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.math.Vector2;


public abstract class GameObject {
	// Define owner
	public Player owner;
	
	public List<Command> GetAvailableCommands(){
		return new LinkedList<Command>();
	}
	
	// Is the object selected
	boolean selected;
	
	// Should it be possible to kill
	public boolean destroyable;
	
	// Position
	public Vector2 pos;
	
	// size of tile-array
	int maxX = 0,maxY = 0;
	
	public Player attacking = null;
	
	// HP
	public double hp;
	
	public GameObject(Vector2 pos, double hp, boolean destroyable) {
		this.pos = pos;
		this.hp = hp;
		this.destroyable = destroyable;
	}
	
	/**
	 * To be overridden
	 */
	public void Update(Field[][] states){
		maxX = states.length;
		maxY = states[0].length;
	}
	
	// Returns x pos rounded to nearest int
	public int getXTile() {
		return (int)Math.max(0,Math.min(maxX,Math.round(pos.x)));
	}
	// Returns x pos rounded to nearest int
	public int getYTile() {
		return (int)Math.max(0,Math.min(maxY,Math.round(pos.y)));
	}
	
}
