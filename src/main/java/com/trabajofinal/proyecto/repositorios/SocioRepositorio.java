/*
 
 */
package com.trabajofinal.proyecto.repositorios;

import com.trabajofinal.proyecto.entidades.Socio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author VicMusic
 */
@Repository
public interface SocioRepositorio extends JpaRepository<Socio, Integer> {

    @Query("SELECT a from socio a WHERE a.activo = true ")
    public List<Socio> buscarSocio();

}
