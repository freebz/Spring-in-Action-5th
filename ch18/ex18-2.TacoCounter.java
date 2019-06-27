// Listing 18.2  Sending notifications for every 100 tacos

@Service
@ManagedResource
public class TacoCounter
       extends AbstractRepositoryEventListener<Taco>
       implements NotificationPublisherAware {

    private AtomicLong counter;
    private NotificationPublisher np;

...

    @Override
    public void setNotificationPublisher(NotificationPublisher np) {
	this.np = np;
    }

...

    @ManagedOperation
    public long increment(long delta) {
	long before = counter.get();
	long after =counter.addAndGet(delta);
	if ((after / 100) > (before / 100)) {
	    Notification notification = new Notification(
		"cato.count", this,
		before, after + "th taco created!");
	    np.sendNotification(notification);
	}

	return after;
    }
}
