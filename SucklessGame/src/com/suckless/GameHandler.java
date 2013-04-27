package com.suckless;
import java.util.ArrayList;


public class GameHandler {
	
	// Størrelsen på arrayet
	public static int xSquares = 10;
	public static int ySquares = 10;
	public StateHandler handle;
	
	
	// Init gøgl
	GameHandler(){
		handle = new StateHandler();
		handle.ConstructStateArray(xSquares,ySquares);
		
		// Send størrelsen videre ned til gameobject
		this.Handle();
	}
	
	// Handle functionen til at køre the stuff
	public void  Handle()
	{
		// update all gameobjects function
		for (int i=0; i < xSquares; i++)
		{
			for (int j=0; j < ySquares; j++)
			{
				// handle.stateArray[i][j].gameobject.update();
			}
		}	
		
	}
}
