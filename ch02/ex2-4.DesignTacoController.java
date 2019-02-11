// Listing 2.4  Handling POST requests with @PostMapping

@PostMapping
public String processDesign(Design design) {
    // Save the taco design...
    // We'll do this in chapter 3
    log.info("Processing design: " + design);

    return "redirect:/orders/current";
}
