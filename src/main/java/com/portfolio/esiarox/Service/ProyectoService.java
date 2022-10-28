/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.esiarox.Service;

import com.portfolio.esiarox.Entity.Proyecto;
import com.portfolio.esiarox.Repository.IProyectoRepo;
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
public class ProyectoService {
    @Autowired
    IProyectoRepo iProyectoRepo;
    
    public List<Proyecto> listaProy(){
        return iProyectoRepo.findAll();
    }
    
    public Optional<Proyecto> getProy(int id){
        return iProyectoRepo.findById(id);
    }
    
    public Optional<Proyecto> getByTitulo(String titulo){
        return iProyectoRepo.findByTitulo(titulo);
    }
    
    public void save(Proyecto proyecto){
        iProyectoRepo.save(proyecto);
    }
    
    public void delete(int id){
        iProyectoRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iProyectoRepo.existsById(id);
    }
    
    public boolean existsByTitulo(String titulo){
        return iProyectoRepo.existsByTitulo(titulo);
    }
}
