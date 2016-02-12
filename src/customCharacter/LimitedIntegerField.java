package customCharacter;

/**
 * Created by 292925 on 12/02/2016.
 */
public class LimitedIntegerField extends IntegerField {
    private Integer maxValue;
    private Integer minValue;

    public LimitedIntegerField(final String name, final Integer value, final Integer maxValue, final Integer minValue) {
        super(name, value);
        this.maxValue = maxValue;
        this.minValue = minValue;
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(final Integer maxValue) {
        this.maxValue = maxValue;
    }

    public Integer getMinValue() {
        return minValue;
    }

    public void setMinValue(final Integer minValue) {
        this.minValue = minValue;
    }

    @Override
    public String toString() {
        return "LimitedIntegerField{" +
                "name='" + getName() + "\'" +
                ", value=" + getValue() +
                ", maxValue=" + maxValue +
                ", minValue=" + minValue +
                '}';
    }
}
