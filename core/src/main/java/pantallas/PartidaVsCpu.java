package pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import cartas.Carta;
import cartas.Cartas;
import cartas.Mazo;
import personaje.Personaje;
import utiles.Config;
import utiles.Imagen;
import utiles.Render;
import utiles.Utiles;
import utiles.Hud;

public class PartidaVsCpu implements Screen {
    private Imagen fondo;
    private SpriteBatch batch;
    private Hud hud;
    private Mazo mazo;
    private Personaje jugadorUno;
    private Personaje jugadorDos;

    @Override
    public void show() {
        fondo = new Imagen("fondos/QuieroRetruco.jpg");
		fondo.setSize(Config.ANCHO, Config.ALTO);
		batch = Render.batch; 
        
//        hud = new Hud("Jugador 1", "CPU");
        mazo = new Mazo();
        jugadorUno = new Personaje("Jugador");
        jugadorDos = new Personaje("CPU");

        ajustarImagen();
    }
    
    private void jugarRonda() {
    	int manosGanadasJugadorUno = 0, manosGanadasJugadorDos = 0, cantManosJugadas = 0;
    	boolean fin = false;
    	
    	do {
            repartirCartas();
            
            for(int i = 0; i < 3; i++) {
            	Gdx.app.log("PartidaVsCpu", (i+1) + ". Jugador 1 " + jugadorUno.getMano()[i].getNombre());
            	Gdx.app.log("PartidaVsCpu",(i+1) + ". Jugador 2 " + jugadorDos.getMano()[i].getNombre());
            }
    		
            
            Gdx.app.log("PartidaVsCpu","Ingrese el indice de la carta que se desea jugar para cada jugador");
            Carta cartaEnJuegoJugUno = jugadorUno.jugarCarta(jugadorUno.seleccionarCarta(Utiles.ingresarEntero(1, jugadorUno.getMano().length)));
    		Carta cartaEnJuegoJugDos = jugadorDos.jugarCarta(jugadorDos.seleccionarCarta(Utiles.ingresarEntero(1, jugadorDos.getMano().length)));
   		
    		int ganadorMano = jugarMano(cartaEnJuegoJugUno, cartaEnJuegoJugDos);
    		
    		if(ganadorMano == 1) {
    			manosGanadasJugadorUno++;
    		}else if(ganadorMano == 2) {
   			manosGanadasJugadorDos++;
    		}		
    		
    		Gdx.app.log("PartidaVsCpu","El jugador 1 gano " + manosGanadasJugadorUno + " manos");
    		Gdx.app.log("PartidaVsCpu","El jugador 2 gano " + manosGanadasJugadorDos + " manos");
    		
    	    if (manosGanadasJugadorUno >= 2 || manosGanadasJugadorDos >= 2) {
    	        fin = true;
    	    }
    		
    	}while(!fin);
    }
    
    private int jugarMano(Carta cartaJugadorUno, Carta cartaJugadorDos) {
    	
        if (cartaJugadorUno.getJerarquia() < cartaJugadorDos.getJerarquia()) {
        	Gdx.app.log("PartidaVsCpu",cartaJugadorUno.getNombre() + " le gano a " + cartaJugadorDos.getNombre());
            return 1;
        } else if (cartaJugadorUno.getJerarquia() > cartaJugadorDos.getJerarquia()) {
        	Gdx.app.log("PartidaVsCpu",cartaJugadorDos.getNombre() + " le gano a " + cartaJugadorUno.getNombre());
            return 2;
        } else {
        	Gdx.app.log("PartidaVsCpu",cartaJugadorUno.getNombre() + " empato con " + cartaJugadorDos.getNombre());
            return -1;
        }
    	
    }
    
   

    private void repartirCartas() {
        Gdx.app.log("PartidaVsCpu", "Repartiendo cartas...");
        mazo.repartir();
        int[] indicesCartas = mazo.getIndicesCartasJuego();

        for (int i = 0; i < 3; i++) {
            jugadorUno.recibirCarta(Cartas.values()[indicesCartas[i]].getCarta(), i); 
            jugadorDos.recibirCarta(Cartas.values()[indicesCartas[i + 3]].getCarta(), i); 
            Gdx.app.log("PartidaVsCpu", "Carta repartida: Jugador 1 - " + Cartas.values()[indicesCartas[i]].getCarta().getNombre());
            Gdx.app.log("PartidaVsCpu", "Carta repartida: Jugador 2 - " + Cartas.values()[indicesCartas[i + 3]].getCarta().getNombre());
        }
    }

    private void ajustarImagen() {
        if (fondo != null) {
            fondo.setSize(Config.ANCHO, Config.ALTO);
        }
    }

    @Override
    public void render(float delta) {
        if (batch == null) {
            Gdx.app.error("PartidaVsCpu", "SpriteBatch está null durante el renderizado");
            return;
        }

        Render.limpiarPantalla(0, 0, 0, 1); 
        batch.begin();

        fondo.dibujar(); 
        
        jugarRonda();
        
        batch.end();
    }

    
    @Override
    public void resize(int width, int height) {
        ajustarImagen();
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        if (fondo != null) {
            fondo.dispose();
        }
        if (batch != null) {
            batch.dispose();
        }
        if (hud != null) {
            hud.dispose();
        }
    }

}
