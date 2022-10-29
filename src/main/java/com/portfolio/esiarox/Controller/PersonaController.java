/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.esiarox.Controller;

import com.portfolio.esiarox.Dto.PersonaDto;
import com.portfolio.esiarox.Entity.Persona;
import com.portfolio.esiarox.Interface.IPersonaService;
import com.portfolio.esiarox.Security.Controller.MensajeController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Esiarox
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping("/personas/buscar")
    public List<Persona> buscarPersonas(){
        return ipersonaService.buscarPersonas();
    }
    
    @GetMapping("/personas/buscar/perfil")
    public Persona cargarPerfil(){
        return ipersonaService.buscarPersona(1);
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String crearPersona(@RequestBody Persona persona){
        ipersonaService.guardarPersona(persona);
        return "Se ha agregado correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String borrarPersona(@PathVariable Integer id){
        ipersonaService.borrarPersona(id);
        return "Se ha eliminado correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar2/{id}")
    public Persona editarPersona(@PathVariable Integer id,@RequestParam("nombre") String nuevoNombre,
                                                          @RequestParam("apellido") String nuevoApellido,
                                                          @RequestParam("imagen") String nuevaImagen,
                                                          @RequestParam("titulo") String nuevoTitulo,
                                                          @RequestParam("acercaDe") String nuevoAcercaDe){
        Persona persona = ipersonaService.buscarPersona(id);
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImagen(nuevaImagen);
        persona.setTitulo(nuevoTitulo);
        persona.setAcercaDe(nuevoAcercaDe);
        ipersonaService.guardarPersona(persona);
        return persona;
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    public ResponseEntity<?> editarPer(@PathVariable("id") int id,@RequestBody PersonaDto personaDto){
 
        Persona persona = ipersonaService.buscarPersona(id);
        persona.setNombre(personaDto.getNombre());
        persona.setApellido(personaDto.getApellido());
        persona.setImagen(personaDto.getImagen());
        persona.setTitulo(personaDto.getTitulo());
        persona.setAcercaDe(personaDto.getAcercaDe());
        persona.setImagenBanner(personaDto.getImagenBanner());
        ipersonaService.guardarPersona(persona);
        
        return new ResponseEntity(new MensajeController("La información fue actualizada correctamente"), HttpStatus.OK);
    }
}
