package com.suckless;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class StaticVisual extends GameObjectVisual {

	public StaticVisual(Vector2 location) {
		super(location, new Vector2(0.2f,0.4f));
		
	}
	
	@Override
	public void Draw(RenderState gdx) {
		ObjectColor = Color.WHITE;
		super.Draw(gdx);
		
	}
}
