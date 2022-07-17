package Proyecto.Controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import Proyecto.Models.AutoNuevo;
import Proyecto.Services.AutoNuevoServiceImp;

@Controller
public class nuevosContoller {

    @Autowired
    private AutoNuevoServiceImp nuevosService;

    @GetMapping("/admin/nuevos")
    public String adminAutoNuevos(Model model) {
        var nuevos = nuevosService.getAllAutoNuevos();
        model.addAttribute("nuevos", nuevos);
        return "/admin/nuevos";
       
    }

    @GetMapping("/admin/nuevos/new")
    public String newdata(Model model) {
        return "/admin/agregarAutoNuevo";
    }

    @PostMapping("/admin/nuevos/add")
    public String add(AutoNuevo nuevos,
            @RequestParam("file") MultipartFile imagen) {
        if (!imagen.isEmpty()) {
            Path directorio = Paths.get("src//main//resources//static//img");
            String ruta = directorio.toFile().getAbsolutePath();
            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutaArchivo = Paths.get(ruta + "//" + imagen.getOriginalFilename());
                Files.write(rutaArchivo, bytesImg);
                nuevos.setImage(imagen.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        nuevosService.save(nuevos);
        return "redirect:/admin/nuevos";
    }

    @GetMapping("/admin/nuevos/delete/{id}")
    public String delete(@PathVariable Long id) {
        AutoNuevo nuevos = nuevosService.find(id);
        nuevosService.delete(nuevos);
        return "redirect:/admin/nuevos";
    }

    @GetMapping("/admin/nuevos/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        AutoNuevo nuevos = nuevosService.find(id);
        model.addAttribute("item", nuevos);
        return "/admin/editarAutoNuevo";
    }
}
