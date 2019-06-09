// 7.1.3 DELETEing resources

public void deleteIngredient(Ingredient ingredient) {
    rest.delete("http://localhost:8080/ingredients/{id}",
		ingredient.getId());
}
