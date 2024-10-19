package cartas;

import utiles.Utiles;

public class Mazo {
	private int indicesCartasJuego[] = new int [6];
	
	public Mazo() {
		irMazo();
		repartir();
	}
	
	public void irMazo() {
		for(int i = 0; i < indicesCartasJuego.length; i++) {
			indicesCartasJuego[i] = -1;
		}
	}
	
	public void repartir() {
	    for (int i = 0; i < this.indicesCartasJuego.length; i++) {
	        int indiceCartaRepartida, j = 0;
	        boolean repartida;
	         
	        do {	        
		        repartida = false;	
		        indiceCartaRepartida = Utiles.r.nextInt(40);
		        
		        j = 0;
	            while (j < i) {
	                if (this.indicesCartasJuego[j] == indiceCartaRepartida) {
	                    repartida = true;
	                }
	                j++;
	            }
		    }while(repartida);
	        this.indicesCartasJuego[i] = indiceCartaRepartida;
	    }
	}
	
	public int[] getIndicesCartasJuego() {
		return indicesCartasJuego;
	}
	
}
