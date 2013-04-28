package com.suckless;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
public class GameMain extends Game {

	/*
	 * Creates the game object*/
	@Override
	public void create() {
		GameScreen gs = new GameScreen();
		GameHandler gh = new GameHandler(new Player[]{gs, new AI()},10,10);
		gs.gameHandler = gh;
		setScreen(gs);
		
	}
	
}
