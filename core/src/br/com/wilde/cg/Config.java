package br.com.wilde.cg;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;

public class Config {

	public static Vector3 DIRECAO_LUZ = new Vector3(-1f, -0.8f, -0.2f);
	public static Color COR_LUZ = new Color(0.8f, 0.8f, 0.8f, 1f);

	public static Vector3 POSICAO_INICIAL_CAMERA = new Vector3(10f, 10f, 10f);
	public static float ANGULO_DE_ABERTURA_CAMERA = 67f;
	public static Vector3 FOCO_INICIAL_CAMERA = new Vector3(0f, 0f, 0f);
	public static float DISTANCIA_MINIMA_CAMERA = 1f;
	public static float DISTANCIA_MAXIMA_CAMERA = 300f;

}
