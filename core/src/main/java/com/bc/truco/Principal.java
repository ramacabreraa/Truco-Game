package com.bc.truco;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import pantallas.PantallaInicial;
import utiles.Render;

public class Principal extends Game {

	@Override
	public void create() {
	    Gdx.app.log("Principal", "Inicializando Render.app y Render.batch");
	    Render.app = this;
	    Render.batch = new SpriteBatch();
	    Gdx.app.log("Principal", "Render.batch inicializado: " + (Render.batch != null));
	    this.setScreen(new PantallaInicial());
	}

    @Override 
    public void render() {
        super.render();
        if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    @Override
    public void dispose() {
        Gdx.app.log("Principal", "Dispose llamado");
        if (Render.batch != null) {
            Render.batch.dispose();
        }
    }
}
