package coop.tecso.examen.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Persona{
			
	@Id
	private int rut;
	
	public int getRutPersona(){
		return rut; 
	}
	
	public void setRutPersona(int rut) {
		this.rut = rut;
	}
	
}
