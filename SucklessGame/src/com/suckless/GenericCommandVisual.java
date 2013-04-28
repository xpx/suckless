package com.suckless;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;

public class GenericCommandVisual implements CommandVisual {

	@Override
	public void Draw(RenderState gdx) {
		if(gdx.IsEs1){
			gdx.getSquareMesh().render(GL10.GL_TRIANGLE_STRIP);
		}else{
			gdx.sprog.SetCurrentColor(Color.CYAN);
			gdx.sprog.SetObjectPosition(new Vector2(0.0f,0.0f));
			gdx.sprog.SetObjectSize(new Vector2(1.0f,1.0f));
			gdx.getSquareMesh().render(gdx.sprog,GL20.GL_TRIANGLE_FAN);
		}
	}

}
