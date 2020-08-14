package coop.tecso.examen.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Persona implements Serializable{
			
	private static final long serialVersionUID = 894649363665109358L;
	
	@Id
	private int rut;
	
	@OneToMany(mappedBy = "titular", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<CuentaCorriente> cuentas = new ArrayList<>();
	
	public int getRutPersona(){
		return rut; 
	}
	
	public void setRutPersona(int rut) {
		this.rut = rut;
	}
	
}
