// Listing 3.2  Querying a database with JdbcTemplate

private JdbcTemplate jdbc;

@Override
public Ingredient findOne(String id) {
    return jdbc.queryForObject(
	"select id, name, type from Ingredient where id=?",
	this::mapRowToIngredient, id);
}

private Ingredient mapRowToIngredient(ResultSet rs, int rowNum)
      throws SQLException {
    return new Ingredient(
	rs.getString("id"),
	rs.getString("name"),
	Ingredient.Type.valueOf(rs.getString("type")));
}
