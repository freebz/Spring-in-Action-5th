// Listing 18.1  An MBean that counts how many tacos have been created

package tacos.tacos;
import java.util.concurrent.atomic.AtomicLong;
import
    org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.stereotype.Service;

@Service
@ManagedResource
public class TacoCounter
        extends AbstractRepositoryEventListener<Taco> {

    private AtomicLong counter;

    public TacoCounter(TacoRepository tacoREpo) {
	long initialCount = tacoRepo.count();
	this.counter = new AtomicLong(initialCount);
    }

    @Override
    protected void onAfterCreate(Taco entity) {
	counter.incrementAndGet();
    }

    @ManagedAttribute
    public long getTacoCount() {
	return counter.get();
    }

    @ManagedOperation
    public long increment(long delta) {
	return counter.addAndGet(delta);
    }
}
