package br.com.wilde.cg;

import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.math.Vector3;

public class CameraMovement implements Runnable {

	private final PerspectiveCamera cam;
	
	private Boolean moveForward;
	private Boolean moveLeft;
	private Boolean moveRight;
	private Boolean moveBackward;

	public CameraMovement(PerspectiveCamera cam){
		this.cam = cam;
		moveForward  = false;
		moveLeft     = false;
		moveRight    = false;
		moveBackward = false;
	}

	@Override
	public void run() {
		final float speed = 0.3f;
		Vector3 v;
		while(true){
			v = cam.direction.cpy();
			if (moveForward){
				v.x *= speed;
	            v.z *= speed;
	            cam.translate(v);
		        cam.update();
			}
			
			if (moveLeft){
				v.y = 0f;
	            v.rotate(Vector3.Y, 90);
	            v.x *= speed * 2;
	            v.z *= speed * 2;
	            cam.translate(v);
		        cam.update();
			}
			
			if (moveRight){
				v.y = 0f;
	            v.rotate(Vector3.Y, -90);
	            v.x *= speed * 2;
	            v.z *= speed * 2;
	            cam.translate(v);
		        cam.update();
			}
			
			if (moveBackward){
				v.x = -v.x;
				v.y = -v.y;
	            v.z = -v.z;
	            v.x *= speed;
	            v.y *= speed;
	            v.z *= speed;
	            cam.translate(v);
		        cam.update();
			}		
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void setMoveForward(Boolean moveForward) {
		this.moveForward = moveForward;
	}

	public void setMoveLeft(Boolean moveLeft) {
		this.moveLeft = moveLeft;
	}

	public void setMoveRight(Boolean moveRight) {
		this.moveRight = moveRight;
	}

	public void setMoveBackward(Boolean moveBackward) {
		this.moveBackward = moveBackward;
	}
	
	
	
	
	
}
