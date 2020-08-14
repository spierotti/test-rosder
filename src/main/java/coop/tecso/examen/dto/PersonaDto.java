package coop.tecso.examen.dto;

import java.io.Serializable;

public class PersonaDto implements Serializable {

	private static final long serialVersionUID = -6746868885752111724L;

	private int rut;
	
	public int getRutPersona(){
		return rut; 
	}
	
	public void setRutPersona(int rut) {
		this.rut = rut;
	}

}
