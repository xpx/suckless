package com.suckless;

public abstract class Command {
	GameObject selectedObject;
	Command(GameObject inputObject){
		selectedObject = inputObject;
	}
	
	// Brugeren trykker enter
	public abstract void Select(Field[][] states, Player player);
	
	public abstract Command Update(Field[][] states, Player player);
}
