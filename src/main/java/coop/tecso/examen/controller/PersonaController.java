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
import coop.tecso.examen.dto.PersonaJuridicaDto;
import coop.tecso.examen.model.Persona;
import coop.tecso.examen.model.PersonaFisica;
import coop.tecso.examen.model.PersonaJuridica;
import coop.tecso.examen.repository.PersonaRepository;

@RestController
@RequestMapping("/personas")
public class PersonaController {

	@Autowired
	private PersonaRepository personaRepository;

	// ALTA PERSONA
	@PostMapping("/insertar")
    public ResponseEntity<?> insertar(@RequestBody PersonaDto dto) {
    	
    	Persona persona = new Persona();
    	
    	persona.setRutPersona(dto.getRutPersona());
    	    		
		personaRepository.save(persona);
		
		return new ResponseEntity<String>("Persona Agregada con Exito!", HttpStatus.OK);
        
    }
	
	// ACTUALIZAR PERSONA
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@RequestBody PersonaDto dto) {
    		
		Persona persona = personaRepository.getOne(dto.getRutPersona());
			
		persona.setRutPersona(dto.getRutPersona());
			
		personaRepository.save(persona);
    		
		return new ResponseEntity<String>("Persona Modificada con Exito!", HttpStatus.OK);
	}
	
	// BORRAR PERSONA
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
						
		personaRepository.deleteById(id);
			
		return new ResponseEntity<String>("Persona Eliminada con Exito!", HttpStatus.OK);
	}
	
	// VER PERSONA
	@GetMapping("/ver")
	public PersonaDto getPersona(int id) {
		
		Persona entity = personaRepository.getOne(id);
					
		PersonaDto result = new PersonaDto();
			
		result.setRutPersona(entity.getRutPersona());
							
		return result;
	}
	
	// LISTADO PERSONAS
	@GetMapping("/findAll")
	public List<PersonaDto> findAll() {
		
		List<PersonaDto> result = new ArrayList<>();
		
		for (Persona entity : personaRepository.findAll()) {
			
			if (entity instanceof PersonaFisica) {
				
				PersonaFisicaDto dto = new PersonaFisicaDto();
		    	
				dto.setApellido(((PersonaFisica) entity).getApellido());
				dto.setNombre(((PersonaFisica) entity).getNombre());
				dto.setCc(((PersonaFisica) entity).getCc());
				dto.setRutPersona(entity.getRutPersona());
				
				result.add(dto);
				
			} else if (entity instanceof PersonaJuridica) {
				
				PersonaJuridicaDto dto = new PersonaJuridicaDto();
		    	
				dto.setAnioFundacion(((PersonaJuridica) entity).getAnioFundacion());
				dto.setRazonSocial(((PersonaJuridica) entity).getRazonSocial());
				dto.setRutPersona(entity.getRutPersona());
				
				result.add(dto);
				
			} else {
				
				PersonaDto dto = new PersonaDto();
				
				dto.setRutPersona(entity.getRutPersona());
				
				result.add(dto);
				
			}
			
			//result.add(dto);
		}
		
	    return result;
	}
}
