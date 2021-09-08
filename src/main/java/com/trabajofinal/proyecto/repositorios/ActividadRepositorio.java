package com.trabajofinal.proyecto.repositorios;

import com.trabajofinal.proyecto.entidades.Actividad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 *
 * @author VicMusic
 */
public interface ActividadRepositorio extends JpaRepository<Actividad, String> {
    
    @Query("SELECT a from actividad a WHERE a.activo = true ")
    public List<Actividad> buscarActividad();
    

}
