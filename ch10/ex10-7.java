// Creating from collections

@Test
public void createAFlux_fromArray() {
    String[] fruits = new String[] {
	"Apple", "Orange", "Grape", "Banana", "Strawberry" };

    Flux<String> fruitFlux = Flux.fromArray(fruits);

    StepVerifier.create(fruitFlux)
	.expectNext("Apple")
	.expectNext("Orange")
	.expectNext("Grape")
	.expectNext("Banana")
	.expectNext("Strawberry")
	.verifyComplete();
}


@Test
public void createAFlux_fromIterable() {
    List<String> fruitList = new ArrayList<>();
    fruitList.add("Apple");
    fruitList.add("Orange");
    fruitList.add("Grape");
    fruitList.add("Banana");
    fruitList.add("Strawberry");

    Flux<String> fruitFlux = Flux.fromIterable(fruitList);

    // ... verify steps
}


@Test
public void createAFlux_fromStream() {
    Stream<String> fruitStream =
	Stream.of("Apple", "Orange", "Grape", "Banana", "Strawberry");

    Flux<String> fruitFlux = Flux.fromStream(fruitStream);

    // ... verify steps
}
