package coop.tecso.examen.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.dto.MovimientoDto;
import coop.tecso.examen.model.CuentaCorriente;
import coop.tecso.examen.model.Movimiento;
import coop.tecso.examen.repository.CuentaCorrienteRepository;
import coop.tecso.examen.repository.MovimientoRepository;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

	@Autowired
	private MovimientoRepository movimientoRepository;

	@Autowired
	private CuentaCorrienteRepository cuentaCorrienteRepository;

	// ALTA DE MOVIMIENTO
	@PostMapping("/insertar")
    public ResponseEntity<?> insertar(@RequestBody MovimientoDto dto) {
		
		String msj = "";
		
		CuentaCorriente cuentaCorriente = cuentaCorrienteRepository.getOne(dto.getNroCuenta());

		Movimiento movimiento = new Movimiento();
		movimiento.setId(dto.getId());
		movimiento.setDescripcion(dto.getDescripcion());
		movimiento.setFechaMovimiento(dto.getFechaMovimiento());
		movimiento.setNroCuenta(cuentaCorriente);
		movimiento.setTipo(dto.getTipo());
		movimiento.setImporte(dto.getImporte());
		
		if (cuentaCorriente.modificaSaldo(movimiento)) {
			
			movimientoRepository.save(movimiento);
			
			cuentaCorrienteRepository.save(cuentaCorriente);
			
			msj = "Movimiento cargado con Exito!";
			
			return new ResponseEntity<String>(msj, HttpStatus.OK);	
		}
		
		msj = "Descubierto mayor a " + cuentaCorriente.getDescubiertoMoneda();
		
		return new ResponseEntity<String>(msj, HttpStatus.OK);
    }
	
	// LISTADO DE MOVIMIENTOS POR CUENTA
	@GetMapping("/cuenta/{nroCuenta}")
	public List<MovimientoDto> findAll(@PathVariable("nroCuenta") Integer nroCuenta) {
		
		CuentaCorriente cuenta = cuentaCorrienteRepository.getOne(nroCuenta);
		
		List<MovimientoDto> result = new ArrayList<>();
		
		for (Movimiento entity : movimientoRepository.findByNroCuenta(cuenta)) {
			
			MovimientoDto dto = new MovimientoDto();
			
			dto.setId(entity.getId());
			dto.setDescripcion(entity.getDescripcion());
			dto.setFechaMovimiento(entity.getFechaMovimiento());
			dto.setNroCuenta(entity.getIdNroCuenta());
			dto.setTipo(entity.getTipo());
			dto.setImporte(entity.getImporte());
			
			result.add(dto);
		}
		
		return result;
	}
}
