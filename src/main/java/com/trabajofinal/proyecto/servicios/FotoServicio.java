/*
 
 */
package com.trabajofinal.proyecto.servicios;

import com.trabajofinal.proyecto.entidades.Foto;
import com.trabajofinal.proyecto.errores.ExceptionService;
import com.trabajofinal.proyecto.repositorios.FotoRepositorio;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author VicMusic
 */
@Service
public class FotoServicio {
    
    @Autowired
    private FotoRepositorio fotorepositorio;
    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public Foto guardarFoto(String nombre, byte archivo, boolean activo) {
        
        Foto fotoG = new Foto();
        
        fotoG.setNombre(nombre);
        fotoG.setArchivo(archivo);
        fotoG.setActivo(true);
        
        return fotorepositorio.save(fotoG);
    }
    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public Foto altaFoto(String id) {
        
        Foto fotoA = fotorepositorio.getOne(id);
        fotoA.setActivo(true);
        
        return fotorepositorio.save(fotoA);
    }
    
    public void modificarFoto(String id, String nombre, byte archivo, boolean activo) throws Exception{
        Optional<Foto> respuesta = fotorepositorio.findById(id);
        if(respuesta.isPresent()){
            
            Foto fotoM = respuesta.get();
            fotoM.setNombre(nombre);
            fotoM.setArchivo(archivo);
            fotoM.setActivo(activo);
            
            fotorepositorio.save(fotoM);
        } else {
            throw new ExceptionService("No se encontró la Foto con el id ingresado.");
        }
            
        
        
        
    }
    
    
    
}
