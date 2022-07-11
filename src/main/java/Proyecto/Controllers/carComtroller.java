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

    @GetMapping("/new")
    public String newdata(Model model) {
        return "";
    }

    @PostMapping("/add")
    public String add(Car car,
    @RequestParam("file") MultipartFile imagen) {
        Path directorio = Paths.get("src//main//resources//static//img");
        String ruta = directorio.toFile().getAbsolutePath();
        try {
            byte[] bytesImg = imagen.getBytes();
            Path rutaArchivo = Paths.get(ruta + "//" + imagen.getOriginalFilename());
            Files.write(rutaArchivo, bytesImg);
            car.setImage(imagen.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        carService.save(car);
        return "redirect:/";
    }
   
    

  
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
       Car car = carService.find(id);
         carService.delete(car);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Car car = carService.find(id);
        model.addAttribute("concierto", car);
        return "edit";
    }
    
}
