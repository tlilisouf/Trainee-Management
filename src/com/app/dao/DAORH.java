package com.app.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.app.entity.RH;

public class DAORH extends AbstractDAO<RH> {
	private String request;
	private Statement state;
	private ResultSet resultset;

	public DAORH(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean find(RH pers) {
		String login = null, pass = null;
		try {
			request = "SELECT login,password FROM RH";
			state = connection.createStatement();
			resultset = state.executeQuery(request);
			while (resultset.next()) {
				login = resultset.getString("login");
				pass = resultset.getString("password");
			}
			if (!pers.getLogin().equals(login) && !pers.getPassword().equals(pass)) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;

	}

	@Override
	public void create(RH obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(int stagiaire, String[] tabContenu) {
		// TODO Auto-generated method stub
	}

	@Override
	public void remove(int stagiaire) {
		// TODO Auto-generated method stub
	}

	@Override
	public void find(int searchIntred) {
		// TODO Auto-generated method stub

	}

}
