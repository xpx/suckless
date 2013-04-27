package com.suckless;

public interface Player {
	// Det store array og selected - arrayet af fields
	void getWorldData(Field[][] fields);
	EventBase getEvent();
	
	void CommandChanged(Command command);

}
