package Proyecto.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import Proyecto.Services.AlquilerServiceImp;
import Proyecto.Services.AutoNuevoServiceImp;
import Proyecto.Services.AutoUsadoServiceImp;
import Proyecto.Services.CarServiceImp;
import Proyecto.Services.MotoServiceImp;
import lombok.var;

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

    @Autowired
    private AlquilerServiceImp alquilerService;

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

    // show cars by id
    @GetMapping("/auto/{id}")
    public String show(@PathVariable Long id, Model model) {
        var car = carService.find(id);
        model.addAttribute("car", car);
        return "/client/auto";
    }

    @GetMapping("/Alquiler")
    public String adminAlquilers(Model model) {
        var alquileres = alquilerService.getAllAlquileres();
        model.addAttribute("alquileres", alquileres);
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
