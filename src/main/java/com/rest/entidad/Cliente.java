package com.rest.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="Cliente")
public class Cliente implements Serializable {
			
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(unique = true)
	private String Nombre_Usuario;
	
	//@Column(name="Password")
	private String Password;
	
	//@Column(name="Nombre")
	private String Nombre;
	
	//@Column(name="Apellidos")
	private String Apellidos;
	
	@Column(unique = true)
	private String Email;
	
	//@Column(name="Edad")
	private int Edad;
	
	//@Column(name="Estatura")
	private Double Estatura;
	
	//@Column(name="Peso")
	private Double Peso;
	
	//@Column(name="IMC")
	private Double IMC;
	
	//@Column(name="GEB")
	private Double GEB;
	
	//@Column(name="ETA")
	private Double ETA;
	
	//@Column(name="Fecha_Creacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date Fecha_Creacion;
	
	//@Column(name="Fecha_Actualizacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date Fecha_Actualizacion;

	@PrePersist
	public void prePersist() {
		Fecha_Creacion = new Date();
	}
	
	public int getid() {
		return id;
	}

	public String getNombre_Usuario() {
		return Nombre_Usuario;
	}

	public void setNombre_Usuario(String nombre_Usuario) {
		Nombre_Usuario = nombre_Usuario;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}

	public Double getEstatura() {
		return Estatura;
	}

	public void setEstatura(Double estatura) {
		Estatura = estatura;
	}

	public Double getPeso() {
		return Peso;
	}

	public void setPeso(Double peso) {
		Peso = peso;
	}

	public Double getIMC() {
		return IMC;
	}

	public void setIMC(Double iMC) {
		IMC = iMC;
	}

	public Double getGEB() {
		return GEB;
	}

	public void setGEB(Double gEB) {
		GEB = gEB;
	}

	public Double getETA() {
		return ETA;
	}

	public void setETA(Double eTA) {
		ETA = eTA;
	}

	public Date getFecha_Creacion() {
		return Fecha_Creacion;
	}

	public void setFecha_Creacion(Date fecha_Creacion) {
		Fecha_Creacion = fecha_Creacion;
	}

	public Date getFecha_Actualizacion() {
		return Fecha_Actualizacion;
	}

	public void setFecha_Actualizacion(Date fecha_Actualizacion) {
		Fecha_Actualizacion = fecha_Actualizacion;
	}
	
	private static final long serialVersionUID = 1l;
}
