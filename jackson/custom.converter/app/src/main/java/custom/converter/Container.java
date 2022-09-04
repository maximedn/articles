package custom.converter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Objects;

@JsonDeserialize(converter = ContainerDeserializationConverter.class)
@JsonSerialize(converter = ContainerSerializationConverter.class)
public class Container {

    private String id;

    @JsonIgnore
    private NonSerializable nonSerializable;

    private String nonSerializableRaw;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public NonSerializable getNonSerializable() {
        return nonSerializable;
    }

    public void setNonSerializable(NonSerializable nonSerializable) {
        this.nonSerializable = nonSerializable;
    }

    public String getNonSerializableRaw() {
        return nonSerializableRaw;
    }

    public void setNonSerializableRaw(String nonSerializableRaw) {
        this.nonSerializableRaw = nonSerializableRaw;
    }

    @Override
    public String toString() {
        return "Container{" +
                "id='" + id + '\'' +
                ", nonSerializable=" + nonSerializable +
                ", nonSerializableRaw='" + nonSerializableRaw + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Container container = (Container) o;
        return Objects.equals(id, container.id) && Objects.equals(nonSerializable, container.nonSerializable) && Objects.equals(nonSerializableRaw, container.nonSerializableRaw);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nonSerializable, nonSerializableRaw);
    }
}
