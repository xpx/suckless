package com.suckless;

public class Tank extends MoveAble {

	public double damage;
	public double range;
	
	public Tank(double x_pos, double y_pos, double hp, double speed, double damage, double range) {
		super(x_pos, y_pos, hp, speed);
		// TODO Auto-generated constructor stub
		
		this.damage = damage;
		this.range = range;
	}

}
