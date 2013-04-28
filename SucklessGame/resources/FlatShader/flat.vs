#version 120
attribute vec2 vertex_position;
uniform vec2 worldLocation;
uniform vec2 cameraPosition;
uniform float zoom;
uniform vec2 objectSize;
void main(){
	gl_Position = vec4((vertex_position*objectSize + worldLocation - cameraPosition)*zoom,0,1) * vec4(1.0,-1.0,0.0,1.0);
}