package coop.tecso.examen.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.dto.PersonaDto;
import coop.tecso.examen.dto.PersonaJuridicaDto;
import coop.tecso.examen.model.PersonaJuridica;
import coop.tecso.examen.repository.PersonaJuridicaRepository;

@RestController
@RequestMapping("/juridicas")
public class PersonaJuridicaController {
	
	@Autowired
	private PersonaJuridicaRepository personaJuridicaRepository;

	// ALTA PERSONA
	@PostMapping("/insertar")
    public ResponseEntity<?> insertar(@RequestBody PersonaJuridicaDto dto) {
    	
		PersonaJuridica persona = new PersonaJuridica();
    	
    	persona.setAnioFundacion(dto.getAnioFundacion());
    	persona.setRazonSocial(dto.getRazonSocial());
    	persona.setRutPersona(dto.getRutPersona());
    	    		
    	personaJuridicaRepository.save(persona);
		
		return new ResponseEntity<String>("Persona Agregada con Exito!", HttpStatus.OK);
        
    }
	
	// ACTUALIZAR PERSONA
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@RequestBody PersonaJuridicaDto dto) {
    		
		PersonaJuridica persona = personaJuridicaRepository.getOne(dto.getRutPersona());
    	
    	persona.setAnioFundacion(dto.getAnioFundacion());
    	persona.setRazonSocial(dto.getRazonSocial());
    	persona.setRutPersona(dto.getRutPersona());
			
		personaJuridicaRepository.save(persona);
    		
		return new ResponseEntity<String>("Persona Modificada con Exito!", HttpStatus.OK);
	}
	
	// BORRAR PERSONA
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
						
		personaJuridicaRepository.deleteById(id);
			
		return new ResponseEntity<String>("Persona Eliminada con Exito!", HttpStatus.OK);
	}
	
	// VER PERSONA
	@GetMapping("/ver")
	public PersonaDto getPersona(int id) {
		
		PersonaJuridica entity = personaJuridicaRepository.getOne(id);
					
		PersonaJuridicaDto result = new PersonaJuridicaDto();
    	
		result.setAnioFundacion(entity.getAnioFundacion());
		result.setRazonSocial(entity.getRazonSocial());
		result.setRutPersona(entity.getRutPersona());
							
		return result;
	}
	
	// LISTADO PERSONAS
	@GetMapping("/findAll")
	public List<PersonaDto> findAll() {
		
		List<PersonaDto> result = new ArrayList<>();
		
		for (PersonaJuridica entity : personaJuridicaRepository.findAll()) {
			
			PersonaJuridicaDto dto = new PersonaJuridicaDto();
	    	
			dto.setAnioFundacion(entity.getAnioFundacion());
			dto.setRazonSocial(entity.getRazonSocial());
			dto.setRutPersona(entity.getRutPersona());
			
			result.add(dto);
		}
		
	    return result;
	}

}
