package com.trabajofinal.proyecto.entidades;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;


@Entity
public class Actividad {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String actividad;
    private float precio;
    private boolean baja;
    private Date fbaja;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the actividad
     */
    public String getActividad() {
        return actividad;
    }

    /**
     * @param actividad the actividad to set
     */
    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    /**
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * @return the baja
     */
    public boolean isBaja() {
        return baja;
    }

    /**
     * @param baja the baja to set
     */
    public void setBaja(boolean baja) {
        this.baja = baja;
    }

    /**
     * @return the fbaja
     */
    public Date getFbaja() {
        return fbaja;
    }

    /**
     * @param fbaja the fbaja to set
     */
    public void setFbaja(Date fbaja) {
        this.fbaja = fbaja;
    }

    @Override
    public String toString() {
        return "Actividad{" + "id=" + id + ", actividad=" + actividad + ", precio=" + precio + ", baja=" + baja + ", fbaja=" + fbaja + '}';
    }
    
    
}