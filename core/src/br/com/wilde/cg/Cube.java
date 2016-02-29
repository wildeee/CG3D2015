package br.com.wilde.cg;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;

public class Cube extends TridimensionalObject {

	public Cube(){
		super();
	}
	
	public Model create(){
		return modelBuilder.createBox(2f, 4f, 6f, new Material(ColorAttribute.createDiffuse(Color.WHITE)), Usage.Position | Usage.Normal);
	}
	
}
