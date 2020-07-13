package net.unicon.iam.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
    @GetMapping("/")
    public String index(HttpServletRequest request, Model model) {
        request.getRemoteUser();
        model.addAttribute("request", request);
        return "env";
    }
}
