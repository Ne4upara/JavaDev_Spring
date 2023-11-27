package sergey.goit.logic;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sergey.goit.exception.PasswordNotException;
import sergey.goit.exception.UserAlreadyException;
import sergey.goit.model.Authority;
import sergey.goit.model.User;
import sergey.goit.repository.AuthorityRepository;
import sergey.goit.repository.UserRepository;


@Service
public class UserRegistration {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthorityRepository authorityRepository;

    public UserRegistration(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityRepository = authorityRepository;
    }

    public void registerNewUser(String username, String password, String confirmPassword) throws PasswordNotException {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new UserAlreadyException("Username is already taken");
        }
        validatePassword(password, confirmPassword);
        User user = new User(username, String.valueOf(passwordEncoder.encode(password)), true);
        userRepository.save(user);
        Authority authority = new Authority(user, "ROLE_USER");
        authorityRepository.save(authority);
    }

    public boolean validatePassword(String password, String confirmPassword) throws PasswordNotException {
        if (StringUtils.isEmpty(password)) {
            throw new PasswordNotException("Password cannot be empty.");
        }
        if (!password.equals(confirmPassword)) {
            throw new PasswordNotException("Passwords do not match.");
        }
        return true;
    }
}
