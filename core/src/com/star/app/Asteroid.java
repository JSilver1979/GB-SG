package com.star.app;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {
    private Texture texture;
    private Vector2 position;
    private Vector2 velocity;
    private StarGame starGame;

    public Asteroid(StarGame starGame) {
        this.texture = new Texture("asteroid.png");
        this.position =new Vector2(0,MathUtils.random(0, ScreenManager.SCREEN_HEIGHT));
        this.velocity = new Vector2(MathUtils.random(-500,500), MathUtils.random(-500, 500));
        this.starGame = starGame;

    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x - 128, position.y - 128, 128, 128,
                64, 64, 1, 1, 0, 0, 0, 256, 256,
                false, false);
    }

    public void update(float dt) {
        position.x += velocity.x * dt;
        position.y += velocity.y * dt;

        checkBorders();
    }

    public void checkBorders() {
        if (position.x < 0.0f) {
            position.x = ScreenManager.SCREEN_WIDTH + 128f;
        }
        if (position.x > ScreenManager.SCREEN_WIDTH +128f) {
            position.x = 0.0f;
        }
        if (position.y < 0.0f) {
            position.y = ScreenManager.SCREEN_HEIGHT + 128f;
        }
        if (position.y > ScreenManager.SCREEN_HEIGHT +128f) {
            position.y = 0.0f;
        }
    }
}
