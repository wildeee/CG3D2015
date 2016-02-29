package br.com.wilde.cg;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

public abstract class TridimensionalObject {
	
	protected ModelBuilder modelBuilder;

	public TridimensionalObject() {
		this.modelBuilder = new ModelBuilder();
	}
	
	public abstract Model create();
}
