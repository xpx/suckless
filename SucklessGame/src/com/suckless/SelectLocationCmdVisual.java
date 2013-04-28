package com.suckless;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;

public class SelectLocationCmdVisual implements CommandVisual {
	int cellX;
	int cellY;
	SelectLocationCmdVisual(int cellX, int cellY){
		this.cellX = cellX;
		this.cellY = cellY;
	}
	
	@Override
	public void Draw(RenderState gdx) {
		for(int i = 0 ; i <= cellX; i++){
			drawAt(gdx,i,0);
		}
		for(int i = 0; i <= cellY;i++){
			drawAt(gdx,cellX,i);
		}
	}
	void drawAt(RenderState gdx, float x, float y){
		if(gdx.IsEs1){
			gdx.getSquareMesh().render(GL10.GL_TRIANGLE_STRIP);
		}else{
			gdx.sprog.SetCurrentColor(Color.CYAN);
			gdx.sprog.SetObjectPosition(new Vector2(x,y));
			gdx.sprog.SetObjectSize(new Vector2(0.2f,0.2f));
			gdx.getSquareMesh().render(gdx.sprog,GL20.GL_TRIANGLE_FAN);
		}
	}

}
