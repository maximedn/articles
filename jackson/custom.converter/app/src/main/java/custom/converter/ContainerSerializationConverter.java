package custom.converter;

import com.fasterxml.jackson.databind.util.StdConverter;

public class ContainerSerializationConverter extends StdConverter<Container,Container> {
    @Override
    public Container convert(Container value) {
        value.setNonSerializableRaw(value.getNonSerializable().getSeed());
        return value;
    }
}
