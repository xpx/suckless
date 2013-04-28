package com.suckless;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL20;
public class InfantryVisual extends GameObjectVisual {

	public InfantryVisual(Vector2 location) {
		super(location, new Vector2(0.4f,0.4f));
		
	}
	@Override
	public void Draw(RenderState gdx) {
		ObjectColor = GetPlayerColor(unitstate);
		super.Draw(gdx);
		
	}

}
