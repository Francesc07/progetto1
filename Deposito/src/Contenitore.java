
public abstract class Contenitore {

	protected String codice, contenuto;
	protected float altezza;

	public Contenitore(String codice, String contenuto, float altezza) {
		this.codice = codice;
		this.contenuto = contenuto;
		this.altezza = altezza;
	}

	//i parametri del metodo identificano un prodotto (non tutti i campi sono necessari)
	public abstract boolean verificaCompatibilita(String tipoProdotto, float altezza, float larghezza, float profondita,
			float raggioBase);

	public String getCodice() {
		return codice;
	}

	public String getContenuto() {
		return contenuto;
	}

	public float getAltezza() {
		return altezza;
	}

}
