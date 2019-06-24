// Mitigating latency

@HystrixCommand(
    fallbackMethod="getDefaultIngredients",
    commandProperties={
	@HystrixProperty(
	    name="execution.isolation.thread.timeoutInMilliseconds",
	    value="500")
    })
public Iterable<Ingredient> getAllIngredients() {
    ...
}


@HystrixCommand(
    fallbackMethod="getDefaultIngredients",
    commandProperties={
	@HystrixProperty(
	    name="execution.timeout.enabled",
	    value="false")
    })
public Iterable<Ingredient> getAllIngredients() {
    ...
}
