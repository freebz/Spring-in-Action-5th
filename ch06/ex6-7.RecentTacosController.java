// Listing 6.7  Applying Spring Data REST's base path to a controller

package tacos.web.api;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import tacos.Taco;
import tacos.data.TacoRepository;

@RepositoryRestController
public class RecentTacoController {

    private TacoRepository tacoRepo;

    public RecentTacoController(TacoRepository tacoRepo) {
	this.tacoRepo = tacoRepo;
    }

    @GetMapping(path="/tacos/recent", produces="application/hal+json")
    public ResponseEntity<Resources<TacoResource>> recentTacos() {

	PageRequest page = PageRequest.of(
	    0, 12, Sort.by("createdAt").descending());
	List<Taco> tacos = tacoRepo.findAll(page).getContent();

	List<TacoResource> tacoResources =
	    new TacoResourceAssembler().toResources(tacos);
	Resources<TacoResource> recentResources =
	    new Resources<TacoResource>(tacoResources);
	recentResources.add(
	    linkTo(methodOn(RecentTacosController.class).recentTacos())
	    .withRel("recents"));
	return new ResponseEntity<>(recentResources, HttpStatus.OK);
    }

}
