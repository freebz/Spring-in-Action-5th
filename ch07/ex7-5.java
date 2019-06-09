// 7.1.4 POSTing resource data

public Ingredient createIngredient(Ingredient ingredient) {
    return rest.postForObject("http://localhost:8080/ingredients",
			      ingredient,
			      Ingredient.class);
}


public URI createIngredient(Ingredient ingredient) {
    return rest.postForLocation("http://localhost:8080/ingredients",
				ingredient);
}


public Ingredient createIngredient(Ingredient ingredient) {
    ResponseEntity<Ingredient> responseEntity =
	rest.postForEntity("http://localhost:8080/ingredients",
			   ingredient,
			   Ingredient.class);

    log.info("New resource created at " +
	     responseEntity.getHeaders().getLocation());

    return responseEntity.getBody();
}
