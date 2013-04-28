package com.suckless;

import java.util.Dictionary;
import java.util.Hashtable;

import com.badlogic.gdx.math.Vector2;

public class VisualFactory {
	
	Dictionary<GameObject,GameObjectVisual> visualLut;
	
	public VisualFactory(){
		visualLut = new Hashtable<GameObject,GameObjectVisual>();
	}
	
	GameObjectVisual makeGameObjectVisual(GameObject go){
		if(go instanceof Infantry){
			return new InfantryVisual(go.pos.cpy());
		}
		return new GameObjectVisual(go.pos.cpy(),new Vector2(1.0f,1.0f));
	}
	
	public GameObjectVisual GetVisual(GameObject go){
		
		GameObjectVisual gov = null;//visualLut.get(go);
		if(gov == null){
			gov = makeGameObjectVisual(go);
			visualLut.put(go, gov);
		}
		
		return gov;
	}
	
	public CommandVisual GetCommandVisual(Command cmd){
		if(cmd instanceof Selecter){
			Selecter slc = (Selecter) cmd;
			return new SelectLocationCmdVisual(slc.x,slc.y);
		}else if(cmd instanceof ShufflerHeleDagen){
			return new SelectUnitCmdVisual(cmd.selectedObject.pos,new Vector2(1.0f,1.0f));
		}
		return new GenericCommandVisual();
	}
}
