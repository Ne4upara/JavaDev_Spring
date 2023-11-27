package sergey.goit;

import org.flywaydb.core.Flyway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GoitApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoitApplication.class, args);
    }

    @Bean
    public CommandLineRunner runFlyway(Flyway flyway) {
        return args ->
                flyway.migrate();
    }
}