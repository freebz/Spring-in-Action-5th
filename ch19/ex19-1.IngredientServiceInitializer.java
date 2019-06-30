// Listing 19.1  Enabling Spring web applications via Java

package tacos.ingredients;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

public class IngredientServiceServletInitializer
       extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(
	                            SpringApplicationBuilder builder) {
	return builder.sources(IngredientServiceApplication.class);
    }
}
