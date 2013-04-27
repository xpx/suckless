package com.suckless;

public class MoveCommand extends Selecter{
	MoveCommand(GameObject inputObject, int x1, int y1) {
		super(inputObject, x1, y1);
		// TODO Auto-generated constructor stub
	}
		
	public void handleSelect(){
		switch(direction){
		case UP:	
			break;
		case DOWN:	
			break;
		}
	}
}
