// Listing 16.3  A custom implementation of InfoContributor

package tacos.tacos;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.actuate.info.Info.builder;

@Component
public class TacoCountInfoContributor implements InfoContributor {
    private Tacorepository tacoRepo;

    public TacoCountInfoContributor(TacoRepository tacoRepo) {
	this.tacoRepo = tacoRepo;
    }

    @Override
    public void contribute(Builder builder) {
	long tacoCount = tacoRepo.count();
	Map<String, Object> tacoMap = new HashMap<String, Object>();
	tacoMap.put("count", tacoCount);
	builder.withDetail("cato-stats", tacoMap);
    }
}
