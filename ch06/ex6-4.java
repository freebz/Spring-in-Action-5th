// Listing 6.4  Adding hyperlinks to resources

@GetMapping("/recent")
public Resources<Resource<Taco>> recentTacos() {
    PageRequest page = PageRequest.of(
	0, 12, Sort.by("createdAt").descending());

    List<Taco> tacos = tacoRepo.findAll(page).getContent();
    Resources<Resource<Taco>> recentResources = Resources.wrap(tacos);

    recentResources.add(
	new Link("http://localhost:8080/design/recent", "recents"));
    return recentResources;
}
