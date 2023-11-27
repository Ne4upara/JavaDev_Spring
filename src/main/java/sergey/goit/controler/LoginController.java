package sergey.goit.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sergey.goit.exception.PasswordNotException;
import sergey.goit.logic.RegUser;

@Controller
public class LoginController {

    private RegUser regUser;

    public LoginController(RegUser regUser) {
        this.regUser = regUser;
    }

    @GetMapping("/login")
    public String singIn (Model model){
        return "test";

    }

//    @PostMapping("/login")
//    public String loginOn(){
//
//    }

    @GetMapping("/reglogin")
    public String reglogin(){
        return "reglogin";
    }

    @PostMapping("/reglogin")
    public String saveUser(@RequestParam(value = "username", required = false) String username,
                           @RequestParam (value = "password", required = false) String password,
                           @RequestParam(value = "passwordtwo", required = false) String passwordtwo) throws PasswordNotException {
        regUser.registerNewUser(username, password, passwordtwo);

        return "redirect:/login";
    }




}


