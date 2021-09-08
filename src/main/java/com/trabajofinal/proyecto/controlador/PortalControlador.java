package com.trabajofinal.proyecto.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
       

public class PortalControlador {
    @GetMapping("/")
    public String index (){
        return "index.html";
    }
    
     @GetMapping("/socio")
    public String socio (){
        return "socio.html";
    }
    
     @GetMapping("/login")
    public String login (){
        return "login.html";
    }

   @GetMapping("/actividades")
    public String actividades (){
        return "actividades.html";
    }

   @GetMapping("/galeria")
    public String galeria (){
        return "galeria.html";
    }
    
  @GetMapping("/registro")
    public String registro (){
        return "registro.html";
    }  
    
    // https://www.youtube.com/watch?v=Aa2d1GNnFcU
    //  https://www.youtube.com/watch?v=mg6o03IS8JU&list=RDCMUCZt7KNv5lZ8DOTFhugllMEg&start_radio=1
    
    
    

}