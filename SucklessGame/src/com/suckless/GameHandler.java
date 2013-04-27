package com.suckless;
import java.util.ArrayList;


public class GameHandler {
	
	// Stï¿½rrelsen pï¿½ arrayet
	public static int xSquares = 10;
	public static int ySquares = 10;
	public StateHandler handle;
	public SelectorGrande selector;
	
	
	// Init gï¿½gl
	GameHandler(){
		// Initialiser statehandler-baben
		handle = new StateHandler(xSquares,ySquares);
		
		// Initialiser selectorgrande stuffet
		selector = new SelectorGrande();
		
		// Send stï¿½rrelsen videre ned til gameobject
		this.Handle();
	}
	
	// Handle functionen til at kï¿½re the stuff
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
	
	// Handle functionen til at køre the stuff
	public void  updateSelection()
	{
		selector.selectGameObject();
	}
}
