
public class Deposito {

	private String nome, luogo;
	private Contenitore[] contenitori;
	private int numContenitori;

	public Deposito(String nome, String luogo) {
		this.nome = nome;
		this.luogo = luogo;
		contenitori = new Contenitore[100];
		numContenitori = 0;
	}

	public boolean addContenitore(Contenitore c) {
		if (numContenitori < 100) {
			contenitori[numContenitori] = c;
			numContenitori++;
			return true;
		}
		return false;
	}

	public boolean delContenitore(String codice) {
		for (int i = 0; i < numContenitori; i++)
			if (contenitori[i].getCodice().compareToIgnoreCase(codice) == 0) {
				for (int j = i; j < numContenitori - 1; j++)
					contenitori[j] = contenitori[j + 1];
				numContenitori--;
				return true;
			}
		return false;
	}

	public Contenitore[] cercaContenitori(String tipoProdotto, float altezza, float larghezza, float profondita,
			float raggioBase) {
		Contenitore[] cTrovati = new Contenitore[numContenitori];
		int cont = 0;
		for (int i = 0; i < numContenitori; i++)
			if (contenitori[i].verificaCompatibilita(tipoProdotto, altezza, larghezza, profondita, raggioBase)) {
				cTrovati[cont] = contenitori[i];
				cont++;
			}
		return cTrovati;
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < numContenitori; i++)
			s += contenitori[i].toString() + "\n";
		return s;
	}

	public static void main(String[] args) {

		// creazione e aggiunta dei contenitori
		Lattina l1 = new Lattina("l1", "parallelepipedo", 10f, 10f, 10f);
		Bidone b1 = new Bidone("b1", "cilindro", 10f, 5f);
		Lattina l2 = new Lattina("l2", "parallelepipedo", 5f, 5f, 5f);
		Bidone b2 = new Bidone("b2", "cilindro", 5f, 1f);
		Lattina l3 = new Lattina("l3", "parallelepipedo", 20f, 20f, 20f);
		Bidone b3 = new Bidone("b3", "cilindro", 20f, 10f);
		Deposito d = new Deposito("Deposito1", "Milano");
		d.addContenitore(l1);
		d.addContenitore(l2);
		d.addContenitore(l3);
		d.addContenitore(b1);
		d.addContenitore(b2);
		d.addContenitore(b3);

		// visualizzo i contenitori adatti a contenere il prodotto con le
		// caratteristiche indicate dai parametri
		System.out.println("Contenitori adatti:\n");
		Contenitore[] cTrovati1 = d.cercaContenitori("parallelepipedo", 5, 6, 4, 0);
		for (int i = 0; i < cTrovati1.length; i++)
			if (cTrovati1[i] != null)
				System.out.println(cTrovati1[i].toString());

		// visualizzo i contenitori adatti a contenere il prodotto con le
		// caratteristiche indicate dai parametri
		System.out.println("\nContenitori adatti:\n");
		Contenitore[] cTrovati2 = d.cercaContenitori("cilindro", 5, 0, 0, 5);
		for (int i = 0; i < cTrovati2.length; i++)
			if (cTrovati2[i] != null)
				System.out.println(cTrovati2[i].toString());

		//visualizzo tutti i contenitori prima dell'eliminazione
		System.out.println("\nElenco contenitori 1:\n" + d);

		
		//elimino un contenitore
		if (d.delContenitore("b1"))
			System.out.println("Eliminazione effettuata correttamente\n");
		else
			System.out.println("Contenitore non trovato\n");

		//visualizzo se l'eliminazione è stata effettuata
		System.out.println("\nElenco contenitori 2:\n" + d);
	}

}
