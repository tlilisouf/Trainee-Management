package com.app.entity;

import java.util.ArrayList;
public class Stagiaire {
	private Stagiaire stagiaire;
	private int cin;
	private String nom, prenom, universite, specialite, adresse, email;
	private String datenaissance;
	private ArrayList<Stagiaire> listestagiaire = new ArrayList<Stagiaire>();
	private int index;

	public Stagiaire(int cin, String nom, String prenom, String datenaissance, String universite, String specialite,
			String adresse, String email) {

		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.datenaissance = datenaissance;
		this.universite = universite;
		this.specialite = specialite;
		this.adresse = adresse;
		this.email = email;

	}

	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDatenaissance() {
		return datenaissance;
	}

	public void setDatenaissance(String datenaissance) {
		this.datenaissance = datenaissance;
	}

	public String getUniversite() {
		return universite;
	}

	public void setUniversite(String universite) {
		this.universite = universite;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Stagiaire> getListestagiaire() {
		return listestagiaire;
	}

	public void setListestagiaire(ArrayList<Stagiaire> listestagiaire) {
		this.listestagiaire = listestagiaire;
	}

	public void deleteStagiaire(String cin) {
		if (listestagiaire.contains(cin))
			listestagiaire.remove(cin);
	}

	public boolean searchStagiaire(String[] searchIntred) {
		for (String obj : searchIntred) {
			if (!listestagiaire.contains(obj)) {
				return false;
			} else {
				index = listestagiaire.indexOf(obj);
				setStagiaire(listestagiaire.get(index));
				break;
			}
		}
		return true;

	}

	public void addStagiaire(Stagiaire stagiaire) {
		listestagiaire.add(stagiaire);
	}

	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

}
