// Buffering data on a reactive stream

@Test
public void buffer() {
    Flux<String> fruitFlux = Flux.just(
	"apple", "orange", "banana", "kiwi", "strawberry");

    Flux<List<String>> bufferedFlux = fruitFlux.buffer(3);

    StepVerifier
	.create(bufferedFlux)
	.expectNext(Arrays.asList("apple", "orange", "banana"))
	.expectNext(Arrays.asList("kiwi", "strawberry"))
	.verifyComplete();
}


Flux.just(
    "apple", "orange", "banana", "kiwi", "strawberry")
    .buffer(3)
    .flatMap(x ->
        Flux.fromIterable(x)
	    .map(y -> y.toUpperCase())
	    .subscribeOn(Schedulers.parallel())
	    .log()
    ).subscribe();


Flux<List<String>> bufferedFlux = fruitFlux.buffer();


@Test
public void collectList() {
    Flux<String> fruitFlux = Flux.just(
	"apple", "orange", "banana", "kiwi", "strawberry");

    Mono<List<String>> fruitListMono = fruitFlux.collectList();

    StepVerifier
	.create(fruitListMono)
	.expectNext(Arrays.asList(
	    "apple", "orange", "banana", "kiwi", "strawberry"))
	.verifyComplete();
}


@Test
public void collectMap() {
    Flux<String> animalFlux = Flux.just(
	"aardvark", "elephant", "koala", "eagle", "kangaroo");

    Mono<Map<Character, String>> animalMapMono =
	animalFlux.collectMap(a -> a.charAt(0));

    StepVerifier
	.create(animalMapMono)
	.expectNextMatches(map -> {
	    return
		map.size() == 3 &&
		map.get('a').equals("aardvark") &&
		map.get('e').equals("eagle") &&
		map.get('k').equals("kangaroo");
	})
	.verifyComplete();
}
