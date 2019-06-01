// Listing 8.7  Declaring a method as a RabbitMQ message listener

package tacos.kitchen.messaging.rabbit.listener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {
    private KitchenUI ui;

    @Autowired
    public OrderListener(KitchenUI ui) {
	this.ui = ui;
    }

    @RabbitListener(queue = "tacocloud.order.queue")
    public void receiveOrder(Order order) {
	ui.displayOrder(order);
    }
}
