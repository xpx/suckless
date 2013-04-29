package com.suckless;
import java.util.List;

import com.suckless.Field;
import com.suckless.GameObject;
import com.suckless.GameState;
import com.suckless.Map;
import com.suckless.Player;


public class Intro extends Map {
	Intro(){
		System.out.print("Intro");
	}
	
	@Override 
	public boolean endCondition(Field[][] states, Player user){
		return true;
	}
	
	@Override
	public boolean victoryCondition(Field[][] states, Player user){
		return false;
	}
}
