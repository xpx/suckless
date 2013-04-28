package com.suckless;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
public class InfantryVisual extends GameObjectVisual {

	Vector2 targetLoc;
	GameObject LastAttack;
	float range;
	
	@Override
	public void Update(GameObject go){
		super.Update(go);
		Infantry inf = (Infantry) go;
		hpRel = go.hp / go.MaxHp;
		Loc = go.pos;
		LastAttack = inf.attacking;
		range = (float) inf.range;
		targetLoc = inf.target;
	}
	
	public InfantryVisual(Infantry infantryObject) {
		super(infantryObject,new Vector2(0.2f,0.2f));
		
		
	}
	int it = 0;
	@Override
	public void Draw(RenderState gdx) {
		ObjectColor = GetPlayerColor(unitstate);
		DrawSquareMesh(gdx);//super.Draw(gdx);
		//if(unitstate == UnitState.PLAYER){
			Mesh unitLine = gdx.getUnitLine();
			gdx.sprog.SetCurrentColor(ObjectColor);
			gdx.sprog.SetObjectPosition(Loc);
			gdx.sprog.SetObjectSize(targetLoc.cpy().sub(Loc));
			gdx.unitLine.render(gdx.sprog,GL20.GL_LINE_LOOP);
			gdx.sprog.SetCurrentColor(ObjectColor);
			gdx.sprog.SetObjectPosition(Loc);
			gdx.sprog.SetObjectSize(new Vector2(range,range));
			gdx.getUnitCircle().render(gdx.sprog,GL20.GL_LINE_LOOP);
			
			if(LastAttack != null && ((it++ % 5) == 0)){
				gdx.sprog.SetCurrentColor(Color.ORANGE);
				gdx.sprog.SetObjectPosition(Loc);
				gdx.sprog.SetObjectSize(LastAttack.pos.cpy().sub(Loc));
				unitLine.render(gdx.sprog,GL20.GL_LINE_LOOP);
			}
			DrawHealthBar(gdx,Loc);
			
			
		//}
	}

}
