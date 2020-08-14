package coop.tecso.examen.dto;

import java.io.Serializable;

public class MonedaDto  implements Serializable {

	private static final long serialVersionUID = -6503678820647793499L;

	private int id;
	
	private String descripcion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
