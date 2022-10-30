/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.esiarox.Controller;

import com.portfolio.esiarox.Dto.EducacionDto;
import com.portfolio.esiarox.Entity.Educacion;
import com.portfolio.esiarox.Security.Controller.MensajeController;
import com.portfolio.esiarox.Service.EducacionService;
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
@RequestMapping("/edu")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://ap-frontend-rs.web.app")
public class EducacionController {
    @Autowired
    EducacionService educacionService;
    
    @GetMapping("/buscarEdu")
    public ResponseEntity<List<Educacion>> listaEdu(){
        List<Educacion> listaEdu = educacionService.listaEdu();
        return new ResponseEntity(listaEdu, HttpStatus.OK);
    }
    
    @GetMapping("/edu/{id}")
    public ResponseEntity<Educacion> getEduById(@PathVariable("id") int id){
        if(!educacionService.existsById(id))
            return new ResponseEntity(new MensajeController("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = educacionService.getEdu(id).get();

        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @PostMapping("/crearEdu")
    public ResponseEntity<?> crearEdu(@RequestBody EducacionDto educacionDto){
        if(StringUtils.isBlank(educacionDto.getTitulo()))
            return new ResponseEntity(new MensajeController("El título obtenido es obligatorio"), HttpStatus.BAD_REQUEST);
        if(educacionService.existsByTitulo(educacionDto.getTitulo()))
            return new ResponseEntity(new MensajeController("Este título ya existe"), HttpStatus.BAD_REQUEST);
        Educacion educacion = new Educacion(educacionDto.getAnio(),educacionDto.getTitulo(),educacionDto.getInstitucion());
        educacionService.save(educacion);
        
        return new ResponseEntity(new MensajeController("La educacion fue agregada correctamente"), HttpStatus.OK);
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarEdu(@PathVariable("id") int id,@RequestBody EducacionDto educacionDto){
        if(!educacionService.existsById(id))
            return new ResponseEntity(new MensajeController("La educación no existe"), HttpStatus.BAD_REQUEST);
        if(educacionService.existsByTitulo(educacionDto.getTitulo()) && 
                educacionService.getByTitulo(educacionDto.getTitulo()).get().getId() != id)
            return new ResponseEntity(new MensajeController("La educación no existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(educacionDto.getTitulo()))
            return new ResponseEntity(new MensajeController("El título de la educación es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = educacionService.getEdu(id).get();
        educacion.setAnio(educacionDto.getAnio());
        educacion.setTitulo(educacionDto.getTitulo());
        educacion.setInstitucion(educacionDto.getInstitucion());
        educacionService.save(educacion);
        
        return new ResponseEntity(new MensajeController("La educación fue actualizada correctamente"), HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarEdu(@PathVariable("id") int id){
        if(!educacionService.existsById(id))
            return new ResponseEntity(new MensajeController("La educación no existe"), HttpStatus.BAD_REQUEST);    
        educacionService.delete(id);
        
        return new ResponseEntity(new MensajeController("La educación fue eliminada"), HttpStatus.OK);
    }
}
