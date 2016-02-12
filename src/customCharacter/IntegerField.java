package customCharacter;

/**
 * Created by 292925 on 12/02/2016.
 */
public class IntegerField extends AbstractField {
    private Integer value;

    public IntegerField(final String name, final Integer value) {
        setName(name);
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(final Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "IntegerField{" +
                "name='" + getName() + "\'" +
                ", value=" + value +
                '}';
    }
}
