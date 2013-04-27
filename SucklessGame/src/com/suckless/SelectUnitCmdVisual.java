package com.suckless;

import com.badlogic.gdx.math.Vector2;

public class SelectUnitCmdVisual implements CommandVisual {
	Vector2 UnitLocation;
	Vector2 UnitSize;
	public SelectUnitCmdVisual(Vector2 loc, Vector2 size){
		UnitLocation = loc;
		UnitSize = size;
	}
	
	@Override
	public void Draw(RenderState gdx) {
		
		
	}

}
