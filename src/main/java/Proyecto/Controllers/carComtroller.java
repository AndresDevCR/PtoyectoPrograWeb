package Proyecto.Controllers;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import Proyecto.Models.Car;
import Proyecto.Services.CarServiceImp;

import java.nio.file.Files;

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
