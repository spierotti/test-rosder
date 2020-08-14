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
import coop.tecso.examen.dto.PersonaFisicaDto;
import coop.tecso.examen.model.PersonaFisica;
import coop.tecso.examen.repository.PersonaFisicaRepository;

@RestController
@RequestMapping("/fisicas")
public class PersonaFisicaController {
	
	@Autowired
	private PersonaFisicaRepository personaFisicaRepository;

	// ALTA PERSONA
	@PostMapping("/insertar")
    public ResponseEntity<?> insertar(@RequestBody PersonaFisicaDto dto) {
    	
    	PersonaFisica persona = new PersonaFisica();
    	
    	persona.setApellido(dto.getApellido());
    	persona.setNombre(dto.getNombre());
    	persona.setCc(dto.getCc());
    	persona.setRutPersona(dto.getRutPersona());
    	
    	persona.setRutPersona(dto.getRutPersona());
    	    		
    	personaFisicaRepository.save(persona);
		
		return new ResponseEntity<String>("Persona Agregada con Exito!", HttpStatus.OK);
        
    }
	
	// ACTUALIZAR PERSONA
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@RequestBody PersonaFisicaDto dto) {
    		
		PersonaFisica persona = personaFisicaRepository.getOne(dto.getRutPersona());
			
		persona.setApellido(dto.getApellido());
    	persona.setNombre(dto.getNombre());
    	persona.setCc(dto.getCc());
			
    	personaFisicaRepository.save(persona);
    		
		return new ResponseEntity<String>("Persona Modificada con Exito!", HttpStatus.OK);
	}
	
	// BORRAR PERSONA
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
						
		personaFisicaRepository.deleteById(id);
			
		return new ResponseEntity<String>("Persona Eliminada con Exito!", HttpStatus.OK);
	}
	
	// VER PERSONA
	@GetMapping("/ver")
	public PersonaDto getPersona(int id) {
		
		PersonaFisica entity = personaFisicaRepository.getOne(id);
					
		PersonaFisicaDto result = new PersonaFisicaDto();
    	
		result.setApellido(entity.getApellido());
		result.setNombre(entity.getNombre());
		result.setCc(entity.getCc());
		result.setRutPersona(entity.getRutPersona());
							
		return result;
	}
	
	// LISTADO PERSONAS
	@GetMapping("/findAll")
	public List<PersonaFisicaDto> findAll() {
		
		List<PersonaFisicaDto> result = new ArrayList<>();
		
		for (PersonaFisica entity : personaFisicaRepository.findAll()) {
			
			PersonaFisicaDto dto = new PersonaFisicaDto();
	    	
			dto.setApellido(entity.getApellido());
			dto.setNombre(entity.getNombre());
			dto.setCc(entity.getCc());
			dto.setRutPersona(entity.getRutPersona());
			
			result.add(dto);
		}
		
	    return result;
	}

}
