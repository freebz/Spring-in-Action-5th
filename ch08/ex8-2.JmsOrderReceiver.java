// Listing 8.2  Pulling orders from a queue

package tacos.kitchen.messaging.jms;
import javax.jms.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
public class JmsOrderReceiver implements OrderReceiver {
    private JmsTemplate jms;
    private MessageConverter converter;

    @Autowired
    public JmsOrderReceiver(JmsTemplate jms, MessageConverter converter) {
	this.jms = jms;
	this.converter = converter;
    }

    public Order receiveOrder() {
	Message message = jms.receive("tacocloud.order.queue");
	return (Order) converter.fromMessage(message);
    }
}
