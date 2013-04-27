package com.suckless;

public class SelectLocationCmdVisual implements CommandVisual {
	int cellX;
	int cellY;
	SelectLocationCmdVisual(int cellX, int cellY){
		this.cellX = cellX;
		this.cellY = cellY;
	}
	
	@Override
	public void Draw(RenderState gdx) {
		for(int i = 0 ; i < cellX; i++){
			drawAt(gdx,i,0);
		}
		for(int i = 0; i < cellY;i++){
			drawAt(gdx,cellX,i);
		}
	}
	void drawAt(RenderState gdx, int x, int y){
		
	}

}
