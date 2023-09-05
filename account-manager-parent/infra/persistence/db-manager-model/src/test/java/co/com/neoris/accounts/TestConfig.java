package co.com.neoris.accounts;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@EntityScan("co.com.neoris.accounts.entities")
@ComponentScan("co.com.neoris")
@EnableJpaRepositories(basePackages = {"co.com.neoris.accounts.repositories"})
public class TestConfig {
}
