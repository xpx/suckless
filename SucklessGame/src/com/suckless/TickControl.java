package com.suckless;
import java.awt.List;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class TickControl {
	
	public static double gameSpeed = 100;
	public static long tickSize = 100;
	
	public static void main(String[] args) {
		final GameHandler gameHandling = new GameHandler();
		new Timer().schedule(new TimerTask() { 
			public void run()  { 
				gameHandling.Handle();
			}
		}, 0, tickSize);
	}
}