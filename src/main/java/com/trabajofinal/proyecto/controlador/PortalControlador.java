package src.main.java.com.trabajofinal.proyecto.controladores.controladores;

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

}