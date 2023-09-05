package co.com.neoris.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("co.com.neoris.users.entities")
@ComponentScan("co.com.neoris")
@EnableJpaRepositories(basePackages = {"co.com.neoris.users.repositories"})
public class MainUsersClass {

    public static void main(String[] args) {
        SpringApplication.run(MainUsersClass.class, args);
    }

}
