package br.com.wilde.cg;

public class SphereConfig {

	public final float width;
	public final float height;
	public final float depth;
	public final int divisionsU;
	public final int divisionsV;
	
	public SphereConfig(float width, float height, float depth, int divisionsU, int divisionsV) {
		this.width = width;
		this.height = height;
		this.depth = depth;
		this.divisionsU = divisionsU;
		this.divisionsV = divisionsV;
	}
}
