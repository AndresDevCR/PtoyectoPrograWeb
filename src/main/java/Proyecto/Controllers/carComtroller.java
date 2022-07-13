package Proyecto.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import Proyecto.Services.CarServiceImp;

@Controller
public class carComtroller {

    @Autowired
    private CarServiceImp carService;

    @GetMapping("/")
    public String index(Model model) {
        var autos = carService.getAllCars();
        model.addAttribute("autos", autos);
        return "index";
    }
}
