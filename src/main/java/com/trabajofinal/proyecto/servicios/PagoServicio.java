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
    

 public void registrarPeriodosAdeudados(Integer nsocio) {            //GENERA REGISTROS DE PERIODOS IMPAGOS (SE CONSULTAN 

        Socio socio = socioRepositorio.buscarSocio(nsocio);                   // EN LA BBDD PARA MOSTRAR UNA TABLA)                  

        Pago ultimoPago = pagoRepositorio.buscarUltimoPago(nsocio);

        Actividad actividad = socio.getActividad(); 

        double monto=actividad.getPrecio();

        
        //Manejo de fechas con clase Date.

        Date periodo=new Date();
        GregorianCalendar fecha=new GregorianCalendar();
        fecha.setTime(hoy);
        int mesActual=fecha.get(Calendar.MONTH);
        int anioActual= fecha.get(Calendar.YEAR);

        Date ultimoPeriodoPagado = ultimoPago.getPeriodo();
        fecha.setTime(ultimoPeriodoPagado);
        int ultimoMes=fecha.get(Calendar.MONTH);
        int ultimoAnio= fecha.get(Calendar.YEAR);


        //Manejo de fechas con clase LocalDate
        
        LocalDate hoy= LocalDate.now();
        int mesActual=hoy.getMonthValue();
        int anioActual=hoy.getYear();

        
        if(anioActual == ultimoAnio) {

            for (i=mesUltimoPago +1; i>= mesActual;i++){
                      
                      Pago pago=new Pago();
                                         
                      
                      LocalDate periodo= LocalDate.of(i, j, 00);      //anio=i,mes=j

                      Date periodoImpago=Date.valueOf(periodo);   //Recibe una fecha LocalDate y devuelve una Date

                      pago.setPeriodo(periodo);
                      pago.setNsocio(nSocio);
                      pago.setMonto(monto);
                      pago.setActividad(idActividad);
                      pago.setMoroso(true);

                      pagoRepositorio.save(deuda);

                      socio.getPagos().add(deuda);
                         
                             }
       }else {

                    for (i=ultimoAnio; i<= anioActual; i++) {

                             if(i==ultimoAnio){

                                    for (j=ultimoMes+1; j<= 12; j++){

                                         Pago pago=new Pago();
                                         mes=j;
                                         anio=i;


                                         LocalDate periodo= LocalDate.of(i, j, 00);      //anio=i,mes=j

                                         Date periodoImpago=Date.valueOf(periodo);   //Recibe una fecha LocalDate y devuelve una Date




                                         pago.setPeriodo(periodo);
                                         pago.setNsocio(nSocio);
                                         pago.setMonto(monto);
                                         pago.setActividad(idActividad);
                                         pago.setMoroso(true);
                                         pagoRepositorio.save(deuda);

                                        socio.getPagos().add(deuda);


                                                              
                                            }

                        
                          } else if (i== anioActual) {

                                      for(j=1;j<=mesActual;j++)){

                                         Pago pago=new Pago();

                                         mes=j;
                                         anio=i;

                                         LocalDate periodo= LocalDate.of(i, j, 00);      //anio=i,mes=j

                                         Date periodoImpago=Date.valueOf(periodo);   //Recibe una fecha LocalDate y devuelve una Date


                                         pago.setFecha(hoy);
                                         pago.setPeriodo(periodo);
                                         pago.setNsocio(nSocio);
                                         pago.setMonto(monto);
                                         pago.setActividad(idActividad);
                                         pago.setMoroso(true);

                                         pagoRepositorio.save(deuda);

                                         socio.getPagos().add(deuda);





                                           }


                                                         

          
                           }else {
                                     for (j=1;j<=12;j++) {
                                         Pago pago=new Pago();

                                         LocalDate periodo= LocalDate.of(i, j, 00);      //anio=i,mes=j

                                         Date periodoImpago=Date.valueOf(periodo);   //Recibe una fecha LocalDate y devuelve una Date


                                         pago.setPeriodo(periodo);
                                         pago.setNsocio(nSocio);
                                         pago.setMonto(monto);
                                         pago.setActividad(idActividad);
                                         pago.setMoroso(true);
                                         pagoRepositorio.save(deuda);

//                                       socio.getPagos().add(deuda);



                                         }

                                   }
        


                     }



     public List <Pago> consultarDeuda(Integer nSocio) {
          
             List <Pago> periodosImpagos= pagoRepositorio.buscarPeriodosImpagos(nSocio);


             return periodosImpagos;
        }



          
                 
   public void registrarPago (String idPago){
    
   Date hoy=new Date();
           
    Pago pago=pagoRepositorio.findById(idPago).get();    
    
    pago.setFecha(hoy);
    pago.setMoroso(false);
    socio.getPagos().add(pago);
    pagoRepositorio.save(pago);

      }

    


        public List <Pago> listarPagos(){
           
        List pagos = pagoRepositorio.buscarTodosLosPagos();

        return pagos;

          }

 
       
    
    
    
    
    
    
}