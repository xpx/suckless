package com.suckless;

public abstract class Selecter extends Command {
	public enum StateDirection {
	    LEFT,
	    RIGHT,
	    UP,
	    DOWN,
	    NONE
	}
	
	public int x,y,maxX,maxY;
	public StateDirection direction;
	
	Selecter(GameObject inputObject,int x1, int y1) {
		super(inputObject);
		x = x1;
		y = y1;
	}
	
	public abstract void handleSelect();
	
	@Override
	public Command Select(){
		switch(direction){
		case LEFT:	direction = StateDirection.DOWN;
			break;
		case RIGHT:	direction = StateDirection.UP;
			break;
		case UP:	handleSelect();
			break;
		case DOWN:	handleSelect();
			break;
		default:
			break;
		}
		return null;
	}
	
		@Override
	public Command Update(Field[][] states, Player player){
			maxX = states.length;
			maxY = states[0].length;
		switch(direction){
			case LEFT:	if(x == 0){
							return null;
						}
						else{
							x = x-1;
						}			
				break;
			case RIGHT:	if(x == maxX){
							return null;
						}
						else{
							x = x+1;
						}
				break;
			case UP:	if(y == 0){
							return null;
						}
						else{
							y = y-1;
						}
				break;
			case DOWN:	if(y == maxX){
							return null;
						}
						else{
							y = y+1;
						}
				break;
			default:
				break;
		}
		return this;
	}
}
