package cartas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import utiles.Render;
public class Carta {
    protected String nombre;
    protected int valor, jerarquia;
    protected TiposCarta tipo;
    protected Sprite sprite;
    protected Texture textura;

    public Carta(String nombre, int valor, int jerarquia, TiposCarta tipo, String rutaImagen) {
        this.nombre = nombre;
        this.valor = valor;
        this.jerarquia = jerarquia;
        this.tipo = tipo;
        try {
            this.textura = new Texture(Gdx.files.internal(rutaImagen));
            this.sprite = new Sprite(textura);
        } catch (Exception e) {
            Gdx.app.error("Carta", "Error cargando la imagen: " + rutaImagen, e);
        }
    }

    public void dibujar() {
        if (sprite != null && Render.batch != null) {
            sprite.draw(Render.batch);
        } else {
            Gdx.app.error("Carta", "Sprite o SpriteBatch está null durante el dibujo");
        }
    }

    public void setXY(float x, float y) {
        if (sprite != null) {
            Gdx.app.log("Carta", "Posicionando carta en: (" + x + ", " + y + ")");
            sprite.setPosition(x, y); 
        } else {
            Gdx.app.error("Carta", "El sprite es null, no se puede posicionar");
        }
    }

    public float getX() {
        return sprite != null ? sprite.getX() : 0;
    }

    public float getY() {
        return sprite != null ? sprite.getY() : 0;
    }

    public void dispose() {
        if (sprite != null) {
            sprite.getTexture().dispose();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getValor() {
        return valor;
    }
    
    public void setSize(float ancho, float alto) {
        if (sprite != null) {
            sprite.setSize(ancho, alto); 
        } else {
            Gdx.app.error("Carta", "Sprite está null al intentar ajustar el tamaño");
        }
    }
    
    public int getJerarquia() {
		return jerarquia;
	}

}
