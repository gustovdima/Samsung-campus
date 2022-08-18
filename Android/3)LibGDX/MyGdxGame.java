package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter; import com.badlogic.gdx.Gdx; import com.badlogic.gdx.audio.Music; import com.badlogic.gdx.audio.Sound; import com.badlogic.gdx.graphics.Texture; import com.badlogic.gdx.graphics.g2d.SpriteBatch; import com.badlogic.gdx.math.Rectangle; import com.badlogic.gdx.utils.Array; import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

public class MyGdxGame extends ApplicationAdapter { SpriteBatch batch; Texture dinoImg; Texture cactusImg;

int screenWidth, screenHeight;
int dinoWidth = 100, dinoHeight = 100;
int cactusWidth = 50, cactusHeight = 60;

Rectangle dino;
Array<Rectangle> cactuss;

long lastDropTime;

Music musicBackground;
Sound miniSound;

@Override
public void create() {
	batch = new SpriteBatch();
	dinoImg = new Texture("Dino.png");
	cactusImg = new Texture("cactus.png");

	screenWidth = Gdx.graphics.getWidth();
	screenHeight = Gdx.graphics.getHeight();

	dino = new Rectangle(screenWidth / 2 - dinoWidth / 2, 0,
			dinoWidth, dinoHeight);

	cactuss = new Array<>();
	createNewCactus();

	musicBackground = Gdx.audio.newMusic(Gdx.files.internal("MusicGame.mp3"));
	musicBackground.setLooping(true);
	musicBackground.play();

	miniSound = Gdx.audio.newSound(Gdx.files.internal("sound.mp3"));
}

private void createNewCactus() {
	Random rand = new Random();
	int cactusX = rand.nextInt(screenWidth - cactusWidth);
	Rectangle CC = new Rectangle(cactusX, screenHeight,
			cactusWidth, cactusHeight);
	cactuss.add(CC);
	lastDropTime = System.currentTimeMillis();
}

@Override
public void render() {
	ScreenUtils.clear(0, 0, 0f, 0);

	if (System.currentTimeMillis() - lastDropTime > 1500) {
		createNewCactus();
	}

	if (Gdx.input.isTouched()) {
		int touchX = Gdx.input.getX();
		dino.setX(touchX - dino.getWidth() / 2);
	}
	if (dino.getX() < 0) {
		dino.setX(0);
	}
	if (dino.getX() > screenWidth - dino.getWidth()) {
		dino.setX(screenWidth - dino.getWidth());
	}

	for (Rectangle cactus : cactuss) {
		cactus.y -= 300 * Gdx.graphics.getDeltaTime();
		if (cactus.getY() < -cactus.getHeight()) {
			cactuss.removeValue(cactus, true);
		}

		if (dino.overlaps(cactus)) {
			cactuss.removeValue(dino, true);
		}
	}

	batch.begin();	
	batch.draw(dinoImg, dino.getX(), dino.getY(),
			dino.getWidth(), dino.getHeight());
	for (Rectangle egg : cactuss) {
		batch.draw(cactusImg, egg.getX(), egg.getY(),
				egg.getWidth(), egg.getHeight());
	}
	batch.end();
}

@Override
public void dispose() {
	batch.dispose();
	dinoImg.dispose();
	cactusImg.dispose();
}
}
