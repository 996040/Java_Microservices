package com.zensar.jdbc.dao;

import com.zensar.jdbc.entities.Client;

public interface ClientDao {
	
	public int insert(Client client);
	public int update(Client client);
	public int delete(int clientId);

}
