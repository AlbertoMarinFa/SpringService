package com.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.dao.IClienteDao;
import com.rest.entidad.Cliente;


@Service
public class ClienteServiceImplementation implements IClienteService{
	
	@Autowired
	private IClienteDao clientedao;


	@Override
	@Transactional
	public Cliente updateCliente(Cliente cliente) {		
		return (Cliente) clientedao.save(cliente);
	}


	@Override
	@Transactional
	public void save(Cliente cliente) {
		cliente.setFecha_Actualizacion(null);
		clientedao.save(cliente);
		
	}

	@Override
	@Transactional
	public List<Cliente> findAll() {
		return (List<Cliente>) clientedao.findAll();
	}


	@Override
	@Transactional
	public Cliente findByid(int id) {
		return (Cliente) clientedao.findByid(id);
	}


	@Override
	@Transactional
	public Cliente findSQLUsernameAndEmail(String Username, String Email) {
		return (Cliente) clientedao.findSQLUsernameAndEmail(Username, Email);
	}


	/*@Override
	@Transactional
	public void UpdateSQLClientebyId(int edad, double estatura, double peso, double geb, int id) {
		  UpdateSQLClientebyId(edad, estatura, peso, geb, id);
	}*/

}
