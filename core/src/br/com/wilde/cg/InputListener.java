package br.com.wilde.cg;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.math.Vector3;

public class InputListener implements InputProcessor {
	
	private final PerspectiveCamera cam;
	private int dragX;
	private int dragY;
	private final float rotateSpeed = 0.2f;
	private final CameraMovement mover;
	private InfoOutput logger;
	
	public InputListener(PerspectiveCamera cam) {
		logger = new InfoOutput(cam);
		this.cam = cam;
		dragX = dragY = 0;
		this.mover = new CameraMovement(cam);
		Thread t = new Thread(mover);
		t.start();
	}

	@Override
	public boolean keyDown(int keycode) {
		switch(keycode){
			case Keys.W:
	            mover.setMoveForward(Boolean.TRUE);
				break;
				
			case Keys.A:
	            mover.setMoveLeft(Boolean.TRUE);
				break;
				
			case Keys.D:
	            mover.setMoveRight(Boolean.TRUE);;
				break;
				
			case Keys.S:
	            mover.setMoveBackward(Boolean.TRUE);
				break;
				
			case Keys.CONTROL_LEFT:
				break;
				
			case Keys.SPACE:
				break;
			default:
				return false;
		}
		
		
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch(keycode){
		case Keys.W:
            mover.setMoveForward(Boolean.FALSE);
			break;
			
		case Keys.A:
            mover.setMoveLeft(Boolean.FALSE);
			break;
			
		case Keys.D:
            mover.setMoveRight(Boolean.FALSE);
			break;
			
		case Keys.S:
            mover.setMoveBackward(Boolean.FALSE);
			break;
			
		case Keys.CONTROL_LEFT:
			break;
			
		case Keys.SPACE:
			break;
		default:
			return false;
		}
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
        float x = dragX - screenX;
        cam.rotate(Vector3.Y,x * rotateSpeed);

        float y = (float) Math.sin( (double)(dragY - screenY) / 180f);
        if (Math.abs(cam.direction.y + y * (rotateSpeed*5.0f)) < 0.9) {
            cam.direction.y +=  y * (rotateSpeed*5.0f) ;
        }

        cam.update();
        dragX = screenX;
        dragY = screenY;
        if (!InfoOutput.isInputing){
        	logger.outputInformation();
        }
        return true;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
