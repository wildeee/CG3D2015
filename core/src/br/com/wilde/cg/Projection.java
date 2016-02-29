package br.com.wilde.cg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;

public class Projection implements ApplicationListener {
	public Environment lights;
	public PerspectiveCamera cam;
	public ModelBatch batch;
	public Model model;
	public ModelInstance instance;
	private EObjectType type;
	
	public TridimensionalObject tridimensionalObject;

	@Override
	public void create() {
		
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Selecione um tipo de objeto: ");
			for (EObjectType obj : EObjectType.values()){
				System.out.println(obj.getId() + " - " + obj.toString());
			}
			System.out.print("Selecione: ");
			String line = buffer.readLine();
			
			Integer selection = Integer.parseInt(line);
			type = EObjectType.getById(selection);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		lights = new Environment();
		lights.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
		lights.add(new DirectionalLight().set(Config.COR_LUZ, Config.DIRECAO_LUZ));

		batch = new ModelBatch();

		PerspectiveCamera perspective = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); 
		cam = perspective;
		cam.position.set(Config.POSICAO_INICIAL_CAMERA);
		cam.lookAt(Config.FOCO_INICIAL_CAMERA);
		cam.near = Config.DISTANCIA_MINIMA_CAMERA;
		cam.far = Config.DISTANCIA_MAXIMA_CAMERA;
		cam.update();

		model = type.getModel();
				
		instance = new ModelInstance(model);
		
		Gdx.input.setInputProcessor(new InputListener(cam));
		Gdx.input.setCursorCatched(true);
		
	}

	@Override
	public void render() {
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
 
        batch.begin(cam);
        batch.render(instance, lights);
        batch.end();

	}
	
	@Override
	public void dispose() {
		batch.dispose();
		model.dispose();
	}
	
	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
