package com.trabajofinal.proyecto.repositorios;

import com.trabajofinal.proyecto.entidades.Pago;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepositorio extends JpaRepository<Pago, String> {
    //Resumen de Cuenta del Socio
    @Query("SELECT a from pago a WHERE a.nsocio LIKE :socio AND a.baja = false")
    public List<Pago> buscarPago(@Param("nsocio") Integer nsocio); 
    //Ultimo pago realizado
    @Query("SELECT a from pago a WHERE a.nsocio LIKE :socio AND a.baja = false  order by periodo desc limit 1")
    public Pago buscarUltimoPago(@Param("nsocio") Integer nsocio); 
    //Calcular deuda de todos los socios
    @Query("SELECT a from pago a WHERE a.baja = false")
    public List<Pago> buscarPago(); 
    
}
