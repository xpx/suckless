package com.suckless;

/*
 * Event for objects that can register to a event
 * */
public interface EventListener {
	
	/*
	 * What to do when the event is invoked.
	 * */
	void Invoke();

}
