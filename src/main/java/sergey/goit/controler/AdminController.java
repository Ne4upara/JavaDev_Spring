package sergey.goit.controler;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sergey.goit.model.Authority;
import sergey.goit.model.User;
import sergey.goit.repository.AuthorityRepository;
import sergey.goit.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/note")
public class AdminController {
    private final AuthorityRepository authorityRepository;

    private final UserRepository userRepository;

    public AdminController(AuthorityRepository authorityRepository, UserRepository userRepository) {
        this.authorityRepository = authorityRepository;
        this.userRepository = userRepository;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String adminList(Model model) {
        List<Authority> adminAuthorities = authorityRepository.findByAuthority();
        List<User> adminUsernames = adminAuthorities.stream()
                .map(Authority::getUser)
                .collect(Collectors.toList());
        model.addAttribute("adminUsernames", adminUsernames);
        return "admin_list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/block/{username}")
    public String block(@PathVariable String username) {
        Optional<User> byUsername = userRepository.findByUsername(username);
        byUsername.ifPresent(user -> {
            user.setEnabled(false);
            userRepository.save(user);
        });
        return "redirect:/note/admin";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/unblock/{username}")
    public String unblock(@PathVariable String username) {
        Optional<User> byUsername = userRepository.findByUsername(username);
        byUsername.ifPresent(user -> {
            user.setEnabled(true);
            userRepository.save(user);
        });
        return "redirect:/note/admin";
    }
}
