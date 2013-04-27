package com.suckless;
public class StateHandler {
	public static Field[][] stateArray;
	
	StateHandler(int x, int y){
		this.ConstructStateArray(x, y);
	}
	
	public void ConstructStateArray(int x, int y)
	{
		stateArray= new Field[x][y];	
		Field objecto = new Field();
		objecto.selected = true;
		objecto.actualField = new FieldType("grass",2);
		
		for (int i=0; i < x; i++)
		{
			for (int j=0; j < x; j++)
			{
				stateArray[i][j] = objecto;

			}
		}	
	}
}
