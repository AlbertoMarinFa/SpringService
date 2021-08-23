package com.rest.entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Respuesta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int Cve_Error = 0;
	public int getCve_Error() {
		return Cve_Error;
	}

	public String getCve_Mensaje() {
		return Cve_Mensaje;
	}
	private String Cve_Mensaje = "";
	List<Cliente> dsRespuesta = new ArrayList();
	
	public List<Cliente> getDsRespuesta() {
		return dsRespuesta;
	}

	public void setDsRespuesta(List<Cliente> dsRespuesta) {
		this.dsRespuesta = dsRespuesta;
	}

	public Respuesta(){
		
	}
	
	public Respuesta(String Cve_Mensaje,int Cve_Error,List<Cliente> list) {
		setCve_Error(Cve_Error);
		setCve_Mensaje(Cve_Mensaje);
		setDsRespuesta(list);
	}
	
	public void setCve_Error(int cve_Error) {
		Cve_Error = cve_Error;
	}
	public void setCve_Mensaje(String cve_Mensaje) {
		Cve_Mensaje = cve_Mensaje;
	}	
	/*public void setDsRespuesta(List<Cliente> dsRespuesta) {
		this.dsRespuesta = dsRespuesta;
	}*/
}
