package com.rest.service;

import java.util.List;

import com.rest.entidad.Cliente;

public interface IClienteService {
	public List<Cliente> findAll();
	
	public Cliente updateCliente(Cliente cliente);
	public Cliente findByid(int id);
	public void save(Cliente cliente);
	public Cliente findSQLUsernameAndEmail(String Username,String Email);
	//public void UpdateSQLClientebyId(int edad,double estatura,double peso,double geb,int id);
}
