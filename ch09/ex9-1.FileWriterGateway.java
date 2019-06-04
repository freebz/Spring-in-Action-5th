// Listing 9.1  Message gateway interface to transform method invocations into messages

package sia5;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessageingGateway(defaultRequestChannel="textInChannel")
public interface FileWriterGateway {

    void writeToFile(
	@Header(FileHeaders.filename) String filename,
	String data);

}
