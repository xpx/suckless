package com.suckless;

public class Static extends GameObject {
	
	boolean passAble;
	boolean canBeOccupied;

	public Static(double x_pos, double y_pos, double hp, boolean passAble, boolean canBeOccupied) {
		super(x_pos, y_pos, hp);
		// TODO Auto-generated constructor stub
		
		this.passAble = passAble;
		this.canBeOccupied = canBeOccupied;
	}

}
