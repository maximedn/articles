package maximedn.articles.spring.config.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;


@ToString
@EqualsAndHashCode
@Configuration
@ConfigurationProperties("config")
@NoArgsConstructor
public class Config {

    /**
     *     [
     *          {
     *              "url" : "URL",
     *              "activated" : "ACTIVATED",
     *              "oauth" : "OAUTH"
     *          }
     *     ]
     */
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private String clientConfigsAsString;

    private List<ClientConfigurationItem> clientConfigs;

    @PostConstruct
    private void setConfiguration() {
        try {
            this.clientConfigs = ClientConfigurationItem.convert(this.clientConfigsAsString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ClientConfigurationItem> getClientConfigs() {
        return clientConfigs;
    }

    public void setClientConfigs(List<ClientConfigurationItem> clientConfigs) {
        this.clientConfigs = clientConfigs;
    }

    public void setClientConfigsAsString(String clientConfigsAsString) {
        this.clientConfigsAsString = clientConfigsAsString;
    }
}
