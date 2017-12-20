package ca.uqac.inf957.travailIV.capteur;

public class Filtre2 extends Filtre {
	private String derniereDonnee = "Pas de données";

	@Override
	public String traitement(String string) {
		String retour = string;
		
		if (string == derniereDonnee) {
			retour = null;
		}
		derniereDonnee = string;
		
		return retour;
	}
}
