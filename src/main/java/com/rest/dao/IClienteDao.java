package com.rest.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rest.entidad.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{
		
	public Cliente findByid(int id);	
	
	@Query("select c from Cliente c where c.Nombre_Usuario =?1 and c.Email = ?2")
	public Cliente findSQLUsernameAndEmail(String Username,String Email);
				
}
