package coop.tecso.examen.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Movimiento  implements Serializable{

	private static final long serialVersionUID = -5688816091217206190L;
	
	@Id
	private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nro_cuenta")
    @JsonIgnore
	private CuentaCorriente nroCuenta;
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_movimiento", length = 20)
    private Date fechaMovimiento;

    @Column(name = "tipo_movimiento")
    private String tipo;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "importe")
    private BigDecimal importe;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CuentaCorriente getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(CuentaCorriente nroCuenta) {
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

	public int getIdNroCuenta() {

		return this.nroCuenta.getNroCuenta();
	}
    
    
}
