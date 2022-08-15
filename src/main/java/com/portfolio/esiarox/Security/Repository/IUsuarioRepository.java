/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.esiarox.Security.Repository;

import com.portfolio.esiarox.Security.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Esiarox
 */
@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByUsuario(String usuario);
    
    boolean existByUsuario(String usuario);
    boolean existByEmail(String email);
}
