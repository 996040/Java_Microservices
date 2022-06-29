package com.zensar.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.zensar.jdbc.entities.Client;

public class ClientDaoImpl implements ClientDao {

	private JdbcTemplate jdbcTemplate;

	public int insert(Client client) {
	   String query = "insert into client(id,name,city) values(?,?,?)";
	   int result = this.jdbcTemplate.update(query,client.getId(),client.getName(),client.getCity());
		return result;
	}
	
	public int update(Client client) {
//   update data
		String query="update client set name=?, city=? where id=?";
		int result = this.jdbcTemplate.update(query,client.getName(),client.getCity(),client.getId());
		return result;
	}
	
//   Delete data 

	public int delete(int clientId) {
		String query="delete from client where id=?";
		int result = this.jdbcTemplate.update(query,clientId);
		return result;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
