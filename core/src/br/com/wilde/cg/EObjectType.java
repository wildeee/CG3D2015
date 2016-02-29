package br.com.wilde.cg;

import com.badlogic.gdx.graphics.g3d.Model;

public enum EObjectType {
	
	 RETANGULO(new Rectangle())
	,CONE     (new Cone())
	,CILINDRO (new Capsule())
	,CAPSULA  (new Capsule())
	,ESFERA   (new Sphere())
	;
	
	
	
	private TridimensionalObject obj;
	private EObjectType(TridimensionalObject obj){
		this.obj = obj;
	}
	public Model getModel() {
		return obj.create();
	}
	
}
