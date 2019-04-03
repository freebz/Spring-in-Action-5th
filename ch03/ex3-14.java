// Listing 3.14  Using SimpleJdbcInsert to insert data

@Override
public Order save(Order order) {
    order.setPlacedAt(new Date());
    long orderId = saveOrderDetails(order);
    order.setId(orderId);
    List<Taco> tacos = order.getTacos();

    for (Taco taco: tacos) {
	saveTacoToOrder(taco, orderId);
    }

    return order;
}

private long saveOrderDetails(Order order) {
    @SuppressWarnings("unchecked")
    Map<String, Object> values =
	objectMapper.convertValue(order, Map.class);
    values.put("placedAt", order.getPlacedAt());

    long orderId =
	orderInserter
	    .executeAndReturnKey(values)
	    .longValue();
    return orderId;
}

private void saveTacoToOrder(Taco taco, long orderId) {
    Map<String, Object> values = new HashMap<>();
    values.put("tacoOrder", orderId);
    values.put("taco", taco.getId());
    orderTacoInserter.execute(values);
}
