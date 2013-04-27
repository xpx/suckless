package com.suckless;
import java.awt.List;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import com.badlogic.gdx.math.Vector2;

public class TickControl {
	
	public static float gameSpeed = 100;
	public static long tickSize = 100;
	public static long updateSelector = 500;
	
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
	
	public static void main(String[] args) {
		// Player 1
		GameObject[] player1 = new GameObject;
		player1[0] = new Infantry(new Vector2(1.0f,1.0f),1,1,1);
		player1[1] = new Infantry(new Vector2(1.0f,1.0f),1,1,1);
		
		// Player 2
		GameObject[] player2 = null;
		player2[0] = new Infantry(new Vector2(1.0f,1.0f),1,1,1);
		player2[1] = new Infantry(new Vector2(1.0f,1.0f),1,1,1);
		
		
		final GameHandler gameHandling = new GameHandler(player1,player2);
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
