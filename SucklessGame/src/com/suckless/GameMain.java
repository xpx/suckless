package com.suckless;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
public class GameMain extends Game {

	/*
	 * Creates the game object*/
	@Override
	public void create() {
		GameScreen gs = new GameScreen();
		
		setScreen(gs);
		TickControl.startTickControl(new GameHandler(new Player[]{gs, new AI()}));
		
		
	}
	
}
