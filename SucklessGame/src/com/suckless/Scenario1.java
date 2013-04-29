package com.suckless;

import java.util.List;

import com.badlogic.gdx.math.Vector2;

public class Scenario1 extends Map {
	Scenario1(Player[] players){		
		for(float i = 2; i < 4;i++){
			objectList.add(new Infantry(new Vector2(1,i), 10, true, 0.01f, 1.0,2,players[0]));
			objectList.add(new Infantry(new Vector2(2,i), 10, true, 0.01f, 1.0,2,players[0]));
			objectList.add(new Infantry(new Vector2(8,i), 10, true, 0.01f, 1.0,2,players[1]));
		}
		objectList.add(new Static(new Vector2(4,3), 1, false, false, false,null));
		objectList.add(new Static(new Vector2(4,4), 1, false, false, false,null));
		objectList.add(new Static(new Vector2(4,5), 1, false, false, false,null));
		objectList.add(new Static(new Vector2(4,6), 1, false, false, false,null));
	}
}
	
	