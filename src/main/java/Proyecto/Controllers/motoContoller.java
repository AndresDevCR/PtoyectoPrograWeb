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

import Proyecto.Models.Moto;
import Proyecto.Services.MotoServiceImp;

@Controller
public class motoContoller {

    @Autowired
    private MotoServiceImp motoService;

    @GetMapping("/admin/motos")
    public String admin(Model model) {
        var motos = motoService.getAllMotos();
        model.addAttribute("motos", motos);
        return "/admin/motos";
    }
}
