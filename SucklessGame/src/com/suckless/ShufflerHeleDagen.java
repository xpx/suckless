package com.suckless;

import java.util.List;

public class ShufflerHeleDagen extends Command {
	ShufflerHeleDagen(GameObject inputObject) {
		super(inputObject);
		// TODO Auto-generated constructor stub
	}
	
	

	public Command MegaHand(Field[][] states){
		Player player;
		for(Field[] state : states){
			for(Field stat : state){
				for(GameObject gameobj : stat.gameobject)
				{
					player = gameobj.owner;
					if(player != null){
						 this.selectedObject = gameobj;
					}
				}
			}
		}
		return this;
	}



	@Override
	public Command Select(Field[][] states, Player player) {
		List<Command> availCmd = this.selectedObject.GetAvailableCommands();
		if(availCmd.isEmpty()){
			return null;
		}
		return availCmd.get(0);
	}



	@Override
	public Command Update(Field[][] states, Player player) {
		return MegaHand(states);
	}
}
