package com.suckless;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.math.Vector2;


public class GameHandler {
	
	// St�rrelsen p� arrayet
	public int xSquares;
	public int ySquares;
	public StateHandler handle;
	public GameObject[] player1;
	public GameObject[] player2;
	public Player[] players;
	public Dictionary<Player,Command> commandDict;
	private ShufflerHeleDagen megaShuffler;
	
	// public SelectorGrande selector;
	private class playerEventHandler implements EventListener{

		Player playerObject;
		GameHandler gameHandler;
		playerEventHandler(Player plyObj, GameHandler handler){
			playerObject = plyObj;
			gameHandler = handler;
			
		}
		@Override
		public void Invoke() {
			gameHandler.onPlayerSelectEvent(playerObject);
			
		}
	}
	
	public void AddGameObject(GameObject go, Player player){
		int xtile = go.getXTile();
		int ytile = go.getYTile();
		go.owner = player;
		handle.stateArray[xtile][ytile].gameobject.add(go);
	}
	
	List<playerEventHandler> playerEventHandlers;
	
	GameHandler(Player[] players1,int sizeX,int sizeY){
		xSquares = sizeX;
		ySquares = sizeY;
		handle = new StateHandler(sizeX,sizeY);
		playerEventHandlers = new LinkedList<playerEventHandler>();
		players = players1;
		Random rnd = new Random();
		for(Player ply : players){
			playerEventHandler pListener = new playerEventHandler(ply,this);
			playerEventHandlers.add(pListener);
			EventBase evt = ply.getEvent();
			if(evt != null){
				evt.AddListener(pListener);
			}
			// AddGameObject(new Infantry(new Vector2(rnd.nextFloat(),rnd.nextFloat()), 10, 0.0f, 1.0),ply);
		}
		

		scenarioHardCode();
		
		
		
		commandDict = new Hashtable<Player,Command>();
	}
	
	private void scenarioHardCode()
	{
		// Virker til 10x10
		for(Field[] states : handle.stateArray){
			for(Field felt : states){
				felt.actualField = new FieldType("grass",0);
			}
		}
		
		// Hard coded game setup
		AddGameObject(new Infantry(new Vector2(1,1), 10, 0.0f, 1.0),players[0]);
		AddGameObject(new Tank(new Vector2(1,5), 10, 0.0f, 1.0,1),players[0]);
		AddGameObject(new Infantry(new Vector2(2,8), 10, 0.0f, 1.0),players[0]);
		
		// Hard coded game setup
		AddGameObject(new Infantry(new Vector2(9,1), 10, 0.0f, 1.0),players[1]);
		AddGameObject(new Infantry(new Vector2(9,3), 10, 0.0f, 1.0),players[1]);
		AddGameObject(new Tank(new Vector2(7,6), 10, 0.0f, 1.0,1),players[1]);
		
		// Add static objects public Static(Vector2 pos, double hp, boolean passAble, boolean canBeOccupied)
		AddGameObject(new Static(new Vector2(5,5), 1, false, false),null);
	}
	
	void onPlayerSelectEvent(Player player){
		Command cmd = commandDict.get(player).Select(handle.stateArray,player);
		if(cmd == null){
			List<GameObject> go = new GameState(handle.stateArray).GetAllGameObjects();
			for(GameObject go2 : go){
				if(go2.owner == player){
					ShufflerHeleDagen shd = new ShufflerHeleDagen(go2);	
					cmd = shd;
				}
			}
		}
		commandDict.put(player,cmd);
	}
	
//	// Init g�gl
//	GameHandler(GameObject[] x1, GameObject[] x2){
//		// Init players
//		player1 = x1;
//		player2 = x2;
//		
//		
//		// Initialiser statehandler-baben
//		handle = new StateHandler(xSquares,ySquares);
//		
//		// Send st�rrelsen videre ned til gameobject
//		this.Handle();
//	}
	
	// Handle functionen til at k�re the stuff
	public void  Handle()
	{
		// update all gameobjects function
		
		for(Field[] rows: handle.stateArray){
			for(Field cell : rows){
				for(GameObject go : cell.gameobject){
					go.Update();
				}
			}
		}
		
		for(int i = 0; i<players.length;i++)
		{
			players[i].getWorldData(handle.stateArray);
		}
	}
	
	// Handle functionen til at k�re the stuff
	public void  updateSelection()
	{
		//new GameObject(new Vector2(1,1),1,1,1);
		for(int i = 0; i<players.length;i++)
		{
			Player ply = players[i];
			Command obj = commandDict.get(ply);
			if(obj != null){
				obj = obj.Update(handle.stateArray, players[i]);
					
			}
			// aktiver shuffling
			if(obj == null){
				List<GameObject> go = new GameState(handle.stateArray).GetAllGameObjects();
				for(GameObject go2 : go){
					if(go2.owner == players[i]){
						ShufflerHeleDagen shd = new ShufflerHeleDagen(go2);	
						obj = shd;
					}
				}
			}
			commandDict.put(players[i],obj);
			players[i].CommandChanged(commandDict.get(players[i]));
		}
	}
	
}

