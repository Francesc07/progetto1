//cambiamento 2

public class Bidone extends Contenitore {

	private float raggioBase;

	public Bidone(String codice, String contenuto, float altezza, float raggioBase) {
		super(codice, contenuto, altezza);
		this.raggioBase = raggioBase;
	}

	@Override
	public boolean verificaCompatibilita(String tipoProdotto, float altezza, float larghezza, float profondita,
			float raggioBase) {
		if (this.contenuto.compareToIgnoreCase(tipoProdotto) == 0 && this.altezza >= altezza
				&& this.raggioBase >= raggioBase)
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "Bidone [raggioBase=" + raggioBase + ", codice=" + codice + ", contenuto=" + contenuto + ", altezza="
				+ altezza + "]";
	}

	public float getRaggioBase() {
		return raggioBase;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
