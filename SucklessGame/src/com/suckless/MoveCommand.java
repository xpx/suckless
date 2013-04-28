package com.suckless;

import com.badlogic.gdx.math.Vector2;

public class MoveCommand extends Selecter{
	MoveCommand(GameObject inputObject, int x1, int y1) {
		super(inputObject, x1, y1);
		// TODO Auto-generated constructor stub
	}
		

	public Command handleSelect(GameObject inputObject){
		inputObject.selected = false;
		Vector2 temp = new Vector2(x,y);
		((MoveAble)inputObject).target = temp;
		return null;
	}
}
