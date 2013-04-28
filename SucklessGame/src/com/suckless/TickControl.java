package com.suckless;
import java.awt.List;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import com.badlogic.gdx.math.Vector2;

public class TickControl {
	
	public static float gameSpeed = 100;
	public static long tickSize = 100;
	public static long updateSelector = 200;
	
	public static void startTickControl(final GameHandler gameHandling){
		new Timer().schedule(new TimerTask() { 
			public void run()  { 
				gameHandling.Handle();
			}
		}, 0, tickSize);
		
		new Timer().schedule(new TimerTask() { 
			public void run()  { 
				gameHandling.updateSelection();
			}
		}, 0, updateSelector);
	}
}
