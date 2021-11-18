package maximedn.articles.spring.config.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import static maximedn.articles.spring.config.Application.mapper;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientConfigurationItem {

    private String url;
    private boolean activated;
    private boolean oauth;

    public static List<ClientConfigurationItem> convert(String toBeConverted) throws JsonProcessingException {
        return mapper.readerForListOf(ClientConfigurationItem.class).readValue(toBeConverted);
    }
}
