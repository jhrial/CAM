package com.trabajofinal.proyecto.repositorios;

import com.trabajofinal.proyecto.entidades.Actividad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author VicMusic
 */
public interface ActividadRepositorio extends JpaRepository<Actividad, String> {
   // @Query("SELECT a from actividad a WHERE a.actividad LIKE :actividad AND a.baja = false")
    // public List<Actividad> buscarActividad(@Param("actividad") String actividad); 
    

}
