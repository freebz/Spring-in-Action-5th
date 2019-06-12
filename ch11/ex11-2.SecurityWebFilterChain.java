// Listing 11.2  Confiuring Spring Security for a Spring WebFlux application

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(
	                                     ServerHttpSecurity http) {
	return http
	  .authorizeExchange()
	    .pathMatchers("/design", "/orders").hasAuthority("USER")
	    .anyExchange().permitAll()
	  .and()
	    .build();
    }

}
