package br.com.wilde.cg;

import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.math.Plane;
import com.badlogic.gdx.math.Vector3;

public class InfoOutput {

	private final PerspectiveCamera cam;
	public static Boolean isInputing = Boolean.FALSE;

	public InfoOutput(PerspectiveCamera cam) {
		this.cam = cam;
	}

	public void outputInformation() {
		isInputing = Boolean.TRUE;
		Vector3 position = cam.position;
		System.out.printf("\nPonto de vista:\nP: (%2.2f %2.2f %2.2f)", position.x, position.y, position.z);
		Vector3[] frustrumPoints = cam.frustum.planePoints;
		System.out.printf("\nPlano de projeção:\nP1: (%4.2f %4.2f %4.2f)\nP2: (%4.2f %4.2f %4.2f)\nP3: (%4.2f %4.2f %4.2f)\n"
				,frustrumPoints[7].x
				,frustrumPoints[7].y
				,frustrumPoints[7].z
				,frustrumPoints[6].x
				,frustrumPoints[6].y
				,frustrumPoints[6].z
				,frustrumPoints[5].x
				,frustrumPoints[5].y
				,frustrumPoints[5].z
		);
		Vector3 normal = new Plane(frustrumPoints[5], frustrumPoints[6], frustrumPoints[7]).getNormal(); 
		System.out.printf("Vetor normal ao plano:\n(%2.2f %2.2f %2.2f)\n", normal.x, normal.y, normal.z);
		isInputing = Boolean.FALSE;
	}
	
	
}
