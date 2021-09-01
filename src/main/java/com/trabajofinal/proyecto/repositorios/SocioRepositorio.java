package com.trabajofinal.proyecto.repositorios;

import com.trabajofinal.proyecto.entidades.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 *
 * @author VicMusic
 */
@Repository
public interface SocioRepositorio extends JpaRepository<Socio, Integer>{
    
    @Query("SELECT a from socio a WHERE a.activo LIKE :nsocio AND a.activo = true")
    public Socio buscarActividad(@Param("nsocio") Integer nsocio); 
    
}
