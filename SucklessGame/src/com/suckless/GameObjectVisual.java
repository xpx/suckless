package com.suckless;
import com.badlogic.gdx.graphics.GL10;
import java.util.Random;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.math.Vector2;
public class GameObjectVisual implements GameVisual{
	static protected Mesh squareMesh;
	
	Mesh getSquareMesh(){
		if(squareMesh == null){
			squareMesh = new Mesh(true,4*2,4,new VertexAttribute(0,2,"vertex_position"));
			squareMesh.setVertices(new float[]{-1.0f,-1.0f,1.0f,-1.0f,1.0f,1.0f,-1.0f,1.0f});
			squareMesh.setIndices(new short[]{0,1,2,3});
		}
		return squareMesh;
	}
	
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
		Loc = Loc.add(new Vector2(rgen.nextFloat() - 0.5f,rgen.nextFloat() - 0.5f));
		
		if(gdx.IsEs1){
			getSquareMesh().render(GL10.GL_TRIANGLE_STRIP);
			
		}else{
			gdx.sprog.SetCurrentColor(ObjectColor);
			gdx.sprog.SetObjectPosition(Loc);
			gdx.sprog.SetObjectSize(Size);
			getSquareMesh().render(gdx.sprog,GL20.GL_TRIANGLE_FAN);
		}
		
	}
	
	
	

}
