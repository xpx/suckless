package com.suckless;

import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

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
	public boolean IsEs1 = false;
	public FlatColorShader sprog;
	public OrthographicCamera Camera;
}
