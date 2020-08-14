package coop.tecso.examen.dto;

import java.io.Serializable;

public class PersonaFisicaDto extends PersonaDto implements Serializable {

	private static final long serialVersionUID = -879166349985265148L;
	
	private String nombre;
	private String apellido;
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
