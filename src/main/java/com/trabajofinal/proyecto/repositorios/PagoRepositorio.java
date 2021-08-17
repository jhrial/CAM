/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabajofinal.proyecto.repositorios;

import com.trabajofinal.proyecto.entidades.Pago;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author VicMusic
 */
@Repository
public interface PagoRepositorio extends JpaRepository<Pago, String> {

    @Query("SELECT a from pago a WHERE a.activo = true ")
    public List<Pago> buscarPago();
}
