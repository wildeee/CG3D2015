package br.com.wilde.cg;

import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;

public class Rectangle extends TridimensionalObject {

	@Override
	public Model create(){
		return modelBuilder.createBox(
				  Config.CUBE.width
				, Config.CUBE.height
				, Config.CUBE.depth
				, new Material(ColorAttribute.createDiffuse(Config.COR_DO_OBJETO)), Usage.Position | Usage.Normal
		);
	}
	
}
