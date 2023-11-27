package sergey.goit.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sergey.goit.exception.PasswordNotException;

import sergey.goit.exception.UserAlreadyException;
import sergey.goit.logic.UserRegistration;

@Controller
public class LoginController {

    private final UserRegistration userRegistration;

    public LoginController(UserRegistration userRegistration) {
        this.userRegistration = userRegistration;
    }

    @GetMapping("/note/login")
    public String singIn() {
        return "login";
    }

    @GetMapping("/note/regestre")
    public String regestre() {
        return "regestre";
    }

    @PostMapping("/note/regestre")
    public String saveNewUser(Model model,
                              @RequestParam(value = "username", required = false) String username,
                              @RequestParam(value = "password", required = false) String password,
                              @RequestParam(value = "confirmPassword", required = false) String confirmPassword) {
        try {
            userRegistration.registerNewUser(username, password, confirmPassword);
            return "redirect:/login";
        } catch (PasswordNotException e) {
            model.addAttribute("error", e.getMessage());
            return "regestre";
        } catch (UserAlreadyException e) {
            model.addAttribute("error", e.getMessage());
            return "regestre";
        }
    }
}