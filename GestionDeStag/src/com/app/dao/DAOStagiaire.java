package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.app.entity.RH;
import com.app.entity.Stagiaire;

public class DAOStagiaire extends AbstractDAO<Stagiaire> {

	private String query;
	private PreparedStatement prepstat;
	private Object[] tableau;
	private Statement statement;
	private ResultSet rset = null;

	public DAOStagiaire(Connection connection) {
		super(connection);
	}

	@Override
	public void find(int stagiaire) {
		try {
			int cin = 0;
			query = "SELECT *  FROM stagiaire";
			statement = connection.createStatement();
			rset = statement.executeQuery(query);
			while (rset.next()) {
				cin = rset.getInt("CINStagiaire");
				if (stagiaire == cin) {
					tableau = new Object[] { rset.getInt("CINStagiaire"), rset.getString("nomStagiaire"),
							rset.getString("prenomStagiaire"), rset.getString("naissanceStagiaire"),
							rset.getString("universiteStagiaire"), rset.getString("specialtyStagiaire") };
					break;
				}
			}
		} catch (SQLException e) {

		}
	}

	public Object[] getTableau() {
		return tableau;
	}

	@Override
	public void create(Stagiaire stagiaire) {
		try {
			stagiaire.addStagiaire(stagiaire);
			query = "INSERT INTO stagiaire  VALUES(?,?,?,?,?,?,?,?)";
			prepstat = connection.prepareStatement(query);
			prepstat.setInt(1, stagiaire.getCin());
			prepstat.setString(2, stagiaire.getNom());
			prepstat.setString(3, stagiaire.getPrenom());
			prepstat.setString(4, stagiaire.getDatenaissance());
			prepstat.setString(5, stagiaire.getUniversite());
			prepstat.setString(6, stagiaire.getSpecialite());
			prepstat.setString(7, stagiaire.getAdresse());
			prepstat.setString(8, stagiaire.getEmail());
			prepstat.executeUpdate();
			JOptionPane.showMessageDialog(null, "Successfull Add", "Message d’avertissement",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERROR ADD INTO DB", "Message d’avertissement",
					JOptionPane.ERROR_MESSAGE);

		}
		/*
		 * finally { try { if (connection != null) connection.close(); } catch
		 * (SQLException e) { e.printStackTrace(); } }
		 */
	}

	@Override
	public void remove(int stagiaire) {
		try {

			query = "DELETE FROM stagiaire WHERE CINStagiaire=?";
			prepstat = connection.prepareStatement(query);
			prepstat.setInt(1, stagiaire);
			prepstat.executeUpdate();
			JOptionPane.showMessageDialog(null, "Successfull DELETE", "Message d’avertissement",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERROR", "Message d’avertissement", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public boolean find(RH pers) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void modify(int stagiaire, String[] tabContenu) {
		try {
			query = "UPDATE stagiaire SET nomStagiaire=?,prenomStagiaire=? ,naissanceStagiaire=?,universiteStagiaire=?,specialtyStagiaire=? WHERE CINStagiaire=?";
			prepstat = connection.prepareStatement(query);
			prepstat.setString(1, tabContenu[1]);
			prepstat.setString(2, tabContenu[2]);
			prepstat.setString(3, tabContenu[3]);
			prepstat.setString(4, tabContenu[4]);
			prepstat.setString(5, tabContenu[5]);
			prepstat.setInt(6, stagiaire);
			prepstat.executeUpdate();
			JOptionPane.showMessageDialog(null, "Successfull Alter", "Message d’avertissement",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERROR", "Message d’avertissement", JOptionPane.ERROR_MESSAGE);

		}
	}

}
