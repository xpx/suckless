package com.suckless;
import java.util.LinkedList;
import java.util.List;
/*
 * Minimalistic implementation of Events.
 * */
public class EventBase implements EventListener {
	List<EventListener> listeners = new LinkedList<EventListener>();
	/*
	 * Invokes calles invoke on all registered listeners
	 * */
	public void Invoke(){
		for(EventListener evl: listeners){
			evl.Invoke();
		}
	}
	
	/*
	 * Registers a listener to this class
	 * */
	public void AddListener(EventListener listener){
		listeners.add(listener);
	}
}
