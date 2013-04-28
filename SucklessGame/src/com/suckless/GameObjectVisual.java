package com.suckless;
import com.badlogic.gdx.graphics.GL10;
import java.util.Random;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.math.Vector2;
public class GameObjectVisual implements GameVisual{
	public enum UnitState{
		PLAYER,
		ENEMY,
		NEUTRAL
	}
	
	public Color GetPlayerColor(UnitState unitState){
		if(unitState == UnitState.PLAYER){
			return Color.BLUE;
		}else if(unitState == UnitState.ENEMY){
			return Color.RED;
		}else{
			return Color.GRAY;
		}
	}
	
	public UnitState unitstate;
	public Vector2 Loc;
	public Vector2 Size;
	public Color ObjectColor;
	public double hpRel;
	
	public GameObjectVisual(GameObject go,Vector2 size){
		hpRel = go.hp / go.MaxHp;
		Loc = go.pos;
		Size = size;
		ObjectColor = Color.WHITE;
	}
	Random rgen = new Random();
	
	@Override
	public void Draw(RenderState gdx){
		DrawSquareMesh(gdx);
	}
	
	public void DrawMesh(RenderState gdx, Mesh mesh){
		if(gdx.IsEs1){
			gdx.getSquareMesh().render(GL10.GL_TRIANGLE_STRIP);
			
		}else{
			gdx.sprog.SetCurrentColor(ObjectColor);
			gdx.sprog.SetObjectPosition(Loc);
			gdx.sprog.SetObjectSize(Size);
			mesh.render(gdx.sprog,GL20.GL_TRIANGLE_FAN);
		}
	}
	public void DrawSquareMesh(RenderState gdx) {
		DrawMesh(gdx,gdx.getSquareMesh());
		
	}
	public void DrawTriangleMesh(RenderState gdx) {
		DrawMesh(gdx,gdx.getTriangleMesh());
		
	}
	
	public void DrawHealthBar(RenderState gdx, Vector2 location){
		float rel = (float) hpRel / 2.0f;
		Vector2 size = new Vector2(rel,0.0f);
		Vector2 halfsize = new Vector2(rel / 2f,0.0f);
		gdx.sprog.SetCurrentColor(Color.YELLOW);
		gdx.sprog.SetObjectPosition(Loc.cpy().sub(halfsize));
		gdx.sprog.SetObjectSize(size);
		gdx.getUnitLine().render(gdx.sprog,GL20.GL_LINE_LOOP);
	}
	
	
	

}
