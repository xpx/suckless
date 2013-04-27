package com.suckless;
import java.util.ArrayList;


public class GameHandler {
	
	// Størrelsen på arrayet
	public static int xSquares = 10;
	public static int ySquares = 10;
	public StateHandler handle;
	public GameObject[] player1;
	public GameObject[] player2;
	
	// public SelectorGrande selector;
	
	
	// Init gøgl
	GameHandler(GameObject[] x1, GameObject[] x2){
		// Init players
		player1 = x1;
		player2 = x2;
		
		
		// Initialiser statehandler-baben
		handle = new StateHandler(xSquares,ySquares);
		
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
				if (handle.stateArray[i][j].gameobject != null){
					for (int k=0; k<handle.stateArray[i][j].gameobject.length; k++){
						handle.stateArray[i][j].gameobject[k].Update();
					}
				}
			}
		}	
	}
	
	// Handle functionen til at køre the stuff
	public void  updateSelection()
	{
		updatePlayer(this.player1);
		updatePlayer(this.player2);
	}
	
	// Ret spillerne
	private void updatePlayer(GameObject[] player){
		int x1;
		x1 = findPlayerIndex(player);
			player[x1].selected = false;
		if (x1 < player.length-1)
		{
			player[x1+1].selected = true;
		}
		else
		{
			player[0].selected = true;
		}
	}
	
	// Find objectet der er selected
	private int findPlayerIndex(GameObject[] player)
	{
		int x1 = 0;
		if(player != null)
		{
			for(int i=0; i<player.length; i++){
				if (player[i].selected == true){
					x1 = i;
					break;
				}
			}
		}
		return x1;
	}
}

