package com.suckless;

import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Vector2;

public class RenderState {
static protected Mesh squareMesh;
	
	public Mesh getSquareMesh(){
		if(squareMesh == null){
			squareMesh = new Mesh(true,4*2,4,new VertexAttribute(0,2,"vertex_position"));
			squareMesh.setVertices(new float[]{-1.0f,-1.0f,1.0f,-1.0f,1.0f,1.0f,-1.0f,1.0f});
			squareMesh.setIndices(new short[]{0,1,2,3});
		}
		return squareMesh;
	}
	
	Mesh triangleMesh;
	public Mesh getTriangleMesh(){
		if(triangleMesh == null){
			triangleMesh = new Mesh(true,3*2,4,new VertexAttribute(0,2,"vertex_position"));
			triangleMesh.setVertices(new float[]{-1.0f,-1.0f,1.0f,-1.0f,1.0f,1.0f});
			triangleMesh.setIndices(new short[]{0,1,2});
		}
		return triangleMesh;
	}
	
	Mesh unitLine;
	
	public Mesh getUnitLine(){
		if(unitLine == null){
			unitLine = new Mesh(true,2*2,2,new VertexAttribute(0,2,"vertex_position"));
			unitLine.setVertices(new float[]{0.0f,.0f,1.0f,1.0f});
			unitLine.setIndices(new short[]{0,1,});
		}
		return unitLine;
	}
	
	Mesh circleShape;
	public Mesh getUnitCircle(){
		if(circleShape == null){
			float[] circleData = new float[512];
			short[] indices = new short[256];
			for(int i = 0;i < 256;i += 2){
				indices[i/2] = (short) (i / 2);
				float phase = (float)i / 256.0f * 2 *(float)Math.PI; 
				float x = (float) Math.sin(phase);
				float y = (float) Math.cos(phase);
				circleData[i] = x;
				circleData[i+1] = y;
				
			}
			circleShape = new Mesh(true,2*256,256,new VertexAttribute(0,2,"vertex_position"));
			circleShape.setVertices(circleData);
			circleShape.setIndices(indices);
		}
		return circleShape;
	}
	
	public boolean IsEs1 = false;
	public FlatColorShader sprog;
	Vector2 CurrentCameraPosition;
	
	public RenderState(){
		CurrentCameraPosition = new Vector2(0.0f,0.0f);
		Zoom = 1.0f;
	}
	
	public float Zoom;
	
	
	
	public void SetZoom(float amount){
		Vector2 currentLookPos = CurrentCameraPosition.cpy();
		Zoom = amount;
		LookAt(currentLookPos);
	}
	
	public void LookAt(Vector2 position){
		CurrentCameraPosition = position.cpy();
	}
	
}
