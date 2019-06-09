// 7.2 Navigating REST APIs with Traverson

Traverson traverson = new Traverson(
    URI.create("http://localhost:8080/api"), MediaTypes.HAL_JSON);


ParameterizedTypeReference<Resources<Ingredient>> ingredientType =
    new ParameterizedTypeReference<Resources<Ingredient>>() {};

Resources<Ingredient> ingredientRes =
    traverson
        .fllow("ingredients")
        .toObject(ingredientType);

Collection<Ingredient> ingredients = ingredientRes.getContent();


ParameterizedTypeReference<Resources<Taco>> tacoType =
    new ParameterizedTypeReference<Resources<Taco>> {};

Resources<Taco> tacoRes =
    traverson
        .follow("tacos")
        .follow("recents")
        .toObject(tacoType);

Collection<Taco> tacos = tacoRes.getContent();


Resources<Taco> tacoRes =
    traverson
        .follow("tacos", "recents")
        .toObject(tacoType);


private Ingredient addIngredient(Ingredient ingredient) {
    String ingredientsUrl = traverson
	.follow("ingredients")
	.asLink()
	.getHref();

    return rest.postForObject(ingredientsUrl,
			      ingredient,
			      Ingredient.class);
}
