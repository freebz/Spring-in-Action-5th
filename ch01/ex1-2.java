// Listing 1.2  The Taco Cloud bootstrap class

package tacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TacoCloudApoplication {

    public static void main(String[] args) {
	SpringApplication.run(TacoCloudApplication.class, args);
    }

}
