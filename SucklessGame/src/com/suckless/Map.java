package com.suckless;

import java.util.LinkedList;
import java.util.List;

public abstract class Map {
	List<GameObject> objectList = new LinkedList<GameObject>();
	
	public boolean victoryCondition(Field[][] states, Player user){
		List<Player> player = new GameState(states).GetAllPlayersAlive(states);
		if(player.isEmpty() == false){
			if(player.get(0) == user){
				return true;
			}
		}
		return false;
	}
		
	public boolean endCondition(Field[][] states, Player user){
		List<Player> player = new GameState(states).GetAllPlayersAlive(states);
		if(player.size() <= 1){
			return true;
		}
		return false;
	}
	
	public void AddGameObject(GameObject go, Field[][] states){
		int xtile = go.getXTile();
		int ytile = go.getYTile();
		states[xtile][ytile].gameobject.add(go);
	}
	
	public void blitMap(Field[][] states) {
		for(GameObject obj : objectList){
			AddGameObject(obj,states);
		}
	}
}
