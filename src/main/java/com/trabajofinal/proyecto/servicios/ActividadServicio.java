/*
 
 */
package com.trabajofinal.proyecto.servicios;

import com.trabajofinal.proyecto.entidades.Actividad;
import com.trabajofinal.proyecto.repositorios.ActividadRepositorio;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author VicMusic
 */
@Service
public class ActividadServicio {

    @Autowired
    private ActividadRepositorio actividadrepositorio;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public Actividad guardarActividad(String actividad, float precio, boolean baja, Date fbaja) throws Exception {

        validar(actividad, precio);
        Actividad actividadG = new Actividad();

        actividadG.setActividad(actividad);
        actividadG.setPrecio(precio);
        actividadG.setBaja(true);
        actividadG.setFbaja(new Date());

        return actividadrepositorio.save(actividadG);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public Actividad altaActividad(String id) {

        Actividad actividadA = actividadrepositorio.getOne(id);
        actividadA.setBaja(true);

        return actividadrepositorio.save(actividadA);

    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public Actividad bajaActividad(String id) {

        Actividad actividadB = actividadrepositorio.getOne(id);
        actividadB.setBaja(false);

        return actividadrepositorio.save(actividadB);
    }

    @Transactional(readOnly = true)
    public List<Actividad> listarActividad() {
        return actividadrepositorio.buscarActividad();
    }

    public void validar(String actividad, Float precio) throws Exception {

        if (actividad == null || actividad.isEmpty() || actividad.contains("  ")) {
            throw new Exception();
        }

        if (precio == null) {
            throw new Exception();
        }

    }

}
