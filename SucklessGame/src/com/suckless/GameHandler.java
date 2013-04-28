package com.suckless;
import java.util.ArrayList;
import java.util.Calendar;
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
	
	public GameHandler(Player[] players1,int sizeX,int sizeY){
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
			//AddGameObject(new Infantry(new Vector2(rnd.nextFloat(),rnd.nextFloat()), 10, 0.001f, 1.0),ply);
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
		for(float i = 2; i < 4;i++){
		AddGameObject(new Infantry(new Vector2(1,i), 10, 0.01f, 1.0),players[0]);
		AddGameObject(new Infantry(new Vector2(2,i), 10, 0.01f, 1.0),players[0]);
		AddGameObject(new Static(new Vector2(3,5), 10000, false, false),null);
		
		// Hard coded game setup
		AddGameObject(new Infantry(new Vector2(9,i), 10, 0.01f, 1.0),players[1]);
		AddGameObject(new Infantry(new Vector2(8,i), 10, 0.01f, 1.0),players[1]);
		}
		// Add static objects public Static(Vector2 pos, double hp, boolean passAble, boolean canBeOccupied)
		// AddGameObject(new Static(new Vector2(5,5), 1, false, false),null);
	}
	
	void onPlayerSelectEvent(Player player){
		Command cmd = commandDict.get(player);
		if(cmd != null ){
			cmd.Select(handle.stateArray,player);
		}
		
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
		updateAllObjectsToCells();
		
		// update all gameobjects function
		for(Field[] rows: handle.stateArray){
			for(Field cell : rows){
				for(GameObject go : cell.gameobject){
					go.Update(handle.stateArray);
				}
			}
		}
		
		for(int i = 0; i<players.length;i++)
		{
			players[i].getWorldData(handle.stateArray);
		}

		for(GameObject gameobj : new GameState(handle.stateArray).GetAllGameObjects()){
			//System.out.print("\n hp:" + gameobj.hp);
			if(gameobj.hp <= 0){
				handle.stateArray[gameobj.getXTile()][gameobj.getYTile()].gameobject.remove(gameobj);				
			}
		}

	}
	
	public void updateAllObjectsToCells(){
		for(int i = 0; i<handle.stateArray.length; i++){
			for(int j = 0; j<handle.stateArray[0].length; j++){
				List<GameObject> toChange = new LinkedList<GameObject>();
				for(GameObject gameobj : handle.stateArray[i][j].gameobject){
					gameobj.pos.x = Math.max(0, Math.min(gameobj.pos.x, handle.stateArray.length -1 + 0.4f));
					gameobj.pos.y = Math.max(0, Math.min(gameobj.pos.y, handle.stateArray[0].length -1 + 0.4f));
					if(new Vector2(gameobj.getXTile(),gameobj.getYTile()) != new Vector2(i,j)){
						toChange.add(gameobj);
						
					}
				}
				for(GameObject gameobj : toChange){
					handle.stateArray[i][j].gameobject.remove(gameobj);
					handle.stateArray[gameobj.getXTile()][gameobj.getYTile()].gameobject.add(gameobj);
				}
			}
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
				if(obj != null){
					commandDict.put(players[i],obj);
					players[i].CommandChanged(commandDict.get(players[i]));
				}
					
			}
			
			// aktiver shuffling
			if(obj == null){
				List<GameObject> go = new GameState(handle.stateArray).GetAllGameObjects();
				for(GameObject go2 : go){
					if(go2.owner == players[i]){
						ShufflerHeleDagen shd = new ShufflerHeleDagen(go2);	
						commandDict.put(players[i],shd);
						players[i].CommandChanged(commandDict.get(players[i]));
						obj = shd;
						break;
					}
				}
			}
			
		}
	}
	
}

