// Listing 2.13  Validating a POSTed Order

@PostMapping
public String processOrder(@Valid Order order, Errors errors) {
    if (errors.hasErrors()) {
	return "orderForm";
    }

    log.info("Order submitted: " + order);
    return "redirect:/";
}
