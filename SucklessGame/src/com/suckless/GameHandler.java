package com.suckless;
import java.util.ArrayList;


public class GameHandler {
	
	// St�rrelsen p� arrayet
	public static int xSquares = 10;
	public static int ySquares = 10;
	public StateHandler handle;
	// public SelectorGrande selector;
	
	
	// Init g�gl
	GameHandler(){
		// Initialiser statehandler-baben
		handle = new StateHandler(xSquares,ySquares);
		
		// Initialiser selectorgrande stuffet
		// selector = new SelectorGrande();
		
		// Send st�rrelsen videre ned til gameobject
		this.Handle();
	}
	
	// Handle functionen til at k�re the stuff
	public void  Handle()
	{
		// update all gameobjects function
		for (int i=0; i < xSquares; i++)
		{
			for (int j=0; j < ySquares; j++)
			{
				if (handle.stateArray[i][j].gameobject != null){
					for (int k=0; k<handle.stateArray[i][j].gameobject.length; k++){
						handle.stateArray[i][j].gameobject[k].Update();
					}
				}
			}
		}	
		
	}
	
	// Handle functionen til at k�re the stuff
	public void  updateSelection()
	{
		// selector.selectGameObject();
	}
}
