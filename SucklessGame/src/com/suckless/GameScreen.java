package com.suckless;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GLCommon;
/*
 * Does the actual rendering and input stuff.
 * */
public class GameScreen implements Screen {

	
	InputListener mainInputListener;
	/*
	 * Sets up the gamescreen and adds input listeners
	 * */
	public GameScreen(){
		mainInputListener = new InputListener();
		Gdx.input.setInputProcessor(mainInputListener);
		mainInputListener.ActionEvent.AddListener(new EventTest());
	}
	
	float t;
	/*Runs the rendering*/
	@Override
	public void render(float delta) {
		GLCommon gl = Gdx.gl;
		t += delta;
		gl.glClearColor(1.0f, (float)Math.sin(t) * 0.5f + 0.5f, 0.0f, 1.0f);
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		Gdx.input.setInputProcessor(null);
		
	}

}
