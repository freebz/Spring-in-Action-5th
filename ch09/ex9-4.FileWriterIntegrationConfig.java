// Listing 9.4  Providing a fluent API for designing integration flows

package sia5;
import java.io.File;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.integration.file.dsl.Files;
import org.springframework.integration.file.support.FileExistsMode;

@Configuration
public class FileWriterIntegrationConfig {

    @Bean
    public IntegrationFlow fileWriterFlow() {
	return IntegrationFlows
	    .from(MessageChannels.direct("textInChannel"))
	    .<String, String>transform(t -> t.toUpperCase())
	    .handle(Files
		    .outboundAdapter(new File("/tmp/sia5/files"))
		    .fileExistsMode(FileExistsMode.APPEND)
		    .appendNewLine(true))
	    .get();
    }

}
