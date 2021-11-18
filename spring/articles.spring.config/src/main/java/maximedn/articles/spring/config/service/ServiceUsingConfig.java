package maximedn.articles.spring.config.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import maximedn.articles.spring.config.config.Config;

@Service
public class ServiceUsingConfig {

    private static final Logger log = LoggerFactory.getLogger(ServiceUsingConfig.class);

    public ServiceUsingConfig(Config config) {
        log.info(config.toString());
    }
}
