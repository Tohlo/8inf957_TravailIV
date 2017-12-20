package ca.uqac.inf957.travailIV.capteur;

public class Filtre1 extends Filtre {
	@Override
	public String traitement(String string) {
		if (string.contains("P1")) {
			return "Détecté";
		}
		
		return null;
	}
}
