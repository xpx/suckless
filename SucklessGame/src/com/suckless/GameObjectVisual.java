package com.suckless;
import com.badlogic.gdx.graphics.GL10;
import java.util.Random;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.math.Vector2;
public class GameObjectVisual implements GameVisual{
	
	
	public Vector2 Loc;
	public Vector2 Size;
	public Color ObjectColor;
	public GameObjectVisual(Vector2 location,Vector2 size){
		Loc = location;
		Size = size;
		ObjectColor = Color.WHITE;
	}
	Random rgen = new Random();
	
	@Override
	public void Draw(RenderState gdx) {
		// TODO Auto-generated method stub
		//Loc = Loc.add(new Vector2(rgen.nextFloat() - 0.5f,rgen.nextFloat() - 0.5f));
		
		if(gdx.IsEs1){
			gdx.getSquareMesh().render(GL10.GL_TRIANGLE_STRIP);
			
		}else{
			gdx.sprog.SetCurrentColor(ObjectColor);
			gdx.sprog.SetObjectPosition(Loc);
			gdx.sprog.SetObjectSize(Size);
			gdx.getSquareMesh().render(gdx.sprog,GL20.GL_TRIANGLE_FAN);
		}
		
	}
	
	
	

}
