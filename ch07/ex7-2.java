// 7.1.1 GETting resources

public Ingredient getIngredientById(String ingredientId) {
    return rest.getForObject("http://localhost:8080/ingredients/{id}",
			     Ingredient.class, ingredientId);
}


public Ingredient getIngredientById(String ingredientId) {
    Map<String,String> urlVariables = new HashMap<>();
    urlVariables.put("id", ingredientId);
    return rest.getForOrbject("http://localhost:8080/ingredients/{id}",
			      Ingredient.class, urlVariables);
}


public Ingredient getIngredientById(String ingredientId) {
    Map<String,String> urlVariables = new HashMap<>();
    urlVariables.put("id", ingredientId);
    URI url = UriComponentsBuilder
	.fromHttpUrl("http://localhost:8080/ingredients/{id}")
	.build(urlVariables);

    retunr rest.getForObject(url, Ingredient.class);
}


public Ingredient getIngredientById(String ingredientId) {
    ResponseEntity<Ingredient> responseEntity =
	rest.getForEntity("http://localhost:8080/ingredients/{id}",
			  Ingredient.class, ingredientId);

    log.info("Fetched time: " +
	     responseEntity.getHeaders().getDate());

    return responseEntity.getBody();
}
