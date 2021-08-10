/*
 
 */
package com.trabajofinal.proyecto.repositorios;

import com.trabajofinal.proyecto.entidades.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author VicMusic
 */
@Repository
public interface SocioRepositorio extends JpaRepository<Socio, String>{
    
}
