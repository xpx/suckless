package com.suckless;

import com.badlogic.gdx.math.Vector2;

public class Scenario3 extends Map {
	Scenario3(Player[] players){
		for(float i = 1; i < 6;i++){
			objectList.add(new Infantry(new Vector2(1,i*2-1), 10, true, 0.01f, 1.0,3,players[0]));
			objectList.add(new Infantry(new Vector2(9,i), 10, true, 0.01f, 1.0,2,players[1]));
			objectList.add(new Infantry(new Vector2(9,i+5), 10, true, 0.01f, 1.0,2,players[1]));
		}
		
		objectList.add(new Static(new Vector2(3,1), 1, false, false, false,null));
		objectList.add(new Static(new Vector2(3,3), 1, false, false, false,null));
		objectList.add(new Static(new Vector2(3,5), 1, false, false, false,null));
		objectList.add(new Static(new Vector2(3,7), 1, false, false, false,null));
		objectList.add(new Static(new Vector2(3,9), 1, false, false, false,null));
		
		objectList.add(new Static(new Vector2(5,0), 1, false, false, false,null));
		objectList.add(new Static(new Vector2(5,2), 1, false, false, false,null));
		objectList.add(new Static(new Vector2(5,4), 1, false, false, false,null));
		objectList.add(new Static(new Vector2(5,6), 1, false, false, false,null));
		objectList.add(new Static(new Vector2(5,8), 1, false, false, false,null));
		
		objectList.add(new Static(new Vector2(7,1), 1, false, false, false,null));
		objectList.add(new Static(new Vector2(7,3), 1, false, false, false,null));
		objectList.add(new Static(new Vector2(7,5), 1, false, false, false,null));
		objectList.add(new Static(new Vector2(7,7), 1, false, false, false,null));
		objectList.add(new Static(new Vector2(7,9), 1, false, false, false,null));
		
	}

}
