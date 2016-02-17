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
	public PerspectiveCamera camera;
	public ModelBatch modelBatch;
	public Model model;
	public ModelInstance instance;

	@Override
	public void create() {
		
		lights = new Environment();
		lights.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));		
		lights.add(new DirectionalLight().set(Config.COR_LUZ , Config.DIRECAO_LUZ));

		modelBatch = new ModelBatch();

		camera = new PerspectiveCamera(Config.ANGULO_DE_ABERTURA_CAMERA, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.set(Config.POSICAO_INICIAL_CAMERA);
		camera.lookAt(Config.FOCO_INICIAL_CAMERA);
		camera.near = Config.DISTANCIA_MAXIMA_CAMERA;
		camera.far = Config.DISTANCIA_MAXIMA_CAMERA;
		camera.update();

		ModelBuilder modelBuilder = new ModelBuilder();
		model = modelBuilder.createBox(5f, 5f, 5f, new Material(ColorAttribute.createDiffuse(Color.RED)),
				Usage.Position | Usage.Normal);
		instance = new ModelInstance(model);
	}

	@Override
	public void render() {
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
 
        modelBatch.begin(camera);
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
