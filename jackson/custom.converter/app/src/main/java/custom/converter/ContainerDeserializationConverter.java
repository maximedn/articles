package custom.converter;

import com.fasterxml.jackson.databind.util.StdConverter;

public class ContainerDeserializationConverter extends StdConverter<Container,Container> {
    @Override
    public Container convert(Container value) {
        value.setNonSerializable(NonSerializable.Factory.parse(value.getNonSerializableRaw()));
        value.setNonSerializableRaw(null);
        return value;
    }
}
