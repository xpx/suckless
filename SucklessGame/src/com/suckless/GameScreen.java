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
	GameHandler gameHandler;
	EventBase keyPressInvoke;
	Command CurrentCommand;
	Field[][] CurrentWorldState;
	
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
	VisualFactory visFact = new VisualFactory(this);
	/*Runs the rendering*/
	int iteration = 0;
	@Override
	public void render(float delta) {
		if(iteration % 4 == 0){
			gameHandler.Handle();
		}
		if(iteration++ % 5  ==0){
		gameHandler.updateSelection();
		}
		GLCommon gl = Gdx.gl;
		if(shader == null){
			shader = new FlatColorShader();
		}
		t += delta;
		//gl.glClearColor(1.0f/2.0f, (float)Math.sin(t) * 0.5f/2.0f + 0.5f/2.0f, 0.0f, 1.0f);
		gl.glClearColor(0.0f,0.0f, 0.0f, 1.0f);
		
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		gl.glEnable(Gdx.gl20.GL_BLEND);
		gl.glLineWidth(0.5f);
		RenderState rendState = new RenderState();
		rendState.sprog = shader;
		rendState.IsEs1 = false;
		rendState.Zoom = 1.0f / 10f;
		rendState.LookAt(new Vector2(5.0f,5.0f));
		shader.begin();
		shader.SetObjectSize(new Vector2(1,1));
		shader.SetCameraPosition(rendState.CurrentCameraPosition,rendState.Zoom * 2f);
		
		List<GameVisual> visuals = new LinkedList<GameVisual>();
		int x = 0;
		CellDrawer cd = new CellDrawer();
		for(Field[] col : CurrentWorldState){
			int y = 0;
			for(Field cell : col){
				cd.Draw(rendState,x,y);
				y++;
			}
			x++;
		}
		
		if(CurrentWorldState != null){
			List<GameObject> gameObjects = new GameState(CurrentWorldState).GetAllGameObjects();
			
			for(GameObject gobj : gameObjects){
				visuals.add(visFact.GetVisual(gobj));
			}
		}
		if(CurrentCommand != null){
			visuals.add(visFact.GetCommandVisual(CurrentCommand));
			}
		
		for(GameVisual vis : visuals){
			vis.Draw(rendState);
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
		CurrentWorldState = fields;
		
	}
	@Override
	public EventBase getEvent() {
		return keyPressInvoke;
	}
	@Override
	public void CommandChanged(Command command) {
		CurrentCommand = command;
		
	}
}
