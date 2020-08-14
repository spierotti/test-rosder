package coop.tecso.examen.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CuentaCorriente implements Serializable{
	
	private static final long serialVersionUID = -2394858825624867930L;

	@Id
	private int nroCuenta;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "titular_id")
    @JsonIgnore
	private Persona titular;
    
    @OneToMany(mappedBy = "nroCuenta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Movimiento> movimientos = new ArrayList<>();
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "moneda_id")
    @JsonIgnore
	private Moneda moneda;
	
	@Column(name = "saldo")
	private BigDecimal saldo;

	public int getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(int nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	public Persona getTitular() {
		return titular;
	}

	public void setTituar(Persona titular) {
		this.titular = titular;
	}

	public List<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	
	public int getIdMoneda() {
		
		return this.moneda.getId();
	}

	public int getRutTitular() {

		return this.titular.getRutPersona();
	}

	public boolean hayMovimientos() {
		
		if (this.movimientos.size() > 0) {
			return true;
		}
		
		return false;
	}

	public BigDecimal getDescubiertoMoneda() {

		return this.moneda.getDescubierto();
	}

	public boolean modificaSaldo(Movimiento movimiento) {
		
		if (movimiento.getTipo().equals("CREDITO")) {
			
			this.saldo = this.saldo.add(movimiento.getImporte());
			
			return true;
			
		}else if (movimiento.getTipo().equals("DEBITO") && !isDescubierto(movimiento)) {
			
			this.saldo = this.saldo.subtract(movimiento.getImporte());
			
			return true;
			
		}else {
		
			return false;
		}
	}

	private boolean isDescubierto(Movimiento movimiento) {
		
		if ((this.saldo.subtract(movimiento.getImporte())).compareTo(this.moneda.getDescubierto().multiply(new BigDecimal(-1))) < 0) {
			return true;
		}
		
		return false;
	}
}
