package com.suckless;
// Typen af stuff - den skal v�re blittable med update function
public class FieldType {
	public String type;
	public double penalty;
	
	FieldType(String x, double y)
	{
		this.type = x;
		this.penalty = y;
	}
	
	// Update stuff -> graphics og m�ske om der er blod eller ej
	public void update()
	{
		
	}
}
