package customCharacter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 292925 on 12/02/2016.
 */
public class Category {
    private String name;
    private List<AbstractField> datas;

    public Category(final String name) {
        this.name = name;
        datas = new ArrayList<AbstractField>();
    }

    public Category(final String name, final List<AbstractField> datas) {
        this.name = name;
        this.datas = datas;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<AbstractField> getDatas() {
        return datas;
    }

    public void setDatas(final List<AbstractField> datas) {
        this.datas = datas;
    }

    public void addField(final AbstractField field){
        datas.add(field);
    }

    public void addField(final String name, Object... values){
        //Check the length of the ellipsis, if there is only one value, we check the type of this value.
        if (values.length == 1){
            //If the value is a String, we add a StringField.
            if (values[0].getClass() == String.class)
                addField(new StringField(name, (String) values[0]));
            else if (values[0].getClass() == Integer.class)
                addField(new IntegerField(name, (Integer) values[0]));
            else
                throw new UnsupportedClassVersionError(values.getClass().toString() + " is unsupported by AbstractField.");
        } else if (values.length == 3) {
            for (Object value : values) {
                if (value.getClass() != Integer.class)
                    throw new UnsupportedClassVersionError(values.getClass().toString() + " is unsupported by AbstractField.");
            }
            addField(new LimitedIntegerField(name, (Integer) values[0], (Integer) values[1], (Integer) values[2]));
        } else
            throw new ArrayIndexOutOfBoundsException(values.length + " is an unsupported number of parameter");

    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", datas=" + datas +
                '}';
    }
}
