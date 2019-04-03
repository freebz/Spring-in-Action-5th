// Listing 3.11  Injecting and using TacoRepository

@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;

    private TacoRepository designRepo;

    @Autowired
    public DesignTacoController(
	    IngredientRepository ingredientRepo,
	    TacoRepository designRepo) {
	this.ingredientRepo = ingredientRepo;
	this.designRepo = designRepo;
    }

    ...

}
