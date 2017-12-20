package ca.uqac.inf957.travailIV.capteur;

import java.util.List;
import java.util.Random;

public class Capteur {
	public Capteur(List<Filtre> filtres, int portee, int frequence) {
		id = prochainId++;
		this.filtres = filtres;
		this.portee = portee;
		this.frequence = frequence;
		tempsAvantEnvoi = frequence;
	}

	static private Random seed = new Random();
	static private int prochainId;

	private List<Filtre> filtres;

	private int id;

	public int getId() {
		return id;
	}

	private int portee;

	public int getPortee() {
		return portee;
	}

	public void setPortee(int portee) {
		this.portee = portee;
	}

	private int frequence;

	public int getFrequence() {
		return frequence;
	}

	public void setFrequence(int frequence) {
		this.frequence = frequence;
	}

	private int tempsAvantEnvoi;

	public int getTempsAvantEnvoi() {
		return tempsAvantEnvoi;
	}

	private int opt = 0;

	public int getOpt() {
		return opt;
	}

	public void setOpt(int opt) {
		this.opt = opt;
	}


	public void update() {
		if (tempsAvantEnvoi <= 0) {
			tempsAvantEnvoi = frequence;
		}
		else {
			tempsAvantEnvoi--;
		}

		if (opt == 0 && seed.nextInt(99) <= 75) {
			opt = 1;
		}
		else if (seed.nextInt(99) <= 33) {
			opt = 0;
		}
	}

	public String donnees() {
		String donnees =  "P" + Integer.toString(opt);

		if (filtres != null) {
			for (Filtre filtre : filtres) {
				donnees = filtre.traitement(donnees);
			}
		}
		
		if (donnees != null) {
			return Integer.toString(id) + ":R" + Integer.toString(portee) + "_" + donnees;
		}
		
		return null;
	}

	public boolean estPret() {
		return tempsAvantEnvoi <= 0;
	}


}
