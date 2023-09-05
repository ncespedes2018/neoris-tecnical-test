package co.com.neoris.users;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@EntityScan("co.com.neoris.users.entities")
@ComponentScan("co.com.neoris")
@EnableJpaRepositories(basePackages = {"co.com.neoris.users.repositories"})
public class TestConfig {
}
