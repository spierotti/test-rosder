package coop.tecso.examen.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PersonaFisica extends Persona {

	@Column(name = "nombre", length = 80)
	private String nombre;
	
	@Column(name = "apellido", length = 250)
	private String apellido;
	
	@Column(name = "cc")
	private int cc;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	
}
