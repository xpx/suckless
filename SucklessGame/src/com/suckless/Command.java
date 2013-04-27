package com.suckless;

public class Command {
	GameObject selectedObject;
	Command(GameObject inputObject){
		selectedObject = inputObject;
	}
	
	// Brugeren trykker enter
	public Command Select(){
		return new Command(selectedObject);
	}
	
	public Command Update(Field[][] states, Player player){
		return this;
	}
	
	
}
