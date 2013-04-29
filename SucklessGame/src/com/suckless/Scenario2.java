package com.suckless;

import com.badlogic.gdx.math.Vector2;

public class Scenario2 extends Map {
	Scenario2(Player[] players){	 
		for(float i = 1; i < 10;i++){
			objectList.add(new Infantry(new Vector2(1,i), 10, true, 0.01f, 1.0,2,players[0]));
			objectList.add(new Infantry(new Vector2(2,i), 10, true, 0.01f, 1.0,2,players[0]));
			objectList.add(new Infantry(new Vector2(9,i), 10, true, 0.01f, 1.0,2,players[1]));
			objectList.add(new Infantry(new Vector2(8,i), 10, true, 0.01f, 1.0,2,players[1]));
		}
	}
}
