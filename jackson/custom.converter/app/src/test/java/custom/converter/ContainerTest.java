package custom.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;

class ContainerTest {

    public static final String NAME = UUID.randomUUID().toString();
    public static final String ID = UUID.randomUUID().toString();

    private static final Logger LOGGER = Logger.getAnonymousLogger();

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void serializeAndDeserialize() throws JsonProcessingException {

        var beforeSerialization = new Container();
        beforeSerialization.setId(ID);
        var nonSerializable = new NonSerializable();
        nonSerializable.setName(NAME);
        beforeSerialization.setNonSerializable(nonSerializable);

        LOGGER.info(beforeSerialization.toString());

        var json = objectMapper.writeValueAsString(beforeSerialization);

        beforeSerialization.setNonSerializableRaw(null); // Necessary as the value is modified by the converter

        LOGGER.info(json);

        var afterSerialization = objectMapper.readValue(json, Container.class);

        LOGGER.info(afterSerialization.toString());

        assertThat(afterSerialization).isEqualTo(beforeSerialization);

    }
}