package pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import utiles.Imagen;
import utiles.Render;

public class PantallaInicial implements Screen {
	private Imagen fondo;
	private SpriteBatch batch;
	private float transparencia = 0.00001f;
	private boolean terminado = false, completo = false;
	private int contEspera = 0;
	
	@Override
	public void show() {
		fondo = new Imagen("fondos/PantallaInicial.png");
		batch = Render.batch;
		fondo.setTransparencia(transparencia);
	}

	@Override
	public void render(float delta) {
		if(Gdx.input.isKeyPressed(Keys.SPACE)) {
			Render.app.setScreen(new MenuPrincipal());
		}
		Render.limpiarPantalla(0, 0, 0, 1);
		
		batch.begin();
		fondo.dibujar();
		batch.end();

		degradado();

	}

	private void degradado() {
		if(!terminado) {
			transparencia += 0.01f;
			if(transparencia > 1) {
				transparencia = 1;
				terminado = true;
			}
			
		} else {
			contEspera++;
			if (contEspera >= 100) {
				contEspera = 100;
				transparencia-=0.01f;
				if(transparencia < 0) {
					transparencia = 0;
					completo = true;
				}
			}
		}
		fondo.setTransparencia(transparencia);
		if(completo) {
			Render.app.setScreen(new MenuPrincipal());
		}		
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

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		fondo.dispose();	
		batch.dispose();
	}
	
}
