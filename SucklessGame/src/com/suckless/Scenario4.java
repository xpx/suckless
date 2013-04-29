package com.suckless;

import com.badlogic.gdx.math.Vector2;

public class Scenario4 extends Map {
	Scenario4(Player[] players){	
		for(float i = 1; i < 10;i++){
			objectList.add(new Infantry(new Vector2(1,i), 30, true, 0.01f, 1.0,2,players[0]));
			objectList.add(new Infantry(new Vector2(2,i), 30, true, 0.01f, 1.0,2,players[0]));
		}
		objectList.add(new Static(new Vector2(5,0), 1, false, false, false,null));
		objectList.add(new Static(new Vector2(5,2), 1, false, false, false,null));
		objectList.add(new Static(new Vector2(5,4), 1, false, false, false,null));
		objectList.add(new Static(new Vector2(5,6), 1, false, false, false,null));
		objectList.add(new Static(new Vector2(5,8), 1, false, false, false,null));
		
		objectList.add(new Infantry(new Vector2(9,5), 150, true, 0.01f, 2.5,2,players[1]));
	}

}
