package pl.noCompany.handlingApplicationsForFamilyBenefits;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AppController {

    @GetMapping()
    public String home() {
        return "home";
    }

    @GetMapping("/error")
    public String error404(){
        return "error404";
    }
}
