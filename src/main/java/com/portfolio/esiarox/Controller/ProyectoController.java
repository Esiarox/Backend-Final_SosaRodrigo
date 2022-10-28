/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.esiarox.Controller;

import com.portfolio.esiarox.Dto.ProyectoDto;
import com.portfolio.esiarox.Entity.Proyecto;
import com.portfolio.esiarox.Security.Controller.MensajeController;
import com.portfolio.esiarox.Service.ProyectoService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Esiarox
 */
@RestController
@RequestMapping("/proy")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectoController {
    @Autowired
    ProyectoService proyectoService;
    
    @GetMapping("/buscarProy")
    public ResponseEntity<List<Proyecto>> listaProy(){
        List<Proyecto> listaProy = proyectoService.listaProy();
        return new ResponseEntity(listaProy, HttpStatus.OK);
    }
    
    @GetMapping("/proy/{id}")
    public ResponseEntity<Proyecto> getProyById(@PathVariable("id") int id){
        if(!proyectoService.existsById(id))
            return new ResponseEntity(new MensajeController("no existe"), HttpStatus.NOT_FOUND);
        Proyecto proyecto = proyectoService.getProy(id).get();

        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @PostMapping("/crearProy")
    public ResponseEntity<?> crearProy(@RequestBody ProyectoDto proyectoDto){
        if(StringUtils.isBlank(proyectoDto.getTitulo()))
            return new ResponseEntity(new MensajeController("El título del proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        if(proyectoService.existsByTitulo(proyectoDto.getTitulo()))
            return new ResponseEntity(new MensajeController("Este proyecto ya existe"), HttpStatus.BAD_REQUEST);
        Proyecto proyecto = new Proyecto(proyectoDto.getTitulo(),proyectoDto.getDescripcion(),proyectoDto.getImagen());
        proyectoService.save(proyecto);
        
        return new ResponseEntity(new MensajeController("El proyecto fue agregado correctamente"), HttpStatus.OK);
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarProy(@PathVariable("id") int id,@RequestBody ProyectoDto proyectoDto){
        if(!proyectoService.existsById(id))
            return new ResponseEntity(new MensajeController("El proyecto no existe"), HttpStatus.BAD_REQUEST);
        if(proyectoService.existsByTitulo(proyectoDto.getTitulo()) && 
                proyectoService.getByTitulo(proyectoDto.getTitulo()).get().getId() != id)
            return new ResponseEntity(new MensajeController("El proyecto no existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(proyectoDto.getTitulo()))
            return new ResponseEntity(new MensajeController("El título del proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyecto proyecto = proyectoService.getProy(id).get();
        proyecto.setTitulo(proyectoDto.getTitulo());
        proyecto.setDescripcion(proyectoDto.getDescripcion());
        proyecto.setImagen(proyectoDto.getImagen());
        proyectoService.save(proyecto);
        
        return new ResponseEntity(new MensajeController("El proyecto fue actualizado correctamente"), HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarProy(@PathVariable("id") int id){
        if(!proyectoService.existsById(id))
            return new ResponseEntity(new MensajeController("El proyecto no existe"), HttpStatus.BAD_REQUEST);    
        proyectoService.delete(id);
        
        return new ResponseEntity(new MensajeController("El proyecto fue eliminado"), HttpStatus.OK);
    }
}
