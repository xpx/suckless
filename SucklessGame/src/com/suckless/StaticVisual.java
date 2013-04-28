package com.suckless;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class StaticVisual extends GameObjectVisual {

	public StaticVisual(GameObject go) {
		super(go, new Vector2(0.25f,0.25f));
		
	}
	
	@Override
	public void Draw(RenderState gdx) {
		ObjectColor = Color.WHITE;
		super.Draw(gdx);
		
	}
}
