package com.suckless;

public class Infantry extends MoveAble {
	
	public double damage;

	public Infantry(double x_pos, double y_pos, double hp, double speed, double damage) {
		super(x_pos, y_pos, hp, speed);
		// TODO Auto-generated constructor stub
		
		this.damage = damage;
	}
}
