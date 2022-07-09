package Proyecto.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdministratorController {
    
    @RequestMapping("/administrator") 
    @GetMapping("/administrator")
    public String index() {
        return "index";
    }
    
}
