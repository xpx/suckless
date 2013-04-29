package com.suckless;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.math.Vector2;

public class MapHandler {
	int level;
	Player user;
	GameMOD gameMOD;
	Map map;
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
	
	public void Update(StateHandler handle,Player[] players){
		switch(gameMOD){
		case NONE:			
							break;
		case SINGLEPLAYER:	List<Player> player = new GameState(handle.stateArray).GetAllPlayersAlive(handle.stateArray);
							if(player.size() <= 1){
								if(player.isEmpty() == false){
									if(player.get(0) == user){
										level++;
									}
								}
								switch(level){
									case 0:	handle.resetStateArray();
											map = new Scenario1(players);
											map.blitMap(handle.stateArray);
											System.out.print("Scenario 1");
										break;
									case 1: handle.resetStateArray();
											map = new Scenario2(players);
											map.blitMap(handle.stateArray);
											System.out.print("Scenario 2");
										break;
									case 2:	handle.resetStateArray();
											map = new Scenario3(players);
											map.blitMap(handle.stateArray);
											System.out.print("Scenario 3"); 
										break;
									case 3:	handle.resetStateArray();
											map = new Scenario4(players);
											map.blitMap(handle.stateArray);
											System.out.print("Scenario 4"); 
										break;
									default:
										break;
								}
							}
							break;
		case MULTIPLAYER:	
							break;
		}
	}
}
