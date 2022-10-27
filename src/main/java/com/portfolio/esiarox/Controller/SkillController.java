/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.esiarox.Controller;

import com.portfolio.esiarox.Dto.SkillDto;
import com.portfolio.esiarox.Entity.Skill;
import com.portfolio.esiarox.Security.Controller.MensajeController;
import com.portfolio.esiarox.Service.SkillService;
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
@RequestMapping("/skill")
@CrossOrigin(origins = "http://localhost:4200")
public class SkillController {
    @Autowired
    SkillService skillService;
    
    @GetMapping("/buscarSkill")
    public ResponseEntity<List<Skill>> listaSkill(){
        List<Skill> listaSkill = skillService.listaSkill();
        return new ResponseEntity(listaSkill, HttpStatus.OK);
    }
    
    @GetMapping("/skill/{id}")
    public ResponseEntity<Skill> getSkillById(@PathVariable("id") int id){
        if(!skillService.existsById(id))
            return new ResponseEntity(new MensajeController("no existe"), HttpStatus.NOT_FOUND);
        Skill skill = skillService.getSkill(id).get();

        return new ResponseEntity(skill, HttpStatus.OK);
    }
    
    @PostMapping("/crearSkill")
    public ResponseEntity<?> crearSkill(@RequestBody SkillDto skillDto){
        if(StringUtils.isBlank(skillDto.getTitulo()))
            return new ResponseEntity(new MensajeController("El título de la habilidad es obligatorio"), HttpStatus.BAD_REQUEST);
        if(skillService.existsByTitulo(skillDto.getTitulo()))
            return new ResponseEntity(new MensajeController("Esta habilidad ya existe"), HttpStatus.BAD_REQUEST);
        Skill skill = new Skill(skillDto.getTitulo(),skillDto.getNivel());
        skillService.save(skill);
        
        return new ResponseEntity(new MensajeController("La skill fue agregada correctamente"), HttpStatus.OK);
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarSkill(@PathVariable("id") int id,@RequestBody SkillDto skillDto){
        if(!skillService.existsById(id))
            return new ResponseEntity(new MensajeController("La habilidad no existe"), HttpStatus.BAD_REQUEST);
        if(skillService.existsByTitulo(skillDto.getTitulo()) && 
                skillService.getByTitulo(skillDto.getTitulo()).get().getId() != id)
            return new ResponseEntity(new MensajeController("La habilidad no existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(skillDto.getTitulo()))
            return new ResponseEntity(new MensajeController("El título de la habilidad es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Skill skill = skillService.getSkill(id).get();
        skill.setTitulo(skillDto.getTitulo());
        skill.setNivel(skillDto.getNivel());
        skillService.save(skill);
        
        return new ResponseEntity(new MensajeController("La skill fue actualizada correctamente"), HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarSkill(@PathVariable("id") int id){
        if(!skillService.existsById(id))
            return new ResponseEntity(new MensajeController("La habilidad no existe"), HttpStatus.BAD_REQUEST);    
        skillService.delete(id);
        
        return new ResponseEntity(new MensajeController("La skill fue eliminada"), HttpStatus.OK);
    }
}
