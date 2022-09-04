package custom.converter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class NonSerializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public String getSeed() {
        return this.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NonSerializable that = (NonSerializable) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "SpecialObject{" +
                "name='" + name + '\'' +
                '}';
    }

    public static class Factory {
        public static NonSerializable parse(String seed) {
            var specialObjectNotSerializable = new NonSerializable();
            specialObjectNotSerializable.setName(seed);
            return specialObjectNotSerializable;
        }
    }
}
