package pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import entradasalida.Entradas;
import utiles.Config;
import utiles.Imagen;
import utiles.Recursos;
import utiles.Render;
import utiles.Texto;

public class MenuPrincipal implements Screen{
	
	Imagen fondo;
	SpriteBatch b;
	

	Texto opciones[] = new Texto[4];
	String textos[] = {"Nueva Partida", "Configuracion", "Ayuda", "Salir"};
	int opc=1;
	
	public float tiempo = 0;
	
	Entradas entradas = new Entradas(this);

	@Override
	public void show() {
		
		fondo = new Imagen(Recursos.FONDOMENU);
		fondo.setSize(Config.ANCHO, Config.ALTO);
		b = Render.batch; 
		
		Gdx.input.setInputProcessor(entradas);
		
		int avance = 40;
		
		for (int i = 0; i < opciones.length; i++) {
			opciones[i] = new Texto(Recursos.FUENTEMENU, 65, Color.GRAY, true);
			opciones[i].setTexto(textos[i]);
			opciones[i].setPositions((Config.ANCHO/2) - (opciones[i].getAncho()/2), ((Config.ALTO/2) + (opciones[i].getAlto()/2)) -((opciones[i].getAlto()*i)+(avance*i)));
			
		}
		
	}

	@Override
	public void render(float delta) {
	
		b.begin();
			fondo.dibujar();
			for (int i = 0; i < opciones.length; i++) {
				opciones[i].dibujar();
			}

		b.end();
		
		tiempo+=delta;
		
		if(entradas.isAbajo()) {
			
			if(tiempo > 0.14f) {
			tiempo = 0;
			opc++;
			if(opc>4) {
				opc=1;
				}
			}
		}
			if(entradas.isArriba()) {
				
				if(tiempo > 0.14f) {
				tiempo = 0;
				opc--;
				if(opc<1) {
					opc=4;
					}
				}
			}
			
			for (int i = 0; i < opciones.length; i++) {
				if(i==(opc-1)) {
					opciones[i].setColor(Color.ROYAL);
				}else {
					opciones[i].setColor(Color.GRAY);
				}
			}
			
			if(entradas.isEnter()) {
				
				if(opc==1) {
					
					Render.app.setScreen(new PartidaVsCpu());
					
				}
				
				
			}
			
			
			
			
	}
		
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
