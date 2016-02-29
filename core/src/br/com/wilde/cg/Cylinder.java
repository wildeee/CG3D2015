package br.com.wilde.cg;

import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;

public class Cylinder extends TridimensionalObject {

	@Override
	public Model create() {
		return modelBuilder.createCylinder(
				  Config.CYLINDER.width
				, Config.CYLINDER.height
				, Config.CYLINDER.depth
				, Config.CYLINDER.divisions
				,  new Material(ColorAttribute.createDiffuse(Config.COR_DO_OBJETO)), Usage.Position | Usage.Normal);
	}

}
