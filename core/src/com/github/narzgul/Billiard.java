package com.github.narzgul;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.ScreenUtils;

public class Billiard extends ApplicationAdapter {
	SpriteBatch batch;
	World world;
	Box2DDebugRenderer debugRenderer;
	OrthographicCamera camera;
	Body bottomWall, topWall, rightWall, leftWall;

	@Override
	public void create () {
		Box2D.init();
		batch = new SpriteBatch();
		world = new World(new Vector2(0, -10), true);
		debugRenderer = new Box2DDebugRenderer();
		camera = new OrthographicCamera();

		BodyDef bottomWallDef = new BodyDef();
		bottomWallDef.type = BodyDef.BodyType.StaticBody;
		bottomWallDef.position.set(new Vector2(camera.viewportHeight / 2, 20));
		bottomWall = world.createBody(bottomWallDef);
		PolygonShape bottomShape = new PolygonShape();
		bottomShape.setAsBox(camera.viewportHeight, 20);
		bottomWall.createFixture(bottomShape, 0.0f);

		BodyDef topWallDef = new BodyDef();
		topWallDef.type = BodyDef.BodyType.StaticBody;
		topWallDef.position.set(new Vector2(camera.viewportHeight / 2, 20));
		topWall = world.createBody(topWallDef);
		PolygonShape topShape = new PolygonShape();
		topShape.setAsBox(camera.viewportHeight, 20);
		topWall.createFixture(topShape, 0.0f);
		
		BodyDef rightWallDef = new BodyDef();
		rightWallDef.type = BodyDef.BodyType.StaticBody;
		rightWallDef.position.set(new Vector2(camera.viewportHeight / 2, 20));
		rightWall = world.createBody(rightWallDef);
		PolygonShape rightShape = new PolygonShape();
		rightShape.setAsBox(camera.viewportHeight, 20);
		rightWall.createFixture(rightShape, 0.0f);
		
		BodyDef leftWallDef = new BodyDef();
		leftWallDef.type = BodyDef.BodyType.StaticBody;
		leftWallDef.position.set(new Vector2(camera.viewportHeight / 2, 20));
		leftWall = world.createBody(leftWallDef);
		PolygonShape leftShape = new PolygonShape();
		leftShape.setAsBox(camera.viewportHeight, 20);
		leftWall.createFixture(leftShape, 0.0f);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 1, 0, 1);
		batch.begin();
		batch.end();

		debugRenderer.render(world, camera.combined);

		world.step(1/60f, 6, 2);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
