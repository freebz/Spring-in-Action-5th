// Listing 9.6  Converting incoming emails to taco orders using an integration transformer

@Component
public class EmailToOrderTransformer
        extends AbstractMailMessageTransformer<Order> {

    @Override
    protected AbstractIntegrationMessageBuilder<Order>
	          doTransform(Message mailMessage) throws Exception {
	Order tacoOrder = processPayload(mailMessage);
	return MessageBuilder.withPayload(tacoOrder);
    }

    ...
}
