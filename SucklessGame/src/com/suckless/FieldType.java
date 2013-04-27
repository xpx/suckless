package com.suckless;
// Typen af stuff - den skal være blittable med update function
public class FieldType {
	public String type;
	public double penalty;
	
	FieldType(String x, double y)
	{
		this.type = x;
		this.penalty = y;
	}
	
	// Update stuff -> graphics og måske om der er blod eller ej
	public void update()
	{
		
	}
}
