package com.suckless;

import java.util.LinkedList;
import java.util.List;

// Game object er null, n�r der intet er p� feltet
public class Field {
	public List<GameObject> gameobject;
	public FieldType actualField;
	public Field(FieldType fieldType){
		gameobject = new LinkedList<GameObject>();
		actualField = fieldType;
	}
	
}
