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
			return new InfantryVisual(go.pos);
		}
		return new GameObjectVisual(go.pos,new Vector2(1.0f,1.0f));
	}
	
	public GameObjectVisual GetVisual(GameObject go){
		
		GameObjectVisual gov = visualLut.get(go);
		if(gov == null){
			gov = makeGameObjectVisual(go);
			visualLut.put(go, gov);
		}
		return gov;
		
	}

}
