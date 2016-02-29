package br.com.wilde.cg;

import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.math.Vector3;

public class CameraMovement implements Runnable {

	private final PerspectiveCamera cam;
	
	private Boolean moveForward;
	private Boolean moveLeft;
	private Boolean moveRight;
	private Boolean moveBackward;
	private InfoOutput logger;

	public CameraMovement(PerspectiveCamera cam){
		this.cam = cam;
		logger = new InfoOutput(cam);
		
		moveForward  = false;
		moveLeft     = false;
		moveRight    = false;
		moveBackward = false;
	}

	@Override
	public void run() {
		final float speed = 0.1f;
		Vector3 direction;
		
		while(true){
			direction = cam.direction.cpy();
			if (moveForward){
				direction.x *= speed;
				direction.y *= speed;
	            direction.z *= speed;
	            cam.translate(direction);
		        cam.update();
		        if (!InfoOutput.isInputing)
		        	logger.outputInformation();
			}
			
			if (moveLeft){
				direction.y = 0f;
	            direction.rotate(Vector3.Y, 90);
	            direction.x *= speed * 2;
	            direction.z *= speed * 2;
	            cam.translate(direction);
		        cam.update();
	        	if (!InfoOutput.isInputing)
	        		logger.outputInformation();
			}
				
			if (moveRight){
				direction.y = 0f;
	            direction.rotate(Vector3.Y, -90);
	            direction.x *= speed * 2;
	            direction.z *= speed * 2;
	            cam.translate(direction);
		        cam.update();
		        if (!InfoOutput.isInputing)
		        	logger.outputInformation();
			}
			
			if (moveBackward){
				direction.x = -direction.x;
				direction.y = -direction.y;
	            direction.z = -direction.z;
	            direction.x *= speed;
	            direction.y *= speed;
	            direction.z *= speed;
	            cam.translate(direction);
		        cam.update();
		        if (!InfoOutput.isInputing)
		        	logger.outputInformation();
			}
			try {
				Thread.sleep(10);
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
