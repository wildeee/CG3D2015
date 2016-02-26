package br.com.wilde.cg;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.math.Vector3;

public class InputListener implements InputProcessor {
	
	private final Vector3 posicaoCamera;
	private final Vector3 focoCamera;
	private final PerspectiveCamera cam;
	private int dragX, dragY;
	private final float rotateSpeed = 0.2f;
	
	public InputListener(PerspectiveCamera cam) {
		posicaoCamera = Config.POSICAO_INICIAL_CAMERA;
		focoCamera = Config.POSICAO_INICIAL_CAMERA;
		this.cam = cam;
	}

	@Override
	public boolean keyDown(int keycode) {
		float speed = 0.5f;
		Vector3 v = cam.direction.cpy();
        
		switch(keycode){
			case Keys.W:
	            v.y = 0f;
	            v.x *= speed;
	            v.z *= speed;
				break;
				
			case Keys.A:
	            v.y = 0f;
	            v.rotate(Vector3.Y, 90);
	            v.x *= speed;
	            v.z *= speed;
				break;
				
			case Keys.D:
	            v.y = 0f;
	            v.rotate(Vector3.Y, -90);
	            v.x *= speed;
	            v.z *= speed;
				break;
				
			case Keys.S:
	            v.y = 0f;
	            v.x = -v.x;
	            v.z = -v.z;
	            v.x *= speed;
	            v.z *= speed;
				break;
				
			case Keys.CONTROL_LEFT:
				break;
				
			case Keys.SPACE:
				break;
		}
		
		cam.translate(v);
        cam.update();
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		Vector3 direction = cam.direction.cpy();

        float x = dragX - screenX;
        cam.rotate(Vector3.Y,x * rotateSpeed);

        float y = (float) Math.sin( (double)(dragY - screenY) / 180f);
        if (Math.abs(cam.direction.y + y * (rotateSpeed*5.0f)) < 0.9) {
            cam.direction.y +=  y * (rotateSpeed*5.0f) ;
        }

        cam.update();
        dragX = screenX;
        dragY = screenY;
        return true;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
