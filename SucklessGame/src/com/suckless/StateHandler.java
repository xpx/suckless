package com.suckless;
public class StateHandler {
	public Field[][] stateArray;
	
	StateHandler(int x, int y){
		this.ConstructStateArray(x, y);
	}
	
	public void ConstructStateArray(int x, int y)
	{
		stateArray= new Field[x][y];	
		for (int i=0; i < x; i++)
		{
			for (int j=0; j < x; j++)
			{
				Field objecto = new Field(new FieldType("grass",2));
				stateArray[i][j] = objecto;
			}
		}	
	}
	
	public void resetStateArray(){
		int x = stateArray.length;
		int y = stateArray[0].length;
		for (int i=0; i < x; i++)
		{
			for (int j=0; j < x; j++)
			{
				Field objecto = new Field(new FieldType("grass",2));
				stateArray[i][j] = objecto;
			}
		}	
	}
}
