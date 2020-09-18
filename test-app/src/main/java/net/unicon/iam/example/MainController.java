package net.unicon.iam.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
    @GetMapping("/**")
    public String index(HttpServletRequest request, Model model) {
        model.addAttribute("request", request);
        return "env";
    }
}
