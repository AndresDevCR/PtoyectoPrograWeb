package Proyecto.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Proyecto.Services.CarServiceImp;

@Controller
public class indexController {

    @Autowired
    private CarServiceImp carService;

    @GetMapping("/")
    public String index(Model model) {
        var autos = carService.getAllCars();
        model.addAttribute("autos", autos);
        return "index";
    }

    @GetMapping("/Nuevos")
    public String nuevos() {
        return "/client/nuevos";
    }

    @GetMapping("/Usados")
    public String usados() {
        return "/client/usados";
    }

    @GetMapping("/Motocicletas")
    public String motocicletas() {
        return "/client/motocicletas";
    }

    @GetMapping("/Alquiler")
    public String alquiler() {
        return "/client/alquiler";
    }

    @GetMapping("/Contacto")
    public String contacto() {
        return "/client/contacto";
    }

    @GetMapping("/Talleres")
    public String talleres() {
        return "/client/talleres";
    }

}
