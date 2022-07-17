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
public class adminController {

    @Autowired
    private CarServiceImp carService;

    @GetMapping("/admin")
    public String admin(Model model) {
        var autos = carService.getAllCars();
        model.addAttribute("autos", autos);
        return "/admin/admin";
    }

    @GetMapping("/admin/auto/new")
    public String newdata(Model model) {
        return "/admin/agregarCar";
    }

    @PostMapping("/admin/auto/add")
    public String add(Car car,
            @RequestParam("file") MultipartFile imagen) {
        if (!imagen.isEmpty()) {
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
        }
        carService.save(car);
        return "redirect:/admin/admin";
    }

    @GetMapping("/admin/auto/delete/{id}")
    public String delete(@PathVariable Long id) {
        Car car = carService.find(id);
        carService.delete(car);
        return "redirect:/admin/admin";
    }

    @GetMapping("/admin/auto/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Car car = carService.find(id);
        model.addAttribute("item", car);
        return "/admin/editarCar";
    }
}
