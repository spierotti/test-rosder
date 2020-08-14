package coop.tecso.examen.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MovimientoDto  implements Serializable {

	private static final long serialVersionUID = -7168917373104796609L;

	private int id;
	private int nroCuenta;
    private Date fechaMovimiento;
    private String tipo;
    private String descripcion;
    private BigDecimal importe;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(int nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	public Date getFechaMovimiento() {
		return fechaMovimiento;
	}

	public void setFechaMovimiento(Date fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
    
    
}
