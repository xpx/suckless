package com.suckless;

public class MoveAble extends GameObject {
	
	public double speed;

	public MoveAble(double x_pos, double y_pos, double hp, double speed) {
		super(x_pos, y_pos, hp);
		// TODO Auto-generated constructor stub
		this.speed = speed;
	}

}
