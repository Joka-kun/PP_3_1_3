package PP_3_1_3.controller;

import PP_3_1_3.model.User;
import PP_3_1_3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String show(Principal principal,Model model) {
        model.addAttribute("user", userService.findByUsername(principal.getName()));
        return "users/show";
    }
}
