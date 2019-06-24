@SpringBootApplication
@EnableHystrix
public class IngredientServiceApplication {
    ...
}


public Iterable<Ingredient> getAllIngredients() {
    ParameterizedTypeReference<List<Ingredient>> stringList =
	new ParameterizedTypeReference<List<Ingredient>>() {};
    return rest.exchange(
	"http://ingredient-service/ingredients", HttpMethod.GET,
	HttpEntity.EMPTY, stringList).getBody();
}


@HystrixCommand(fallbackMethod="getDefaultIngredients")
public Iterable<Ingredient> getAllIngredients() {
    ...
}


private Iterable<Ingredient> getDefaultIngredients() {
    List<Ingredient> ingredients = new ArrayList<>();
    ingredients.add(new Ingredient(
			"FLTO", "Flour Tortilla", Ingredient.Type.WRAP));
    ingredients.add(new Ingredient(
			"GRBF", "Ground Beef", Ingredient.Type.PROTEIN));
    ingredients.add(new Ingredient(
			"CHED", "Shredded Cheddar", Ingredient.Type.CHEESE));
    return ingredients;
}
