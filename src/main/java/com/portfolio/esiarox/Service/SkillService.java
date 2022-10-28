/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.esiarox.Service;

import com.portfolio.esiarox.Entity.Skill;
import com.portfolio.esiarox.Repository.ISkillRepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Esiarox
 */
@Service
@Transactional
public class SkillService {
    @Autowired
    ISkillRepo iSkillRepo;
    
    public List<Skill> listaSkill(){
        return iSkillRepo.findAll();
    }
    
    public Optional<Skill> getSkill(int id){
        return iSkillRepo.findById(id);
    }
    
    public Optional<Skill> getByTitulo(String titulo){
        return iSkillRepo.findByTitulo(titulo);
    }
    
    public void save(Skill skill){
        iSkillRepo.save(skill);
    }
    
    public void delete(int id){
        iSkillRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iSkillRepo.existsById(id);
    }
    
    public boolean existsByTitulo(String titulo){
        return iSkillRepo.existsByTitulo(titulo);
    }
}
