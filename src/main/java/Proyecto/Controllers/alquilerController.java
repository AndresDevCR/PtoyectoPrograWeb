package Proyecto.Controllers;

import java.io.IOException;
import java.nio.file.Files;
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

import Proyecto.Models.Alquiler;
import Proyecto.Services.AlquilerServiceImp;

@Controller
public class alquilerController {
    
    @Autowired
    private AlquilerServiceImp alquilerService;

    @GetMapping("/admin/alquiler")
    public String adminAlquilers(Model model) {
        var alquileres = alquilerService.getAllAlquileres();
        model.addAttribute("alquileres", alquileres);
        return "/admin/alquiler";
       
    }

    @GetMapping("/admin/alquiler/new")
    public String newdata(Model model) {
        return "/admin/agregarAlquiler";
    }

    @PostMapping("/admin/alquiler/add")
    public String add(Alquiler alquiler,
            @RequestParam("file") MultipartFile imagen) {
        if (!imagen.isEmpty()) {
            Path directorio = Paths.get("src//main//resources//static//img");
            String ruta = directorio.toFile().getAbsolutePath();
            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutaArchivo = Paths.get(ruta + "//" + imagen.getOriginalFilename());
                Files.write(rutaArchivo, bytesImg);
                alquiler.setImage(imagen.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        alquilerService.save(alquiler);
        return "redirect:/admin/alquiler";
    }

    @GetMapping("/admin/alquiler/delete/{id}")
    public String delete(@PathVariable Long id) {
        Alquiler alquiler = alquilerService.find(id);
        alquilerService.delete(alquiler);
        return "redirect:/admin/alquiler";
    }

    @GetMapping("/admin/alquiler/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Alquiler alquiler = alquilerService.find(id);
        model.addAttribute("item", alquiler);
        return "/admin/editarAlquiler";
    }
}