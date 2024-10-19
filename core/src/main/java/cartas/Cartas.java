package cartas;

public enum Cartas implements Repartible{
	
	UNO_DE_BASTO("Uno de Bastos", 1, 2, TiposCarta.BASTO, "cartas/UnoDeBasto.png"),
	UNO_DE_COPA("Uno de Copas", 1, 7, TiposCarta.COPA, "cartas/UnoDeCopa.png"),
	UNO_DE_ORO("Uno de Oro", 1, 7, TiposCarta.ORO, "cartas/UnoDeOro.png"),
	UNO_DE_ESPADA("Uno de Espadas", 1, 1, TiposCarta.ESPADA, "cartas/UnoDeEspada.png"),
	
	DOS_DE_BASTO("Dos de Bastos", 2, 6, TiposCarta.BASTO, "cartas/DosDeBasto.png"),
	DOS_DE_COPA("Dos de Copas", 2, 6, TiposCarta.COPA, "cartas/DosDeCopa.png"),
	DOS_DE_ORO("Dos de Oro", 2, 6, TiposCarta.ORO, "cartas/DosDeOro.png"),
	DOS_DE_ESPADA("Dos de Espadas", 2, 6, TiposCarta.ESPADA, "cartas/DosDeEspada.png"),
	
	TRES_DE_BASTO("Tres de Bastos", 3, 5, TiposCarta.BASTO, "cartas/TresDeBasto.png"),
	TRES_DE_COPA("Tres de Copas", 3, 5, TiposCarta.COPA, "cartas/TresDeCopa.png"),
	TRES_DE_ORO("Tres de Oros", 3, 5, TiposCarta.ORO, "cartas/TresDeOro.png"),
	TRES_DE_ESPADA("Tres de Espadas", 3, 5, TiposCarta.ESPADA, "cartas/TresDeEspada.png"),

	CUATRO_DE_BASTO("Cuatro de Bastos", 4, 14, TiposCarta.BASTO, "cartas/CuatroDeBasto.png"),
	CUATRO_DE_COPA("Cuatro de Copa", 4, 14, TiposCarta.COPA, "cartas/CuatroDeCopa.png"),
	CUATRO_DE_ORO("Cuatro de Oros", 4, 14, TiposCarta.ORO, "cartas/CuatroDeOro.png"),
	CUATRO_DE_ESPADA("Cuatro de Espadas", 4, 14, TiposCarta.ESPADA, "cartas/CuatroDeEspada.png"),
	
	CINCO_DE_BASTO("Cinco de Bastos", 5, 13, TiposCarta.BASTO, "cartas/CincoDeBasto.png"),
	CINCO_DE_COPA("Cinco de Copas", 5, 13, TiposCarta.COPA, "cartas/CincoDeCopa.png"),
	CINCO_DE_ORO("Cinco de Oros", 5, 13, TiposCarta.ORO, "cartas/CincoDeOro.png"),
	CINCO_DE_ESPADA("Cinco de Espadas", 5, 13, TiposCarta.ESPADA, "cartas/CincoDeEspada.png"),
	
	SEIS_DE_BASTO("Seis de Bastos", 6, 12, TiposCarta.BASTO, "cartas/SeisDeBasto.png"),
	SEIS_DE_COPA("Seis de Copas", 6, 12, TiposCarta.COPA, "cartas/SeisDeCopa.png"),
	SEIS_DE_ORO("Seis de Oros", 6, 12, TiposCarta.ORO, "cartas/SeisDeOro.png"),
	SEIS_DE_ESPADA("Seis de Espadas", 6, 12, TiposCarta.ESPADA, "cartas/SeisDeEspada.png"),
	
	SIETE_DE_BASTO("Siete de Bastos", 7, 11, TiposCarta.BASTO, "cartas/SieteDeBasto.png"),
	SIETE_DE_COPA("Siete de Copas", 7, 11, TiposCarta.COPA, "cartas/SieteDeCopa.png"),
	SIETE_DE_ORO("Siete de Oros", 7, 4, TiposCarta.ORO, "cartas/SieteDeOro.png"),
	SIETE_DE_ESPADA("Siete de Espadas", 7, 3, TiposCarta.ESPADA, "cartas/SieteDeEspada.png"),
	
	DIEZ_DE_BASTO("Diez de Bastos", 10, 10, TiposCarta.BASTO, "cartas/DiezDeBasto.png"),
	DIEZ_DE_COPA("Diez de Copas", 10, 10, TiposCarta.COPA, "cartas/DiezDeCopa.png"),
	DIEZ_DE_ORO("Diez de Oros", 10, 10, TiposCarta.ORO, "cartas/DiezDeOro.png"),
	DIEZ_DE_ESPADA("Diez de Espadas", 10, 10, TiposCarta.ESPADA, "cartas/DiezDeEspada.png"),
	
	ONCE_DE_BASTO("Once de Bastos", 11, 9, TiposCarta.BASTO, "cartas/OnceDeBasto.png"),
	ONCE_DE_COPA("Once de Copas", 11, 9, TiposCarta.COPA, "cartas/OnceDeCopa.png"),
	ONCE_DE_ORO("Once de Oros", 11, 9, TiposCarta.ORO, "cartas/OnceDeOro.png"),
	ONCE_DE_ESPADA("Once de Espadas", 11, 9, TiposCarta.ESPADA, "cartas/OnceDeEspada.png"),
	
	DOCE_DE_BASTO("Doce de Bastos", 12, 8, TiposCarta.BASTO, "cartas/DoceDeBasto.png"),
	DOCE_DE_COPA("Doce de Copas", 12, 8, TiposCarta.COPA, "cartas/DoceDeCopa.png"),
	DOCE_DE_ORO("Doce de Oros", 12, 8, TiposCarta.ORO, "cartas/DoceDeOro.png"),
	DOCE_DE_ESPADA("Doce de Espadas", 12, 8, TiposCarta.ESPADA, "cartas/DoceDeEspada.png");
	
	private String nombre;
    private int valor, jerarquia;
    private TiposCarta tipo;
    private String rutaImagen;
    
    private Cartas(String nombre, int valor, int jerarquia, TiposCarta tipo, String rutaImagen) {
    	this.nombre = nombre;
    	this.jerarquia = jerarquia;
    	this.valor = valor;
    	this.tipo = tipo;
    	this.rutaImagen = rutaImagen;
    }
	
	@Override
	public Carta getCarta() {
		return new Carta(this.nombre, this.valor, this.jerarquia, this.tipo, this.rutaImagen);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getValor() {
		return valor;
	}
	
	public int getJerarquia() {
		return jerarquia;
	}
	
	public TiposCarta getTipo() {
		return tipo;
	}
	
	public String getRutaImagen() {
		return rutaImagen;
	}
	
}
