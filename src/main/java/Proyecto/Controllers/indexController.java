package Proyecto.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Proyecto.Services.AutoNuevoServiceImp;
import Proyecto.Services.AutoUsadoServiceImp;
import Proyecto.Services.CarServiceImp;
import Proyecto.Services.MotoServiceImp;

@Controller
public class indexController {

    @Autowired
    private CarServiceImp carService;

    @Autowired
    private MotoServiceImp motoService;

    @Autowired
    private AutoNuevoServiceImp autoNuevoService;

    @Autowired
    private AutoUsadoServiceImp autoUsadoService;

    @GetMapping("/")
    public String index(Model model) {
        var autos = carService.getAllCars();
        model.addAttribute("autos", autos);
        return "index";
    }

    @GetMapping("/Nuevos")
    public String nuevos(Model model) {
        var nuevos = autoNuevoService.getAllAutoNuevos();
        model.addAttribute("nuevos", nuevos);
        return "/client/nuevos";
    }

    @GetMapping("/Usados")
    public String usados(Model model) {
        var usados = autoUsadoService.getAllAutoUsados();
        model.addAttribute("usados", usados);
        return "/client/usados";
    }

    @GetMapping("/Motocicletas")
    public String motocicletas(Model model) {
        var motos = motoService.getAllMotos();
        model.addAttribute("motos", motos);
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
