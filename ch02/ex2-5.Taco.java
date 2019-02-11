// Listing 2.5  A domain object defining a taco design

package tacos;
import java.util.List;
import lombok.Data;

@Data
public class Taco {

    private String name;
    private List<String> ingredients;

}
