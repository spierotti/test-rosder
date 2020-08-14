package coop.tecso.examen.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.dto.CuentaCorrienteDto;
import coop.tecso.examen.model.CuentaCorriente;
import coop.tecso.examen.repository.CuentaCorrienteRepository;
import coop.tecso.examen.repository.MonedaRepository;
import coop.tecso.examen.repository.PersonaRepository;

@RestController
@RequestMapping("/cuentas")
public class CuentaCorrienteController {

	@Autowired
	private CuentaCorrienteRepository cuentaCorrienteRepository;
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private MonedaRepository monedaRepository; 

	// ALTA DE CUENTA
	@PostMapping("/insertar")
    public ResponseEntity<?> insertar(@RequestBody CuentaCorrienteDto dto) {
    	
		CuentaCorriente cc = new CuentaCorriente();
		
    	cc.setMoneda(monedaRepository.getOne(dto.getMoneda()));
    	cc.setNroCuenta(dto.getNroCuenta());
    	cc.setSaldo(new BigDecimal(0));
    	cc.setTituar(personaRepository.getOne(dto.getTitular()));
    	    		
    	cuentaCorrienteRepository.save(cc);
		
		return new ResponseEntity<String>("Cuenta Agregada con Exito!", HttpStatus.OK);
        
    }
	
	// LISTADO DE CUENTAS
	@GetMapping("/findAll")
	public List<CuentaCorrienteDto> findAll() {
		
		List<CuentaCorrienteDto> result = new ArrayList<>();
		
		for (CuentaCorriente entity : cuentaCorrienteRepository.findAll()) {
			
			CuentaCorrienteDto dto = new CuentaCorrienteDto();
			
			dto.setMoneda(entity.getIdMoneda());
			dto.setNroCuenta(entity.getNroCuenta());
			dto.setSaldo(entity.getSaldo());
			dto.setTituar(entity.getRutTitular());
			
			result.add(dto);
		}
		
	    return result;
	}

	// BORRAR DE CUENTA
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
		
		if (!cuentaCorrienteRepository.getOne(id).hayMovimientos() ) {
			
			cuentaCorrienteRepository.deleteById(id);
			
			return new ResponseEntity<String>("Cuenta Eliminada con Exito!", HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("La cuenta no se puede eliminar!", HttpStatus.OK);
	}
	
}
