package com.suckless;

import java.util.Dictionary;
import java.util.Hashtable;

import com.badlogic.gdx.math.Vector2;

public class VisualFactory {
	
	Dictionary<GameObject,GameObjectVisual> visualLut;
	Player player;
	public VisualFactory(Player theplayer){
		player = theplayer;
		visualLut = new Hashtable<GameObject,GameObjectVisual>();
	}
	
	GameObjectVisual makeGameObjectVisual(GameObject go){
		if(go instanceof Infantry){
			return new InfantryVisual((Infantry)go);

		} else if (go instanceof Static) {
			return new StaticVisual(go);
		}
		return new GameObjectVisual(go,new Vector2(1.0f,1.0f));
	}
	
	public GameObjectVisual GetVisual(GameObject go){
		
		GameObjectVisual gov = visualLut.get(go);
		if(gov == null){
			
			gov = makeGameObjectVisual(go);
			
			if(go.owner == player){
				gov.unitstate = GameObjectVisual.UnitState.PLAYER;
			}else if(go.owner == null){
				gov.unitstate = GameObjectVisual.UnitState.NEUTRAL;
			}else{
				gov.unitstate = GameObjectVisual.UnitState.ENEMY;
			}
			visualLut.put(go, gov);
			
		}
		gov.Update(go);
		
		return gov;
	}
	
	public CommandVisual GetCommandVisual(Command cmd){
		if(cmd instanceof Selecter){
			Selecter slc = (Selecter) cmd;
			return new SelectLocationCmdVisual((Selecter)cmd );
		}else if(cmd instanceof ShufflerHeleDagen){
			return new SelectUnitCmdVisual((ShufflerHeleDagen)cmd);
		}
		return new GenericCommandVisual();
	}
}
