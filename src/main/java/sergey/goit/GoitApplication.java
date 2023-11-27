package sergey.goit;

import org.flywaydb.core.Flyway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sergey.goit.model.User;
import sergey.goit.repository.UserRepository;

@SpringBootApplication
public class GoitApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoitApplication.class, args);
    }

    @Bean
    public CommandLineRunner runFlyway(Flyway flyway, UserRepository users) {
        return args -> {
            flyway.migrate();
//            users.save(new User("admin", "admin", "ADMIN"));
        };
    }
}