package com.app.dao;

import java.sql.Connection;

import com.app.entity.RH;

public abstract class AbstractDAO<T> {
	protected Connection connection = null;

	public AbstractDAO(Connection connection) {
		this.connection = connection;
	}

	public abstract void create(T obj);

	public abstract void find(int searchIntred);

	public abstract boolean find(RH pers);

	public abstract void remove(int stagiaire);

	public abstract void modify(int stagiaire, String[] tabContenu);
}
