// Listing 3.7  Injecting and using a repository in the controller

@Controller
@Requestmapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepo) {
	this.ingredientRepo = ingredientRepo;
    }

    @GetMapping
    public String showDesignForm(Model model) {
	List<Ingredient> ingredients = new ArrayList<>();
	ingredientRepo.findAll().forEach(i -> ingredients.add(i));

	Type[] types = Ingredient.Type.values();
	for (Type type : types) {
	    model.addAttribute(type.toString().toLowerCase(),
		filterByType(ingredient, type));
	}

	return "design";
    }
    
    ...

}
