package utiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Imagen {

    private Texture t;
    private Sprite s;
    
    public Imagen(String ruta) {
        try {
            t = new Texture(Gdx.files.internal(ruta));
            s = new Sprite(t);
        } catch (Exception e) {
            Gdx.app.error("Imagen", "Error cargando la imagen: " + ruta, e);
        }
    }
    
    public Imagen(String ruta, float x, float y) {
        this(ruta);
        setXY(x, y);
    }
    
    public void dibujar() {
        if (Render.batch != null) {
            s.draw(Render.batch);
        } else {
            Gdx.app.error("Imagen", "SpriteBatch está null durante el dibujo");
        }
    }
    
    public void dibujar(float x, float y) {
        if (Render.batch != null) {
            s.setX(x);
            s.setY(y);
            s.draw(Render.batch);
        } else {
            Gdx.app.error("Imagen", "SpriteBatch está null durante el dibujo");
        }
    }
    
    public void dispose() {
        if (t != null) {
            t.dispose();
        }
    }
    
    public Texture getTexture() {
        return t;
    }
    
    public void setTransparencia(float a) {
        if (s != null) {
            s.setAlpha(a);
        }
    }

    public void setXY(float x, float y) {
        if (s != null) {
            s.setPosition(x, y);
        }
    }
    
    public void setSize(float ANCHO, float ALTO) {
        if (s != null) {
            s.setSize(ANCHO, ALTO);
        }
    }

    public float getWidth() {
        return s != null ? s.getWidth() : 0;
    }

    public float getHeight() {
        return s != null ? s.getHeight() : 0;
    }
    
    public float getX() {
        return s != null ? s.getX() : 0;
    }
    
    public float getY() {
        return s != null ? s.getY() : 0;
    }
    
}
