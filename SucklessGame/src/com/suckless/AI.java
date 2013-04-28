package com.suckless;

import java.util.ArrayList;
import java.util.List;
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
	public Field[][] stateArray;
	int cnt;
	int nextTarget;
	AI This;
	boolean inited;
	List<GameObject> objects;
	
	public AI(){
		This = this;
		rnd = new Random();
		ink = new EventBase();
		cnt = 0;
		inited = false; 
		objects = new ArrayList<GameObject>();

		new Timer().schedule(new TimerTask() { 
			public void run()  { 
				
				if (!inited) {
					objects = GetOwnObjects(stateArray);
					if (objects != null)
						inited = true;

				}else{
				for(Field[] rows: stateArray){
					for(Field cell : rows){
						for(GameObject go : cell.gameobject){
							if(go.owner == This){
								if (go.equals(objects.get(cnt))) {
									if (go.pos.x == 0.0 && go.pos.y == 0.0 )
										cnt++;
								if (go.selected)
									ink.Invoke();
								//System.out.printf("Ai obj %d, at pos: %f,%f\n", System.identityHashCode(go), go.pos.x, go.pos.y);
								}
							}
								
						}
					}
				}
				}
			}
		}, 0, 10);
		
	}
	
	public List<GameObject> GetOwnObjects(Field[][] state) {
		List<GameObject> objects = new ArrayList<GameObject>();
		if (state != null) {
			for (Field[] rows : state) {
				for (Field cell : rows) {
					for (GameObject go : cell.gameobject) {
						if (go.owner == This) {
							objects.add(go);
							System.out
									.printf("Added object %d which is at pos %f, %f \n",
											System.identityHashCode(go),
											go.pos.x, go.pos.y);
						}
					}
				}
			}
			return objects;
		}
		return null;
		
	}
	
	@Override
	public void getWorldData(Field[][] fields) {
		this.stateArray = fields;
	}

	@Override
	public EventBase getEvent() {
		return ink;
	}

	@Override
	public void CommandChanged(Command command) {
	}

}
