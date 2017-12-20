package ca.uqac.inf957.travailIV.parking;

import java.util.ArrayList;
import java.util.List;
import ca.uqac.inf957.travailIV.capteur.Capteur;
import ca.uqac.inf957.travailIV.capteur.Filtre;
import ca.uqac.inf957.travailIV.capteur.Filtre1;
import ca.uqac.inf957.travailIV.capteur.Filtre2;

public class Parking {
	private List<Capteur> capteurs = new ArrayList<Capteur>();
	
	private int temps = 0;
	
	public Parking() {
		Capteur capteur1 = new Capteur(null, 180, 60);
		capteurs.add(capteur1);
		
		List<Filtre> filtresCapteur2 = new ArrayList<Filtre>();
		filtresCapteur2.add(new Filtre1());
		Capteur capteur2 = new Capteur(filtresCapteur2, 260, 30);
		capteurs.add(capteur2);
		
		List<Filtre> filtresCapteur3 = new ArrayList<Filtre>();
		filtresCapteur3.add(new Filtre1());
		filtresCapteur3.add(new Filtre2());
		Capteur capteur3 = new Capteur(filtresCapteur3, 300, 15);
		capteurs.add(capteur3);
		
	}
	
	private void update() {
		for (Capteur capteur : capteurs) {
			capteur.update();
			
			if (capteur.estPret()) {
				String sortie = capteur.donnees();
				
				if (sortie != null) {
					System.out.println("Temps : " + Integer.toString(temps) + " - " + sortie);
				}
			}
		}
		
		temps++;
	}
	
	public static void main(String[] args) {
		Parking parking = new Parking();

		for (int i = 0; i < 1000; ++i) {
			parking.update();
		}
	}
}
