package com.suckless;

import com.badlogic.gdx.math.Vector2;

public class Static extends GameObject {
	
	boolean passAble;
	boolean canBeOccupied;

	public Static(Vector2 pos, double hp, boolean passAble, boolean canBeOccupied) {
		super(pos, hp);
		// TODO Auto-generated constructor stub
		
		this.passAble = passAble;
		this.canBeOccupied = canBeOccupied;
	}
	
	public void Update(){
		// Pass
	}

}