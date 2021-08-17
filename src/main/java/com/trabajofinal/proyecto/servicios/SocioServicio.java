/*
 
 */
package com.trabajofinal.proyecto.servicios;

import com.trabajofinal.proyecto.entidades.Pago;
import com.trabajofinal.proyecto.entidades.Socio;
import com.trabajofinal.proyecto.errores.ExceptionService;
import com.trabajofinal.proyecto.repositorios.SocioRepositorio;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author VicMusic
 */
@Service
public class SocioServicio {
    
    @Autowired
    private SocioRepositorio socioRepositorio;
    
    
    public List<Socio> listarSocio(){
        return (List<Socio>) socioRepositorio.findAll();
    }
    
   public Socio agregarSocio(Integer nSocio,String apellido,String nombre,
            Long dni,String sexo, String cuil,String tipo,Boolean estado,
            String domicilio,String telefono,String obraSocial,
            String idActividad, String telEmergencia, 
            String observaciones,String infoSanitaria,
            String idFoto, Pago inscripcion) throws ExceptionService {        
                 
                   
     validarDatos(nSocio,apellido,nombre,dni,sexo,cuil,tipo,estado,domicilio,
     telefono,obraSocial,idActividad,telEmergencia,observaciones,
     infoSanitaria,idFoto,inscripcion);
       
       Socio socio=new Socio();
                    
       socio.setNsocio(nSocio);          
       socio.setApellido(apellido);
       socio.setNombre(nombre);
       socio.setDni(dni);
       socio.setSexo(sexo);
       socio.setCuil(cuil);            
       socio.setTipo(tipo);
       socio.setEstado(estado);
       socio.setDomicilio(domicilio);
       socio.setTelefono(telefono);
       socio.setOsocial(obraSocial);
       socio.setIdactividad(idActividad);
       socio.setTelemergencia(telEmergencia);
       socio.setObservaciones(observaciones); 
       socio.setInfosanitaria(infoSanitaria);
       socio.setFalta(new Date());
       socio.setIdfoto(idFoto);
       socio.setInscripcion(inscripcion);      
       
                        
       return socioRepositorio.save(socio);
   }   
   
     @Transactional
    public void modificarSocio(Integer id, String apellido, String nombre,
            String tipo, Boolean estado, String domicilio, String telefono,
            String obraSocial, String telEmergencia, String observaciones,
            String infoSanitaria, String idFoto) throws ExceptionService {

        Optional<Socio> respuesta = socioRepositorio.findById(id);
        if (respuesta.isPresent()) {

            Socio socio = respuesta.get();
            socio.setApellido(apellido);
            socio.setNombre(nombre);           
            socio.setTipo(tipo);
            socio.setEstado(estado);
            socio.setDomicilio(domicilio);
            socio.setTelefono(telefono);
            socio.setOsocial(obraSocial);
            socio.setTelemergencia(telEmergencia);
            socio.setObservaciones(observaciones);
            socio.setInfosanitaria(infoSanitaria);
            socio.setIdfoto(idFoto);
            

            socioRepositorio.save(socio);

        } else {

            throw new ExceptionService("No se encontró el socio con el id ingresado.");
        }

    }

    
     @Transactional
     public void habilitarSocio(Integer id) throws ExceptionService {

        Optional<Socio> respuesta = socioRepositorio.findById(id);
        if (respuesta.isPresent()) {

           Socio socio=respuesta.get();
           socio.setFalta(new Date());
           socioRepositorio.save(socio);

        } else {

            throw new ExceptionService("No se encontró el socio con el id ingresado.");
        }

    }

     @Transactional
     public void deshabilitarSocio(Integer id) throws ExceptionService {

        Optional<Socio> respuesta = socioRepositorio.findById(id);
        if (respuesta.isPresent()) {

           Socio socio=respuesta.get();
           socio.setFbaja(new Date());
           socioRepositorio.save(socio);

        } else {

            throw new ExceptionService("No se encontró el socio con el id ingresado.");
        }

    }

       
    
    
   
    private void validarDatos (Integer nSocio,String apellido,String nombre,
            
            Long dni,String sexo, String cuil,String tipo,Boolean estado,
            String domicilio,String telefono,String obraSocial,
            String idActividad, String contEmergencia, 
            String observaciones,String infoSanitaria, 
            String idFoto, Pago inscripcion)throws ExceptionService {
           
         
        
         if (nSocio == null ) {
            throw new ExceptionService("El número de socio no puede ser nulo.");
            
        }
            
         if (apellido == null || apellido.isEmpty()) {
            throw new ExceptionService("El apellido no puede ser nulo.");

        }

        if (nombre == null || nombre.isEmpty()) {
            throw new ExceptionService("El nombre no puede ser nulo.");

        }
        
         if (dni == null ) {
            throw new ExceptionService("El DNI no puede ser nulo.");
            
        }
         
         
          if (sexo == null || nombre.isEmpty()) {
            throw new ExceptionService("El sexo no puede ser nulo.");

        }
         
          if (cuil == null || nombre.isEmpty()) {
            throw new ExceptionService("El CUIL no puede ser nulo.");

        }
          
           if (tipo == null || nombre.isEmpty()) {
            throw new ExceptionService("El tipo no puede ser nulo.");

        }
          
           if (estado == null ) {
            throw new ExceptionService("El estado no puede ser nulo.");

        }
                          
        if (domicilio == null || domicilio.isEmpty()) {
            throw new ExceptionService("La dirección no puede ser nula.");
        }

        if (telefono == null || telefono.isEmpty()) {
            throw new ExceptionService("El teléfono no puede ser nulo.");

        }

        
            if (obraSocial == null || obraSocial.isEmpty()) {
            throw new ExceptionService("La obra social no puede ser nula.");
        }

        if (idActividad == null || idActividad.isEmpty()) {
            throw new ExceptionService("Debe indicar el id de la actividad.");

        }
        
           if (contEmergencia == null || contEmergencia.isEmpty()) {
            throw new ExceptionService("El teléfono de emergencia no puede ser nulo.");

        }

              
        
           if (infoSanitaria == null || infoSanitaria.isEmpty()) {
            throw new ExceptionService("Debe indicar la información sanitaria.");

        }
        
            if (inscripcion == null) {
            throw new ExceptionService("Debe registrar el pago de la inscripción.");

        }
   
   
}
}
