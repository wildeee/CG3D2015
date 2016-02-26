package br.com.wilde.cg;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

public class Projection implements ApplicationListener {
	public Environment lights;
	public PerspectiveCamera cam;
	public ModelBatch modelBatch;
	public Model model;
	public ModelInstance instance;

	@Override
	public void create() {
		
		lights = new Environment();
		lights.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
		lights.add(new DirectionalLight().set(Config.COR_LUZ, Config.DIRECAO_LUZ));

		modelBatch = new ModelBatch();

		PerspectiveCamera perspective = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); 
		cam = perspective;
		cam.position.set(Config.POSICAO_INICIAL_CAMERA);
		cam.lookAt(Config.FOCO_INICIAL_CAMERA);
		cam.near = Config.DISTANCIA_MINIMA_CAMERA;
		cam.far = Config.DISTANCIA_MAXIMA_CAMERA;
		cam.update();


		ModelBuilder modelBuilder = new ModelBuilder();
		model = modelBuilder.createBox(5f, 5f, 5f, new Material(ColorAttribute.createDiffuse(Color.RED)),
				Usage.Position | Usage.Normal);
		instance = new ModelInstance(model);
		
		Gdx.input.setInputProcessor(new InputListener(cam));
		Gdx.input.setCursorCatched(true);
		
	}

	@Override
	public void render() {
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
 
        modelBatch.begin(cam);
        modelBatch.render(instance, lights);
        modelBatch.end();
	}
	
	@Override
	public void dispose() {
		modelBatch.dispose();
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
