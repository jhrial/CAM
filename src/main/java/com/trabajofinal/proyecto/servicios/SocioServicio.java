/*
 
 */
package com.trabajofinal.proyecto.servicios;

import com.trabajofinal.proyecto.entidades.Pago;
import com.trabajofinal.proyecto.entidades.Socio;
import com.trabajofinal.proyecto.errores.ExceptionService;
import com.trabajofinal.proyecto.repositorios.SocioRepositorio;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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

       
       public Socio buscarPorNumeroSocio(Integer nSocio) throws ExceptionService {

        Socio socio = socioRepositorio.findByNSocio(nSocio).get();

        if (socio == null) {

            throw new ExceptionService("No se encontró el socio.");

        }

        return socio;

    }

       
       public Double calcularDeudaSocio(String idSocio)throws ExceptionService {
        
        Socio socio = socioRepositorio.findById(idSocio).get();
        Double deuda = null;
        List <Pago> pagos=pagoRepositorio.buscarPagosMorosos(idSocio);
        int cantPagosAdeudados= pagos.size();
        
        Date hoy=new Date();
        GregorianCalendar fecha=new GregorianCalendar ();
        fecha.setTime(hoy);
        int diaActual=fecha.get(Calendar.DATE);
            if (cantPagosAdeudados==0){
                
                throw new ExceptionService ("El socio no registra deuda.");
                
            }
          if (cantPagosAdeudados>0){
                  double cuota=socio.getActividad().getPrecio();
                  deuda = cantPagosAdeudados * cuota;
                  
                   if ((cantPagosAdeudados ==3)&&(diaActual>15)) {
                
                   deshabilitarSocio(idSocio);
                

            }
                 
                 
             }                           
           
      return deuda;
        }   
          
        public Double calcularDeudaTodosSocios2() {
        Double deudaTotal = null;
        List<Pago> todasLasDeudas = pagoRepositorio.buscarDeudaTodos();
        for (Pago deuda : todasLasDeudas) {
            deudaTotal += deuda.getMonto();

        }

        return deudaTotal;

    }   
        
        
        
        public  List <Pago> verTodasLasDeudas (){
            
            
           return pagoRepositorio.buscarDeudaTodos(); 
        }
        
        
        
        
   public int contarSocios (){
   int cantSocios=0;
   List <Socio> socios= socioRepositorio.findAll(); 
   cantSocios=socios.size();
               
return cantSocios;
            }

   
   

  public Socio buscarSocioPorID (String id) throws ExceptionService {
       
       Socio socio=socioRepositorio.findById(id).get();
       if (socio==null){
             throw new ExceptionService("No se encontró el socio.");
                }

   return socio;
}

  
   public Socio buscarSocioPorDni (Long dni) throws ExceptionService {
       
       Socio socio=socioRepositorio.findByDni(dni).get();
       if (socio==null){
             throw new ExceptionService("No se encontró el socio.");
                }

   return socio;
}
  
        
  
   
        
      
     
    
      
       public List<Socio> listarSocios() throws ExceptionService {
        List<Socio> socios = socioRepositorio.findAll();
        if (socios == null) {
            throw new ExceptionService("No existen socios para mostrar.");

        }

        return socios;
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
