package com.suckless;
import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GLCommon;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
/*
 * Does the actual rendering and input stuff.
 * */
public class GameScreen implements Screen, Player {

	List<GameVisual> visuals;
	InputListener mainInputListener;
	FlatColorShader shader;
	OrthographicCamera cam;
	GameHandler gameHandler;
	EventBase keyPressInvoke;

	
	/*
	 * Sets up the gamescreen and adds input listeners
	 * */
	public GameScreen(){
		keyPressInvoke = new EventBase();
		mainInputListener = new InputListener();
		visuals = new LinkedList<GameVisual>();
		Gdx.input.setInputProcessor(mainInputListener);
		mainInputListener.ActionEvent.AddListener(keyPressInvoke);
	}
	
	float t;
	/*Runs the rendering*/
	@Override
	public void render(float delta) {
		GLCommon gl = Gdx.gl;
		if(shader == null){
			shader = new FlatColorShader();
		}
		t += delta;
		gl.glClearColor(1.0f, (float)Math.sin(t) * 0.5f + 0.5f, 0.0f, 1.0f);
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		RenderState rendState = new RenderState();
		rendState.sprog = shader;
		rendState.IsEs1 = false;
		rendState.Camera = cam;
		shader.begin();
		shader.SetObjectSize(new Vector2(1,1));
		shader.SetCameraPosition(new Vector2(0,0),0.05f);
		//cam.view
		for(GameVisual vis : visuals){
			if(vis instanceof GameObjectVisual){
				GameObjectVisual gobjVis = (GameObjectVisual) vis;
				gobjVis.Draw(rendState);
			}
		}
		shader.end();
		
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
	@Override
	public void getWorldData(Field[][] fields) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public EventBase getEvent() {
		return keyPressInvoke;
	}
	@Override
	public void CommandChanged(Command command) {
		// TODO Auto-generated method stub
		
	}
}
