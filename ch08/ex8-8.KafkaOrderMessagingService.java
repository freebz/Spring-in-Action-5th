// Listing 8.8  Sending orders with KafkaTemplate

package tacos.messaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaOrderMessagingService
                                  implements OrderMessagingService {

    private KafkaTemplate<String, Order> kafkaTemplate;

    @Autowired
    public KafkaOrderMessagingService(
	    KafkaTemplate<String, Order> kafkaTemplate) {
	this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendOrder(Order order) {
	kafkaTemplate.send("tacocloud.orders.topic", order);
    }

}
