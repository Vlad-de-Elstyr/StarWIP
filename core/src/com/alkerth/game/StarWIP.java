package com.alkerth.game;

import com.alkerth.game.Background.BackgroundProvider;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;


public class StarWIP extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch;
	Texture img;
	OrthographicCamera camera;
	public static AssetProvider assetProvider;
	public static int width = 1000;
	public static int height = 800;
	private BackgroundProvider backgroundProvider;
	private CollisionList<Enemy> enemies;

	private Player player;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		loadAssets();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 480, 800);
		Gdx.input.setInputProcessor(this);
		player = new Player();
		this.setEnemies(new CollisionList<Enemy>());
		this.getEnemies().add(new Enemy(new Ship(assetProvider.getTexture("player")),200, 600, new Vector2(10, -50), 0.05f));
		this.setBackgroundProvider(new BackgroundProvider());
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		Gdx.app.debug("StarWIP", "at least im doing something" + this.player.getDestination().x);
	}

	@Override
	public void render () {





		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		for (Enemy e : getEnemies()) {
			e.update(batch);
		}

		this.getBackgroundProvider().update(batch);

		player.update(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		assetProvider.dispose();
	}

	private void loadAssets() {
		assetProvider = new AssetProvider();
		assetProvider.addTexture("player", new Texture(Gdx.files.internal("assets/player.png")));
		assetProvider.addTexture("laser", new Texture(Gdx.files.internal("assets/laser.png")));
		assetProvider.addTexture("star", new Texture(Gdx.files.internal("assets/star.png")));

	}

	private void disposeAssets() {

	}

	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
			case Input.Keys.RIGHT:
				player.getDestination().x += 1;
				break;
			case Input.Keys.LEFT:
				player.getDestination().x -= 1;
				break;
			case Input.Keys.UP:
				player.getDestination().y += 1;
				break;
			case Input.Keys.DOWN:
				player.getDestination().y -= 1;
				break;
			case Input.Keys.SPACE:
				player.fire();
				break;


		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch (keycode) {
			case Input.Keys.RIGHT:
				player.getDestination().x -= 1;
				break;
			case Input.Keys.LEFT:
				player.getDestination().x += 1;
				break;
			case Input.Keys.UP:
				player.getDestination().y -= 1;
				break;
			case Input.Keys.DOWN:
				player.getDestination().y += 1;
				break;


		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		/*Vector3 vec = new Vector3(screenX, screenY, 0);
		//vec = camera.unproject(vec);
		this.player.getDestination().x = vec.x;
		this.player.getDestination().y = vec.y;
		Gdx.app.debug("StarWIP", "at least im doing something" + this.player.getDestination().x);*/
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		/*Vector3 vec = new Vector3(screenX, screenY, 0);
		//vec = camera.unproject(vec);
		this.player.getDestination().x = -1;
		this.player.getDestination().y = -1;
		Gdx.app.debug("StarWIP", "at least im doing something" + this.player.getDestination().x);*/
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		/*Vector3 vec = new Vector3(screenX, screenY, 0);
		//vec = camera.unproject(vec);
		this.player.getDestination().x = vec.x;
		this.player.getDestination().y = vec.y;
		Gdx.app.debug("StarWIP", "at least im doing something" + this.player.getDestination().x);*/
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

	public CollisionList<Enemy> getEnemies() {
		return enemies;
	}

	public void setEnemies(CollisionList<Enemy> enemies) {
		this.enemies = enemies;
	}

	public BackgroundProvider getBackgroundProvider() {
		return backgroundProvider;
	}

	public void setBackgroundProvider(BackgroundProvider backgroundProvider) {
		this.backgroundProvider = backgroundProvider;
	}
}
