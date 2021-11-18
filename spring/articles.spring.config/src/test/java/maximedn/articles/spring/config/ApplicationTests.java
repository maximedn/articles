package maximedn.articles.spring.config;

import maximedn.articles.spring.config.config.ClientConfigurationItem;
import maximedn.articles.spring.config.config.Config;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * A simple test verifying that the application is able to load the configuration from an environment variable/
 * See "resources/application.properties"
 */
@SpringBootTest
class ApplicationTests {

    @Autowired
    private Config config;

    @Test
    void contextLoads() {
        var expected = new Config();
        expected.setClientConfigs(
                List.of(
                        ClientConfigurationItem.builder().url("http://www.test.com").activated(true).oauth(false).build(),
                        ClientConfigurationItem.builder().url("http://www.test2.com").activated(false).oauth(true).build()
                ));
        Assertions.assertEquals(expected, config);
    }

}
