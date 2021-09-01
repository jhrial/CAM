/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabajofinal.proyecto.errores;

/**
 *
 * @author Melisa
 */
public class ExceptionService extends Exception {
    
    public ExceptionService (String mensajeError){
        
        super(mensajeError);
        
        
    }
    
}
