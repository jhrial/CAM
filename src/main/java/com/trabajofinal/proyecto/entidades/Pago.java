package com.trabajofinal.proyecto.entidades;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;



@Entity
public class Pago {
 @Id
 @GeneratedValue(generator = "uuid")
 @GenericGenerator(name = "uuid", strategy = "uuid2")   
 private String id;
 private Integer nsocio;
 private String idactividad;
 private Date fecha;
 private String periodo;  //formato mm-aaaa
 private boolean moroso;

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
     * @return the nsocio
     */
    public Integer getNsocio() {
        return nsocio;
    }

    /**
     * @param nsocio the nsocio to set
     */
    public void setNsocio(Integer nsocio) {
        this.nsocio = nsocio;
    }

    /**
     * @return the idactividad
     */
    public String getIdactividad() {
        return idactividad;
    }

    /**
     * @param idactividad the idactividad to set
     */
    public void setIdactividad(String idactividad) {
        this.idactividad = idactividad;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    /**
     * @return the periodo
     */
   

    /**
     * @return the moroso
     */
    public boolean isMoroso() {
        return moroso;
    }

    /**
     * @param moroso the moroso to set
     */
    public void setMoroso(boolean moroso) {
        this.moroso = moroso;
    }

    @Override
    public String toString() {
        return "Pago{" + "id=" + id + ", nsocio=" + nsocio + ", idactividad=" + idactividad + ", fecha=" + fecha + ", periodo=" + periodo + ", moroso=" + moroso + '}';
    }
 
    
    
}
