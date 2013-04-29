package com.suckless;

import com.badlogic.gdx.math.Vector2;

public class Static extends GameObject {
	
	boolean passAble;
	boolean canBeOccupied;

	public Static(Vector2 pos, double hp, boolean destroyable, boolean passAble, boolean canBeOccupied, Player subOwner) {
		super(pos, hp, destroyable);
		
		this.passAble = passAble;
		this.canBeOccupied = canBeOccupied;
		this.owner = subOwner;
	}
	
	public void Update(Field[][] states){
		super.Update(states);
	}

}
