// Listing 3.6  Inserting data with JdbcTemplate

@Override
public Ingredient save(Ingredient ingredient) {
    jdbc.update(
	"insert into Ingredient (id, name, type) values (?, ?, ?)",
	ingredient.getId(),
	ingredient.getName(),
	ingredient.getType().toString());
    return ingredient;
}
