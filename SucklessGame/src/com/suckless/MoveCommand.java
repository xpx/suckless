package com.suckless;

public class MoveCommand extends Selecter{

	
	public int x,y,maxX,maxY;
	public StateDirection direction;
	
	MoveCommand(GameObject inputObject,int x1, int y1, int maxX1, int maxY1) {
		super(inputObject);
		x = x1;
		y = y1;
		

	}
	
	@Override
	public Command Select(){
		
	}
	
	@Override
	public Command Update(){
		switch(direction){
			case LEFT:	if(x == 0){
							// nyt objekt skal v�lges
						}
						else{
							x = x-1;
						}
							
				break;
			case RIGHT:	if(x == maxX){
							// nyt objekt skal v�lges
						}
						else{
							x = x+1;
						}
				break;
			case UP:	if(y == 0){
							// nyt objekt skal v�lges
						}
						else{
							y = y-1;
						}
				break;
			case DOWN:	if(y == maxX){
							// nyt objekt skal v�lges
						}
						else{
							y = y+1;
						}
				break;
			default:
				break;
		}
			
			
			
		return new MoveCommand(selectedObject,x+1,y);
	}

}
