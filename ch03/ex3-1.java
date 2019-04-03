// Listing 3.1  Querying a database without JdbcTemplate

@Override
public Ingredient findOne(String id) {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
	connection = dataSource.getConnection();
	statement = connection.prepareStatement(
	    "select id, name, type from Ingredient");
	statement.setString(1, id);
	resultSet = statement.executeQuery();
	Ingredient ingredient = null;
	if(resultSet.next()) {
	    ingredient = new Ingredient(
		resultSet.getString("id"),
		resultSet.getString("name"),
		Ingredient.Type.valueOf(resultSet.getString("type")));
	}
	return ingredient;
    } catch (SQLException e) {
	/// ??? What should be done here ???
    } finally {
	if (resultSet != null) {
	    try {
		resultSet.close();
	    } catch (SQLException e) {}
	}
	if (statement != null) {
	    try {
		statement.close();
	    } catch (SQLException e) {}
	}
	if (connection != null) {
	    try {
		connection.close();
	    } catch (SQLException e) {}
	}
    }
    return null;
}
