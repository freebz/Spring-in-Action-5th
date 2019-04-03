// Listing 3.12  Saving taco designs and linking them orders

@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    @ModelAttribute(name = "order")
    public Order order() {
	return new Order();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
	return new Taco();
    }

    @PostMapping
    public String processDesign(
	    @Valid Taco design, Errors errors,
	    @ModelAttribute Order order) {

	if (errors.hasErrors()) {
	    return "design";
	}

	Taco saved = designRepo.save(design);
	order.addDesign(saved);

	return "redirect:/orders/current";
    }

    ...

}
