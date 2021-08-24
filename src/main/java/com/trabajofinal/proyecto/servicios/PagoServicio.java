/*
 Actividades que se realizan al hacer un pago

preguntas

se paga una membresia y que pasa con las actividades.
que sucede con los socio deudor

Victor
 */
package com.trabajofinal.proyecto.servicios;

import com.trabajofinal.proyecto.entidades.Actividad;
import com.trabajofinal.proyecto.entidades.Pago;
import com.trabajofinal.proyecto.entidades.Socio;
import com.trabajofinal.proyecto.repositorios.ActividadRepositorio;
import com.trabajofinal.proyecto.repositorios.PagoRepositorio;
import com.trabajofinal.proyecto.repositorios.SocioRepositorio;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 *
 * @author VicMusic
 */
@Service
public class PagoServicio {
    @Autowired
     PagoRepositorio pagoRepositorio;
    @Autowired
     ActividadRepositorio actividadRepositorio;
    @Autowired
     SocioRepositorio socioRepositorio;
    


public void registrarPago (Integer nSocio,String periodo, String idActividad){
    Actividad actividad= actividadRepositorio.findById(idActividad);
    String nombreAct=actividad.getNombre();
    Socio socio=findByNsocio(nSocio).get();
    Date hoy=new Date();
    Pago pagoAdeudado= pagoRepositorio.findPagosAdeudadosPorPeriodo(nSocio);
        if (pagoAdeudado!=null) {

                 pagoAdeudado.setMoroso(false);
                 pagoAdeudado.setFecha(hoy);
                 pagoRepositorio.save(pagoAdeudado);
  
            }else{
    
    
    Pago pago= new Pago();
    pago.setnSocio(nSocio);
    pago.setActividad(nombreAct);
    pago.setFecha(hoy);
    pago.setPeriodo(periodo);
    pago.setMonto(actividad.getPrecio());
    pago.setMoroso(false);
    socio.getPagos().add(pago);
    pagoRepositorio.save(pago);

      }

     
}   
       
           
    public void registrarPeriodosImpagos(String idSocio) {

        List<Pago> deudas = new ArrayList();

        Socio socio = socioRepositorio.findById(idSocio);
        Pago pago ultimoPago = pagoRepositorio.buscarUltimoPago(idSocio);

        Date hoy= new Date();
        GregorianCalendar fecha=new GregorianCalendar();
        fecha.setTime(hoy);
        int mesActual=fecha.get(Calendar.MONTH);

        String ultimoPeriodoPagado = ultimoPago.getPeriodo();
        String soloMes= ultimoPeriodoPagado.substring(0,2);
        int ultimoMesPagado=Integer.valueOf(soloMes);
        
        
        int diferenciaMeses = mesActual - ultimoMesPagado;
        if (diferenciaMeses > 0) {
            String actividad = socio.getActividad().getId();
            Integer nSocio = socio.getnSocio();
 
        
           for (int i = ultimoMesPagado + 1; i <= mesActual; i++) {
            String periodo = i + "/21";
            registrarDeuda(idSocio,nSocio,periodo,actividad);
//            Pago deuda = new Pago();
//            deuda.setPeriodo(periodo);
//            deuda.setFecha(new Date());
//            deuda.setMoroso(true);
//            deuda.setnSocio(nSocio);
//            deuda.setActividad(actividad);
//            pagoRepositorio.save(deuda);

//            socio.getPagos().add(deuda);

        }
        
                 
       
        } 
        
        
    }
        

  public void registrarDeuda(String IdSocio,Integer nSocio,String periodo, String idActividad){
    Actividad a= actividadRepositorio.findById(idActividad);
    Socio socio=socioRepositorio.findById (IdSocio).get();
       
    Pago pago= new Pago();
    pago.setnSocio(nSocio);
    pago.setActividad(a.getNombre());
    pago.setPeriodo(periodo);
    pago.setMonto(a.getPrecio());
    pago.setMoroso(true);
    pagoRepositorio.save(pago);
    socio.getPagos().add(pago);
    
             }


    public List <Pago> listarPagos(){
           
          List pagos = pagoRepositorio.buscarTodosLosPagos();

          return pagos;

          }

 
    
    
    
    
    
    
    
    
}
