// Listing 2.15  Declaring a view controller

package tacos.web;

import org.springframework.context.annotation.Configuration;
import
    org.springframework.web.servlet.config.annotation.viewControllerRegistry
    ;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
	registry.addViewController("/").setViewName("home");
    }

}
