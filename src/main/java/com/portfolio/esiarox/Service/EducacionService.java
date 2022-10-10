/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.esiarox.Service;

import com.portfolio.esiarox.Entity.Educacion;
import com.portfolio.esiarox.Repository.IEducacionRepo;
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
public class EducacionService {
    @Autowired
    IEducacionRepo iEducacionRepo;
    
    public List<Educacion> listaEdu(){
        return iEducacionRepo.findAll();
    }
    
    public Optional<Educacion> getEdu(int id){
        return iEducacionRepo.findById(id);
    }
    
    public Optional<Educacion> getByTitulo(String titulo){
        return iEducacionRepo.findByTitulo(titulo);
    }
    
    public void save(Educacion experiencia){
        iEducacionRepo.save(experiencia);
    }
    
    public void delete(int id){
        iEducacionRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iEducacionRepo.existsById(id);
    }
    
    public boolean existsByTitulo(String titulo){
        return iEducacionRepo.existsByTitulo(titulo);
    }
}
