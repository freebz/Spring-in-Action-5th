// 10.3.1 Creating reactive types

// Creating from objects

@Test
public void createAFlux_just() {
    Flux<String> fruitFlux = Flux
	.just("Apple", "Orange", "Grape", "Banana", "Strawberry");
}


fruitFlux.subscribe(
    f -> System.out.println("Here's some fruit: " + f)
);


StepVerifier.create(fruitFlux)
    .expectNext("Apple")
    .expectNext("Orange")
    .expectNext("Banana")
    .expectNext("Strawberry")
    .verifyComplete();
