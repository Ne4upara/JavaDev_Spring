package sergey.goit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@EntityScan
public class GoitApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoitApplication.class, args);
    }
}