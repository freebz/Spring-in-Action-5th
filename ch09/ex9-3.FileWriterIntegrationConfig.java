// Listing 9.3  Using Java configuration to define an integration flow

package sia5;
import java.io.File;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.integration.transformer.GenericTransformer;

@Configuration
public class FileWriterIntegrationConfig {

    @Bean
    @Transformer(inputChannnel="textInChannel",
		 outputChannel="fileWriterChannel")
    public GenericTransformer<String, String> upperCaseTransformer() {
	return text -> text.toUpperCase();
    }

    @Bean
    @ServiceActivator(inputChannel="fileWriterChannel")
    public FileWritingMessageHandler fileWriter() {
	FileWritingMessageHandler handler =
	    new FileWritingMessageHandler(new File("/tmp/sia/files"));
	handler.setExpectReply(false);
	handler.setFileExistsMode(FileExistsMode.APPEND);
	handler.setAppendNewLine(true);
	return handler;
    }

}
