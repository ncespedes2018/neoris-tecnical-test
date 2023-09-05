package co.com.neoris.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("co.com.neoris.accounts.entities")
@ComponentScan("co.com.neoris")
@EnableJpaRepositories(basePackages = {"co.com.neoris.accounts.repositories"})
public class MainClass {

    public static void main(String[] args) {
        SpringApplication.run(MainClass.class, args);
    }

}
