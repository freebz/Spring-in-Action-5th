// Listing 5.1  Enabling configuration properties in OrderController

@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
@ConfigurationProperties(prefix="taco.orders")
public class OrderController {

    private int pageSize = 20;

    public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
    }

    ...

    @GetMapping
    public String ordersForUser(
	    @AuthenticationPrincipal User user, Model model) {

	Pageable pageable = PageRequest.of(0, pageSize);
	model.addAttribute("orders",
	    orderRepo.findByUserOrderByPlacedAtDesc(user, pageable));

	return "orderList";
    }

}
