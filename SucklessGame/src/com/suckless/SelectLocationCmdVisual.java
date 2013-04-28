package com.suckless;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;

public class SelectLocationCmdVisual implements CommandVisual {
	int cellX;
	int cellY;
	Vector2 objLoc;
	SelectLocationCmdVisual(Selecter cmd){
		this.cellX = cmd.x;
		this.cellY = cmd.y;
		objLoc = cmd.selectedObject.pos;
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
			/*gdx.sprog.SetCurrentColor(Color.BLACK);
			gdx.sprog.SetObjectPosition(new Vector2(x,y));
			gdx.sprog.SetObjectSize(new Vector2(0.1f,0.1f));
			gdx.getSquareMesh().render(gdx.sprog,GL20.GL_TRIANGLE_FAN);*/
			 
			gdx.sprog.SetCurrentColor(Color.YELLOW );
			gdx.sprog.SetObjectPosition(objLoc);
			gdx.sprog.SetObjectSize(new Vector2(0.2f,0.2f));
			gdx.getSquareMesh().render(gdx.sprog,GL20.GL_TRIANGLE_FAN);
			gdx.sprog.SetCurrentColor(Color.YELLOW );
			gdx.sprog.SetObjectPosition(new Vector2(x,y));
			gdx.sprog.SetObjectSize(new Vector2(0.2f,0.2f));
			gdx.getSquareMesh().render(gdx.sprog,GL20.GL_LINE_LOOP);
		}
	}

}
