package Proyecto.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {

   @GetMapping("/Nuevos")
    public String nuevos() {
        return "nuevos";
    }

    @GetMapping("/Usados")
    public String usados() {
        return "usados";
    }

    @GetMapping("/Motocicletas")
    public String motocicletas() {
        return "motocicletas";
    }

    @GetMapping("/Alquiler")
    public String alquiler() {
        return "alquiler";
    }

    @GetMapping("/Contacto")
    public String contacto() {
        return "contacto";
    }

    @GetMapping("/Informacion")
    public String informacion() {
        return "informacion";
    }

    @GetMapping("/Talleres")
    public String talleres() {
        return "talleres";
    }




    
}
