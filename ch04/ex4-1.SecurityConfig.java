// Listing 4.1  A barebones configuration class for Spring Security

package tacos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web
                        .configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web
                    .configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

}
