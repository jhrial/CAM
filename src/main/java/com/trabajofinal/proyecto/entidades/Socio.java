package com.trabajofinal.proyecto.entidades;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Socio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Integer nsocio;
    private String apellido;
    private String nombre;
    private Long dni;
    private String sexo;
    private String cuil;
    private String tipo;
    private boolean estado;
    private String domicilio;
    private String telefono;
    private String osocial;
    private Date falta;
    private Date fbaja;
    private String idactividad;
    private String telemergencia;
    private String observaciones;
    private String infosanitaria;
    private String idfoto;
    private Pago inscripcion;

    public Pago getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Pago inscripcion) {
        this.inscripcion = inscripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
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
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the dni
     */
    public Long getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(Long dni) {
        this.dni = dni;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the cuil
     */
    public String getCuil() {
        return cuil;
    }

    /**
     * @param cuil the cuil to set
     */
    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * @return the domicilio
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * @param domicilio the domicilio to set
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the osocial
     */
    public String getOsocial() {
        return osocial;
    }

    /**
     * @param osocial the osocial to set
     */
    public void setOsocial(String osocial) {
        this.osocial = osocial;
    }

    /**
     * @return the falta
     */
    public Date getFalta() {
        return falta;
    }

    /**
     * @param falta the falta to set
     */
    public void setFalta(Date falta) {
        this.falta = falta;
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
     * @return the telemergencia
     */
    public String getTelemergencia() {
        return telemergencia;
    }

    /**
     * @param telemergencia the telemergencia to set
     */
    public void setTelemergencia(String telemergencia) {
        this.telemergencia = telemergencia;
    }

    /**
     * @return the observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * @param observaciones the observaciones to set
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * @return the infosanitaria
     */
    public String getInfosanitaria() {
        return infosanitaria;
    }

    /**
     * @param infosanitaria the infosanitaria to set
     */
    public void setInfosanitaria(String infosanitaria) {
        this.infosanitaria = infosanitaria;
    }

    /**
     * @return the idfoto
     */
    public String getIdfoto() {
        return idfoto;
    }

    /**
     * @param idfoto the idfoto to set
     */
    public void setIdfoto(String idfoto) {
        this.idfoto = idfoto;
    }

    @Override
    public String toString() {
        return "Socio{" + "id=" + id + ", nsocio=" + nsocio + ", apellido=" + apellido + ", nombre=" + nombre + ", dni=" + dni + ", sexo=" + sexo + ", cuil=" + cuil + ", tipo=" + tipo + ", estado=" + estado + ", domicilio=" + domicilio + ", telefono=" + telefono + ", osocial=" + osocial + ", falta=" + falta + ", fbaja=" + fbaja + ", idactividad=" + idactividad + ", telemergencia=" + telemergencia + ", observaciones=" + observaciones + ", infosanitaria=" + infosanitaria + ", idfoto=" + idfoto + ", inscripcion=" + inscripcion + '}';
    }

   
    
}