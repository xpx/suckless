package com.suckless;

import java.util.LinkedList;
import java.util.List;

public class ShufflerHeleDagen extends Command {
	ShufflerHeleDagen(GameObject inputObject) {
		super(inputObject);
		// TODO Auto-generated constructor stub
	}
	
	// Returner en liste af alle game objects med en given player
	private List<GameObject> createGameObjectList(Field[][] states, Player player){
		List<GameObject> objectList = new LinkedList<GameObject>();
		for(Field[] state : states){
			for(Field stat : state){
				for(GameObject gameobj : stat.gameobject){
					if(gameobj.owner == player){
						objectList.add(gameobj);
					}
				}
			}
		}
		return objectList;
	}

	int it = 0;
	
	public Command MegaHand(Field[][] states, Player player){
		if(it++ % 4 != 0){
			return this;
		}
		
		List<GameObject> shuffleList = createGameObjectList(states, player);
		if(shuffleList.isEmpty() == false){
			selectedObject.selected = false;
			if(shuffleList.indexOf(selectedObject)+1 >= shuffleList.size()){
				selectedObject = shuffleList.get(0);
			}
			else{
				selectedObject = shuffleList.get(shuffleList.indexOf(selectedObject)+1);
			}
			selectedObject.selected = true;
		}
		return this;
	}
	boolean stop = false;

	@Override
	public void Select(Field[][] states, Player player) {
		stop = true;
	}



	@Override
	public Command Update(Field[][] states, Player player) {
		if(stop){
			List<Command> availCmd = this.selectedObject.GetAvailableCommands();
			if(availCmd.isEmpty()){
				return null;
			}
			return availCmd.get(0);
		}
		return MegaHand(states, player);
	}
}
