package com.suckless;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Vector2;

public class FlatColorShader extends ShaderProgram {

	public FlatColorShader() {
		super("#version 120 \nprecision mediump float;\n attribute vec2 vertex_position; uniform vec2 worldLocation;\n" +
				"uniform vec2 cameraPosition; uniform float zoom;uniform vec2 objectSize;\n"+
				"void main(){\n gl_Position = vec4((vertex_position*objectSize + worldLocation - cameraPosition)*zoom,0.0,1.0) * vec4(1.0,-1.0,0.0,1.0);\n}\n",
				"#version 120\nprecision mediump float;\nuniform vec4 Color;\nvoid main(){\ngl_FragColor = Color;\n}\n");
		/*super(FileUtil.readFile("resources/FlatShader/flat.vs"), 
				FileUtil.readFile("resources/FlatShader/flat.fs"));*/
		boolean ok = this.isCompiled();
		if(!ok){
			System.out.println("Error while compiling shaders:");
			System.out.println(this.getLog());
		}
	}
	
	public void SetCurrentColor(double R, double G, double B, double A){
		this.setUniformf("Color",(float)R,(float)G,(float)B,(float)A);
	}
	
	public void SetCurrentColor(Color col){
		this.setUniformf("Color", col);
	}
	
	public void SetCameraPosition(Vector2 cameraPosition,float zoom){
		this.setUniformf("cameraPosition",cameraPosition);
		this.setUniformf("zoom",zoom);
	}
	
	public void SetObjectSize(Vector2 objectSize){
		this.setUniformf("objectSize",objectSize);
	}
	
	public void SetObjectPosition(Vector2 loc){
		this.setUniformf("worldLocation",loc);
	}

	
	public void UpdateCamera(OrthographicCamera cam){
		this.setUniformMatrix("camera", cam.view);
		//this.setUniformMatrix("projection", cam.projection);
	}
	

}
