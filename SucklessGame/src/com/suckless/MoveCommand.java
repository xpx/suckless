package com.suckless;

public class MoveCommand extends Command{
	public int x,y;
	public enum StateDirection {
    LEFT,
    RIGHT,
    UP,
    DOWN,
    NONE
	}
	MoveCommand(GameObject inputObject,int x1, int y1) {
		super(inputObject);
		x = x1;
		y = y1;
		

	}
	
	@Override
	public Command Update(){
		return new MoveCommand(selectedObject,x+1,y);
	}

}
