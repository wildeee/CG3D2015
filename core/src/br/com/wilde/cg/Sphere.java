package br.com.wilde.cg;

import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;

public class Sphere extends TridimensionalObject {

	@Override
	public Model create() {
		return modelBuilder.createSphere(
				  Config.SPHERE.width
				, Config.SPHERE.height
				, Config.SPHERE.depth
				, Config.SPHERE.divisionsU
				, Config.SPHERE.divisionsV
				, new Material(ColorAttribute.createDiffuse(Config.COR_DO_OBJETO)), Usage.Position | Usage.Normal);
	}

}
