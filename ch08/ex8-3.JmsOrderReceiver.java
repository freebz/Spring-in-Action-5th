// Listing 8.3  Receiving an already-converted Order object

package tacos.kitchen.messaging.jms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsOrderReceiver implements OrderReceiver {
    private JmsTemplate jms;

    @Autowired
    public JmsOrderReceiver(JmsTemplate jms) {
	this.jms = jms;
    }

    public Order receiveOrder() {
	return (Order) jms.receiveAndConvert("tacocloud.order.queue");
    }
}
