// Listing 8.1  Sending an order with .send() to a default destination

package tacos.messaging;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class JmsOrderMessagingService implements OrderMessagingService {
    private JmsTemplate jms;

    @Autowired
    public JmsOrderMessagingService(JmsTemplate jms) {
	this.jms = jms;
    }

    @Override
    public void sendOrder(Order order) {
	jms.send(new MessageCreator() {
		@Override
		public Message createMessage(Session session)
		                              throws JMSException {
		    return session.createObjectMessage(order);
		}
	    }
	);
    }
}
