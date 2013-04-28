package com.suckless;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class AI implements Player{
	class counter{
		public int A;
	}
	EventBase ink;
	Timer tmr;
	Random rnd;
	int cnt;
	int nextTarget;
	public AI(){
		rnd = new Random();
		ink = new EventBase();
		cnt = 0;
		new Timer().schedule(new TimerTask() { 
			public void run()  { 
				cnt += 1;
				if(cnt >= nextTarget){
					cnt = 0;
					nextTarget = (rnd.nextInt(500)) / 10;
					ink.Invoke();
				}
			}
		}, 0, 10);
		
		
	}
	
	@Override
	public void getWorldData(Field[][] fields) {
		
		
	}

	@Override
	public EventBase getEvent() {
		return ink;
	}

	@Override
	public void CommandChanged(Command command) {
		
	}

}
