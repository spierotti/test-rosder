package coop.tecso.examen.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class CuentaCorrienteDto implements Serializable {

	private static final long serialVersionUID = -6914080978562750788L;

	private int nroCuenta;
	private int titular;
	private int moneda;
	private BigDecimal saldo;

	public int getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(int nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	public int getTitular() {
		return titular;
	}

	public void setTituar(int titular) {
		this.titular = titular;
	}

	public int getMoneda() {
		return moneda;
	}

	public void setMoneda(int moneda) {
		this.moneda = moneda;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	
	
}
