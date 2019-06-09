// 7.1.2 PUTting resources

public void updateIngredient(Ingredient ingredient) {
    rest.put("http://localhost:8080/ingredients/{id}",
	     ingredient,
	     ingredient.getId());
}
