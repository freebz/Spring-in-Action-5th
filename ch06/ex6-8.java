// Listing 6.8  Adding custom links to a Spring Data REST endpoint

@Bean
public ResourceProcessor<PageResources<Resource<Taco>>>
    tacoProcessor(EntityLinks links) {

    return new ResourceProcessor<PageResources<Resource<Taco>>>() {
	@Override
	public PageResources<Resource<Taco>> process(
	                   PageResources<Resource<Taco>> resource) {
	    resource.add(
		links.linkFor(Taco.class)
		     .slash("recent")
		     .withRel("recents"));
	    return resource;
	}
    };
}
