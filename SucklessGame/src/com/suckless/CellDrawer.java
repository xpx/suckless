package com.suckless;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;

public class CellDrawer {
	void Draw(RenderState gdx, int x, int y){
		if(gdx.IsEs1){
			gdx.getSquareMesh().render(GL10.GL_TRIANGLE_STRIP);
			
		}else{
			gdx.sprog.SetCurrentColor(0.3f,.3f,0.3f,0.5f);
			gdx.sprog.SetObjectPosition(new Vector2((float)x, (float)y));
			gdx.sprog.SetObjectSize(new Vector2(1.0f,1.0f));
			gdx.getSquareMesh().render(gdx.sprog,GL20.GL_LINE_LOOP);
			
		}
	}

}
