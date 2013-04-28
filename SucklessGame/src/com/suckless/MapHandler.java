package com.suckless;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.math.Vector2;

public class MapHandler {
	int level;
	Player user;
	GameMOD gameMOD;
	public enum GameMOD{
		NONE,
		SINGLEPLAYER,
		MULTIPLAYER
	}
	
	MapHandler(Player player){
		level = 0;
		user = player;
		gameMOD = GameMOD.SINGLEPLAYER;
	}
	
	public void AddGameObject(GameObject go, Player player, Field[][] states){
		int xtile = go.getXTile();
		int ytile = go.getYTile();
		go.owner = player;
		states[xtile][ytile].gameobject.add(go);
	}
	
	
	private void scenario1(Field[][] states,Player[] players)
	{
		// Virker til 10x10
		for(Field[] states1 : states){
			for(Field felt : states1){
				felt.actualField = new FieldType("grass",0);
			}
		}
		
		// Hard coded game setup
		for(float i = 2; i < 4;i++){
		AddGameObject(new Infantry(new Vector2(1,i), 10, true, 0.01f, 1.0),players[0],states);
		AddGameObject(new Infantry(new Vector2(2,i), 10, true, 0.01f, 1.0),players[0],states);
		
		AddGameObject(new Static(new Vector2(4,3), 1, false, false, false),null,states);
		AddGameObject(new Static(new Vector2(4,4), 1, false, false, false),null,states);
		AddGameObject(new Static(new Vector2(4,5), 1, false, false, false),null,states);
		AddGameObject(new Static(new Vector2(4,6), 1, false, false, false),null,states);
		
		// Hard coded game setup
		// AddGameObject(new Infantry(new Vector2(9,i), 10, true, 0.01f, 1.0),players[1],states);
		AddGameObject(new Infantry(new Vector2(8,i), 10, true, 0.01f, 1.0),players[1],states);
		}
		// Add static objects public Static(Vector2 pos, double hp, boolean passAble, boolean canBeOccupied)
		// AddGameObject(new Static(new Vector2(5,5), 1, false, false),null);
	}
	
	private void scenario2(Field[][] states,Player[] players)
	{
		// Virker til 10x10
		for(Field[] states1 : states){
			for(Field felt : states1){
				felt.actualField = new FieldType("grass",0);
			}
		}
		
		// Hard coded game setup
		for(float i = 1; i < 10;i++){
		AddGameObject(new Infantry(new Vector2(1,i), 10, true, 0.01f, 1.0),players[0],states);
		AddGameObject(new Infantry(new Vector2(2,i), 10, true, 0.01f, 1.0),players[0],states);
		
		
		// Hard coded game setup
		AddGameObject(new Infantry(new Vector2(9,i), 10, true, 0.01f, 1.0),players[1],states);
		AddGameObject(new Infantry(new Vector2(8,i), 10, true, 0.01f, 1.0),players[1],states);
		}
		// Add static objects public Static(Vector2 pos, double hp, boolean passAble, boolean canBeOccupied)
		// AddGameObject(new Static(new Vector2(5,5), 1, false, false),null);
	}

	
	public void Update(StateHandler handle,Player[] players){
		if(gameMOD == GameMOD.SINGLEPLAYER){
			List<Player> player = new GameState(handle.stateArray).GetAllPlayersAlive(handle.stateArray);
			if(player.size() <= 1){
				if(player.isEmpty() == false){
					if(player.get(0) == user){
						level++;
					}
				}
				switch(level){
					case 0:	scenario1(handle.stateArray,players);
							System.out.print("Scenario 1");
						break;
					case 1: handle.resetStateArray();
							scenario2(handle.stateArray,players);
							System.out.print("Scenario 2");
						break;
					default:
							break;
				}
			}
		}
	}
}
