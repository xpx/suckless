package com.suckless;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.Color;
public class InfantryVisual extends GameObjectVisual {

	public InfantryVisual(Vector2 location) {
		super(location, new Vector2(0.4f,0.4f));
		ObjectColor = Color.PINK;
	}

}
