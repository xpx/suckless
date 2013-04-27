package com.suckless;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

import com.badlogic.gdx.math.Vector2;


public class GameHandler {
	
	// Størrelsen på arrayet
	public int xSquares = 10;
	public int ySquares = 10;
	public StateHandler handle;
	public GameObject[] player1;
	public GameObject[] player2;
	public Player[] players;
	public Dictionary<Player,Command> commandDict;
	private ShufflerHeleDagen megaShuffler;
	
	// public SelectorGrande selector;
	
	GameHandler(Player[] players1){
		players = players1;
		commandDict = new Hashtable<Player,Command>();
		megaShuffler = new ShufflerHeleDagen();
	}
	
	
//	// Init gøgl
//	GameHandler(GameObject[] x1, GameObject[] x2){
//		// Init players
//		player1 = x1;
//		player2 = x2;
//		
//		
//		// Initialiser statehandler-baben
//		handle = new StateHandler(xSquares,ySquares);
//		
//		// Send størrelsen videre ned til gameobject
//		this.Handle();
//	}
	
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
		for(int i = 0; i<players.length;i++)
		{
			players[i].getWorldData(handle.stateArray);
		}
	}
	
	// Handle functionen til at køre the stuff
	public void  updateSelection()
	{
		//new GameObject(new Vector2(1,1),1,1,1);
		for(int i = 0; i<players.length;i++)
		{
			Command obj = commandDict.get(players[i]).Update(handle.stateArray, players[i]);
			// aktiver shuffling
			if(obj == null){
				megaShuffler.MegaHand(handle.stateArray);
			}
			else{
				commandDict.put(players[i],obj);
			}
			players[i].CommandChanged(commandDict.get(players[i]));
		}
	}
	
}

