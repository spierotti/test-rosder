package coop.tecso.examen.dto;

import java.io.Serializable;

public class PersonaJuridicaDto extends PersonaDto implements Serializable {

	private static final long serialVersionUID = 3607525085583701491L;

	private String razonSocial;
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
