package br.com.wilde.cg;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;

public class Config {

	public static final Vector3 DIRECAO_LUZ = new Vector3(-1f, -0.8f, -0.2f);
	public static final Color   COR_LUZ     = new Color(0.8f, 0.8f, 0.8f, 1f);

	public static final Vector3 POSICAO_INICIAL_CAMERA    = new Vector3(10f, 10f, 10f);
	public static final float   ANGULO_DE_ABERTURA_CAMERA = 67f;
	public static final Vector3 FOCO_INICIAL_CAMERA       = new Vector3(0f, 0f, 0f);
	public static final float   DISTANCIA_MINIMA_CAMERA   = 1f;
	public static final float   DISTANCIA_MAXIMA_CAMERA   = 300f;
	public static final Color   COR_DO_OBJETO             = Color.GREEN;
	
	// Largura, Altura, Profundidade
	public static final RectangleConfig CUBE = new RectangleConfig(2f, 4f, 6f);
	
	// Largura, Altura, Profundidade, Número de divisões
	public static final PolygonConfig CONE = new PolygonConfig(10f, 10f, 10f, 50);
	
	// Largura, Altura, Profundidade, Número de divisões
	public static final PolygonConfig CYLINDER = new PolygonConfig(10f, 10f, 10f, 50);
	
	// Raio das extremidades da cápsula, Altura, Número de divisões
	public static final CapsuleConfig CAPSULE = new CapsuleConfig(5f, 20f, 100);
	
	// Largura, Altura, Profundidade, Número de divisões na horizontal, Número de divisões na vertical (cima e baixo)
	public static final SphereConfig SPHERE = new SphereConfig(10f, 10f, 10f, 50, 50);
	
	// Tipo do objeto a ser projetado!
	public static final EObjectType OBJECT_TYPE = EObjectType.RETANGULO;
}
