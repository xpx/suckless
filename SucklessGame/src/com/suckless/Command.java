package com.suckless;

public class Command {
	GameObject selectedObject;
	Command(GameObject inputObject){
		selectedObject = inputObject;
	}
	
	// Brugeren trykker enter
	public Command Select(Field[][] states, Player player){
		return new Command(selectedObject);
	}
	
	public Command Update(Field[][] states, Player player){
		return this;
	}
}
