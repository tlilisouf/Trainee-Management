package com.app.controller;

import com.app.dao.DAORH;
import com.app.dao.DAOStagiaire;
import com.app.dao.JDBC;
import com.app.entity.RH;
import com.app.entity.Stagiaire;
import com.app.view.Authentication;
import com.app.view.GestionSatgiare;

import listeners.CRUDListner;
import listeners.LoginListner;

public class Controller implements LoginListner, CRUDListner {
	private Authentication auth;
	private DAOStagiaire controllerstag;
	private GestionSatgiare stagiaireG;
	private DAORH personnelDAO;

	public Controller() {
		auth = new Authentication();
		auth.setVisible(true);
		auth.setLoginListner(this);
	}

	private void AddStagiaire(Stagiaire stagiaire) {
		controllerstag = new DAOStagiaire(JDBC.getConnection());
		controllerstag.create(stagiaire);
		searchStag(stagiaire.getCin());
	}

	private void searchStag(int stagiaire) {
		controllerstag = new DAOStagiaire(JDBC.getConnection());
		controllerstag.find(stagiaire);
		stagiaireG.showOntableSearch(controllerstag.getTableau());
	}

	@Override
	public void loginPerformed(RH logpass) {
		personnelDAO = new DAORH(JDBC.getConnection());
		if (personnelDAO.find(logpass) == true) {
			auth.dispose();
			stagiaireG = new GestionSatgiare();
			stagiaireG.setVisible(true);
			stagiaireG.setRetieveListner(Controller.this);
		}
	}

	private void removeStagiaire(int stagiaire) {
		controllerstag = new DAOStagiaire(JDBC.getConnection());
		controllerstag.remove(stagiaire);

	}

	private void modifyStagiaire(int stagiaire, String[] tabContenu) {
		controllerstag = new DAOStagiaire(JDBC.getConnection());
		controllerstag.modify(stagiaire, tabContenu);
	}

	@Override
	public void SearchPerformed(int stagiaire) {
		searchStag(stagiaire);
	}

	@Override
	public void addPerformed(Stagiaire stagiaire) {
		AddStagiaire(stagiaire);
	}

	@Override
	public void removePerformed(int stagiaire) {
		removeStagiaire(stagiaire);
	}

	@Override
	public void modifyPerformed(int stagiaire, String[] tabContenu) {
		modifyStagiaire(stagiaire, tabContenu);
	}
}
