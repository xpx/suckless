package com.suckless;
import java.util.ArrayList;


public class GameHandler {
	
	// St�rrelsen p� arrayet
	public static int xSquares = 10;
	public static int ySquares = 10;
	public StateHandler handle;
	
	
	// Init g�gl
	GameHandler(){
		handle = new StateHandler();
		handle.ConstructStateArray(xSquares,ySquares);
		
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
				//handle.stateArray[i][j].gameobject.Update();
			}
		}	
		
	}
}