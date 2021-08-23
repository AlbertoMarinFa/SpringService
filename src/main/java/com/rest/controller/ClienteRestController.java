package com.rest.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entidad.Cliente;
import com.rest.entidad.Respuesta;
import com.rest.service.IClienteService;

@RestController
@RequestMapping("/NutriNET")
public class ClienteRestController {
	@Autowired
	private IClienteService clienteService;
	
	//@GetMapping("/cliente")	
	@GetMapping(value = { "/cliente", "/cliente/{id}" })	
	public ResponseEntity<?> getClientes(@PathVariable(required = false)String id){		
		System.out.println("value id  " + id);
		if(id == null) {
			Respuesta res = new Respuesta("Movimiento exitoso",0,clienteService.findAll());				 
			return new ResponseEntity<>(res, HttpStatus.OK);			
		}
		else {
			if(clienteService.findByid(Integer.parseInt(id)) == null) {
				Respuesta res = new Respuesta("Sin resultados",-1,null);				
				return new ResponseEntity<>(res, HttpStatus.OK);
			}
			else{
				List<Cliente> cli = new ArrayList();
				cli.add(clienteService.findByid(Integer.parseInt(id)));
				Respuesta res = new Respuesta("Movimiento exitoso",0,cli);						
				return new ResponseEntity<>(res, HttpStatus.OK);
			}						
		}		
	}	
	
	@PostMapping("/cliente")
	public ResponseEntity<?> AddCliente(@RequestBody Cliente cliente){		
		if(clienteService.findSQLUsernameAndEmail(cliente.getNombre_Usuario(), cliente.getEmail()) == null) {		
			Respuesta res = new Respuesta("Movimiento exitoso",0,null);	
			clienteService.save(cliente);
			return new ResponseEntity<>(res,HttpStatus.OK);
		}
		else {
			Respuesta res = new Respuesta("El Cliente ya existe",-1,null);				
			return new ResponseEntity<>(res, HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping("/cliente/{id}")	
	public ResponseEntity<?> UpdateCliente(@PathVariable(value="id")int id,@RequestBody Cliente cliente){		
		if(clienteService.findByid(id) == null) {			
			Respuesta res = new Respuesta("El registro no existe",-1,null);				
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		else{
			
			Date time = new Date();
			Cliente saveCli = null;
			saveCli = clienteService.findByid(id);
			saveCli.setEdad(cliente.getEdad());
			saveCli.setPeso(cliente.getPeso());
			saveCli.setGEB(cliente.getGEB());
			saveCli.setEstatura(cliente.getEstatura());
			saveCli.setFecha_Actualizacion(time);
			
			clienteService.updateCliente(saveCli);
						
			List<Cliente> cli = new ArrayList();
			cli.add(saveCli);
			
			Respuesta res = new Respuesta("Movimiento exitoso",0,cli);						
			return new ResponseEntity<>(res, HttpStatus.OK);
		}					
	}
	
	@GetMapping("/getClienteByid/{id}")	
	public ResponseEntity<?> getClienteByid(@PathVariable(value="id")int id){
		
		if(clienteService.findByid(id) == null) {
			Respuesta res = new Respuesta("Sin resultados",-1,null);				
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		else{
			List<Cliente> cli = new ArrayList();
			cli.add(clienteService.findByid(id));
			Respuesta res = new Respuesta("Movimiento exitoso",0,cli);						
			return new ResponseEntity<>(res, HttpStatus.OK);
		}					
	}
}
