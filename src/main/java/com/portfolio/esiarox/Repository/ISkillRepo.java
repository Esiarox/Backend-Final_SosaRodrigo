/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.esiarox.Repository;

import com.portfolio.esiarox.Entity.Skill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Esiarox
 */
@Repository
public interface ISkillRepo extends JpaRepository<Skill, Integer>{
    public Optional<Skill> findByTitulo(String titulo);
    public boolean existsByTitulo(String titulo); 
}
