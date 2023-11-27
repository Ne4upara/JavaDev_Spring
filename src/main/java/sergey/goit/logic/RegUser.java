package sergey.goit.logic;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sergey.goit.exception.PasswordNotException;
import sergey.goit.exception.UserAlreadyException;
import sergey.goit.model.User;
import sergey.goit.repository.UserRepository;

@Service
public class RegUser {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    public RegUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerNewUser (String username, String password, String passwordTwo) throws PasswordNotException {
        if (userRepository.findByUsername(username).isPresent()){
            throw new UserAlreadyException("Username is already taken");
        }
        password(password, passwordTwo);
        User user = new User(username, String.valueOf(passwordEncoder.encode(password)));
        return userRepository.save(user);
    }

    public boolean password (String one, String two) throws PasswordNotException {
        if (StringUtils.isEmpty(one)){
            throw new PasswordNotException("Password cannot be empty.");
            }
        if (!one.equals(two)) {
            throw new PasswordNotException("Passwords do not match.");
        }
        return true;
    }
}
