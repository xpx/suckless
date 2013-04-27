package com.suckless;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Vector2;

public class FlatColorShader extends ShaderProgram {

	public FlatColorShader() {
		
		super(FileUtil.readFile("resources/FlatShader/flat.vs"), 
				FileUtil.readFile("resources/FlatShader/flat.fs"));
		boolean ok = this.isCompiled();
		System.out.println(ok);
	}
	
	public void SetCurrentColor(double R, double G, double B, double A){
		this.setUniformf("Color",(float)R,(float)G,(float)B,(float)A);
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
