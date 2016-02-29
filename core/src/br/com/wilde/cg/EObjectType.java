package br.com.wilde.cg;

import com.badlogic.gdx.graphics.g3d.Model;

public enum EObjectType {
	
	 RETANGULO(new Rectangle(), "Retângulo",1)
	,CONE     (new Cone(), "Cone", 2)
	,CILINDRO (new Cylinder(), "Cilindro", 3)
	,CAPSULA  (new Capsule(), "Cápsula", 4)
	,ESFERA   (new Sphere(), "Esfera", 5)
	;
	
	
	
	private TridimensionalObject obj;
	private String name;
	private int id;
	private EObjectType(TridimensionalObject obj, String name, int id){
		this.obj = obj;
		this.name = name;
		this.id = id;
	}
	
	public Model getModel() {
		return obj.create();
	}
	
	public int getId(){
		return id;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	public static EObjectType getById(int id){
		for (EObjectType object : EObjectType.values()){
			if (object.id == id)
				return object;
		}
		return null;
	}
	
}
