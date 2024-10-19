package personaje;

import com.badlogic.gdx.Gdx;

import cartas.Carta;
import utiles.Utiles;

public class Personaje {
	private String nombre;
    private Carta[] mano;
    private int puntaje;
	
	public Personaje(String nombre) {
        this.nombre = nombre;
        this.mano = new Carta[3];
        this.puntaje = 0;
	}
	
    public void recibirCarta(Carta cartas[]) {
    	this.mano = cartas;
    }
    
    public void recibirCarta(Carta carta, int posicion) {
    	this.mano[posicion] = carta;
    }
	
    public Carta[] getMano() {
        return mano;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void sumarPuntos(int puntos) {
        this.puntaje += puntos;
    }
    
    public Carta jugarCarta(int indice) {    	
    	System.out.println("Se ha jugado la carta " + mano[indice].getNombre());
    	
    	return mano[indice];
    }
    
    public int seleccionarCarta(int indice) {
    	boolean cartaSeleccionada = false;
    	    	
    	do {
        	if(mano[indice] == null) {
        		Gdx.app.log("Personaje","La carta seleccionada no esta disponible");
        		Gdx.app.log("Personaje","Vuelva a ingresar el indice de la carta");
        		indice = (Utiles.ingresarEntero(1, mano.length)) - 1;
        		cartaSeleccionada = false;
        	}else {
        		cartaSeleccionada = true;
        	}
    	}while(!cartaSeleccionada);
    	
    	
    	Gdx.app.log("Personaje","Se ha seleccionado la carta " + indice);

    	return indice-1;
    }
	
}
