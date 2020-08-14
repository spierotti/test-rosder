package coop.tecso.examen.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PersonaJuridica extends Persona {
		
	@Column(name = "razon_social",length = 100)
	private String razonSocial;

	@Column(name = "anio_fundacion")
	private int anioFundacion;

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public int getAnioFundacion() {
		return anioFundacion;
	}

	public void setAnioFundacion(int anioFundacion) {
		this.anioFundacion = anioFundacion;
	}
	
	
}
