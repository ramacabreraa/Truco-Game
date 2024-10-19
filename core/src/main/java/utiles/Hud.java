package utiles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;

public class Hud {

    private BitmapFont font;
    private int tiempoInicio;
    private String nombreJugadorUno;
    private String nombreJugadorDos;
    private int puntajeJugadorUno;
    private int puntajeJugadorDos;

    public Hud(String nombreJugadorUno, String nombreJugadorDos) {
        this.font = new BitmapFont();  
        this.font.setColor(Color.WHITE);
        this.tiempoInicio = (int) TimeUtils.millis();
        this.nombreJugadorUno = nombreJugadorUno;
        this.nombreJugadorDos = nombreJugadorDos;
        this.puntajeJugadorUno = 0;
        this.puntajeJugadorDos = 0;
    }

    public void render(SpriteBatch batch) {
        int tiempoTranscurrido = (int) ((TimeUtils.millis() - tiempoInicio) / 1000);
        font.draw(batch, "Tiempo: " + tiempoTranscurrido + "s", 10, 460);
        font.draw(batch, nombreJugadorUno + ": " + puntajeJugadorUno, 10, 440);
        font.draw(batch, nombreJugadorDos + ": " + puntajeJugadorDos, 10, 420);
    }

    public void actualizarPuntaje(int puntajeJugadorUno, int puntajeJugadorDos) {
        this.puntajeJugadorUno = puntajeJugadorUno;
        this.puntajeJugadorDos = puntajeJugadorDos;
    }
    
    public void actualizarPuntajeJugadorUno(int puntajeJugadorUno) {
        this.puntajeJugadorUno = puntajeJugadorUno;
    }
    
    public void actualizarPuntajeJugadorDos(int puntajeJugadorDos) {
        this.puntajeJugadorDos = puntajeJugadorDos;
    }

    public void dispose() {
        font.dispose();
    }
}
