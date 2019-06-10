// Selecting the first reactive type to publish

@Test
public void firstFlux() {
    Flux<String> slowFlux = Flux.just("tortoise", "snail", "sloth")
	.delaySubscription(Duration.ofMillis(100));
    Flux<String> fastFlux = Flux.just("hare", "cheetah", "squirrel");

    Flux<String> firstFlux = Flux.first(slowFlux, fastFlux);

    StepVerifier.create(firstFlux)
	.expectNext("hare")
	.expectNext("cheetah")
	.expectNext("squirrel")
	.verifyComplete();
}
