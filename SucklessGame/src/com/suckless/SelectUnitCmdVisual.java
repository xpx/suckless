package com.suckless;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL20;
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
		if(gdx.IsEs1){
			gdx.getSquareMesh().render(GL10.GL_TRIANGLE_STRIP);
		}else{
			gdx.sprog.SetCurrentColor(Color.YELLOW);
			gdx.sprog.SetObjectPosition(UnitLocation);
			gdx.sprog.SetObjectSize(UnitSize);
			gdx.getSquareMesh().render(gdx.sprog,GL20.GL_LINE_LOOP);
		}
		
	}

}
