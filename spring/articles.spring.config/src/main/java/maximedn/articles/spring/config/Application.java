package maximedn.articles.spring.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import maximedn.articles.spring.config.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AllArgsConstructor
@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static final ObjectMapper mapper = new ObjectMapper();

    public final Config config;

    @Override
    public void run(String... args) {
        log.info("Loaded config:");
        log.info(config.toString());
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
