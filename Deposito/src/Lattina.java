
public class Lattina extends Contenitore {

	public float larghezza, profondita;

	public Lattina(String codice, String contenuto, float altezza, float larghezza, float profondita) {
		super(codice, contenuto, altezza);
		this.larghezza = larghezza;
		this.profondita = profondita;
	}

	@Override
	public boolean verificaCompatibilita(String tipoProdotto, float altezza, float larghezza, float profondita,
			float raggioBase) {
		if (this.contenuto.compareToIgnoreCase(tipoProdotto) == 0 && this.altezza >= altezza
				&& this.larghezza >= larghezza && this.profondita >= profondita)
			return true;
		return false;
	}

	public float getLarghezza() {
		return larghezza;
	}

	public float getProfondita() {
		return profondita;
	}

	@Override
	public String toString() {
		return "Lattina [larghezza=" + larghezza + ", profondita=" + profondita + ", codice=" + codice + ", contenuto="
				+ contenuto + ", altezza=" + altezza + "]";
	}

	public static void main(String[] args) {

	}

}
