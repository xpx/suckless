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
	
	// Position
	public Vector2 pos;
	
	// HP
	public double hp;
	
	public GameObject(Vector2 pos, double hp) {
		this.pos = pos;
		this.hp = hp;
	}
	
	/**
	 * To be overridden
	 */
	public abstract void Update(Field[][] states);
	
	// Returns x pos rounded to nearest int
	public int getXTile() {
		return (int)Math.round(pos.x);
	}
	// Returns x pos rounded to nearest int
	public int getYTile() {
		return (int)Math.round(pos.y);
	}
	
}
