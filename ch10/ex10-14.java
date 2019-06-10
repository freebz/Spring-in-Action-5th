// 10.3.4 Performing logic operations on reactive types

@Test
public void all() {
    Flux<String> animalFlux = Flux.just(
	"aardvark", "elephant", "eagle", "kangaroo");

    Mono<Boolean> hasAMono = animalFlux.all(a -> a.contains("a"));
    StepVerifier.create(hasAMono)
	.expectNext(true)
	.verifyComplete();

    Mono<Boolean> hasKMono = animalFlux.all(a -> a.contains("k"));
    StepVerifier.create(hasKMono)
	.expectNext(false)
	.verifyComplete();
}


@Test
public void any() {
    Flux<String> animalFlux = Flux.just(
	"aardvark", "elephant", "eagle", "kangaroo");

    Mono<Boolean> hasAMono = animalFlux.any(a -> a.contains("t"));

    StepVerifier.create(hasAMono)
	.expectNext(true)
	.verifyComplete();
}
