// Managing circuit breaker thresholds

@HystrixCommand(
    fallbackMethod="getDefaultIngredients",
    commandProperties={
	@HystrixProperty(
	    name="circuitBreaker.requestVolumeThreshold",
	    value="30"),
	@HystrixProperty(
	    name="circuitBreaker.errorThresholdPercentage",
	    value="25"),
	@HystrixProperty(
	    name="metrics.rollingStats.timeInMilliseconds",
	    value="20000")
    })
public List<Ingredient> getAllIngredients() {
    // ...
}


@HystrixCommand(
    fallbackMethod="getDefaultIngredients",
    commandProperties={
	...
	@HystrixProperty(
	    name="circuitBreaker.sleepWindowInMilliseconds",
	    value="60000")
    })
