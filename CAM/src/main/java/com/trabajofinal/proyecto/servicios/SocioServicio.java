/*
 
 */
package com.trabajofinal.proyecto.servicios;

import com.trabajofinal.proyecto.entidades.Socio;
import com.trabajofinal.proyecto.repositorios.SocioRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author VicMusic
 */
@Service
public class SocioServicio {
    
    @Autowired
    private SocioRepositorio sociorepositorio;
    
    
    public List<Socio> listarSocio(){
       return (List<Socio>) sociorepositorio.findAll();
    }
    
    
}
