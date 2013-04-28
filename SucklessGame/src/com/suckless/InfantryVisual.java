package com.suckless;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
public class InfantryVisual extends GameObjectVisual {

	Vector2 targetLoc;
	float range;
	public InfantryVisual(Infantry infantryObject) {
		super(infantryObject.pos.cpy(),new Vector2(0.2f,0.2f));
		range = (float) infantryObject.range;
		targetLoc = infantryObject.target;
		
	}
	@Override
	public void Draw(RenderState gdx) {
		ObjectColor = GetPlayerColor(unitstate);
		super.Draw(gdx);
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
			
			
		//}
	}

}
