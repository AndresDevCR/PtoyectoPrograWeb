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

import Proyecto.Models.AutoUsado;
import Proyecto.Services.AutoUsadoServiceImp;

@Controller
public class usadosContoller {

    @Autowired
    private AutoUsadoServiceImp usadosService;

    @GetMapping("/admin/usados")
    public String adminAutoUsados(Model model) {
        var usados = usadosService.getAllAutoUsados();
        model.addAttribute("usados", usados);
        return "/admin/usados";
       
    }

    @GetMapping("/admin/usados/new")
    public String newdata(Model model) {
        return "/admin/agregarAutoUsado";
    }

    @PostMapping("/admin/usados/add")
    public String add(AutoUsado usados,
            @RequestParam("file") MultipartFile imagen) {
        if (!imagen.isEmpty()) {
            Path directorio = Paths.get("src//main//resources//static//img");
            String ruta = directorio.toFile().getAbsolutePath();
            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutaArchivo = Paths.get(ruta + "//" + imagen.getOriginalFilename());
                Files.write(rutaArchivo, bytesImg);
                usados.setImage(imagen.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        usadosService.save(usados);
        return "redirect:/admin/usados";
    }

    @GetMapping("/admin/usados/delete/{id}")
    public String delete(@PathVariable Long id) {
        AutoUsado usados = usadosService.find(id);
        usadosService.delete(usados);
        return "redirect:/admin/usados";
    }

    @GetMapping("/admin/usados/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        AutoUsado usados = usadosService.find(id);
        model.addAttribute("item", usados);
        return "/admin/editarAutoUsado";
    }
}
