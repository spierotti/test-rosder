package coop.tecso.examen.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Moneda  implements Serializable{

	private static final long serialVersionUID = 7918959281949794454L;

	@Id
	private int id;
	
	@Column(name = "descripcion", length = 20)
	private String descripcion;
	
	@Column(name = "descubierto")
	private BigDecimal descubierto;

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

	public BigDecimal getDescubierto() {
		return descubierto;
	}

	public void setDescubierto(BigDecimal descubierto) {
		this.descubierto = descubierto;
	}
	
	
}
