package com.suckless;

public class ShufflerHeleDagen extends Command {
	ShufflerHeleDagen(GameObject inputObject) {
		super(inputObject);
		// TODO Auto-generated constructor stub
	}

	public Command MegaHand(StateHandler states){
		Player player;
		for(Field[] state : states.stateArray){
			for(Field stat : state){
				for(GameObject gameobj : stat.gameobject)
				{
					player = gameobj.owner;
					if(player != null){
						 return 
					}
				}
			}
		}
		return null;
	}
}
