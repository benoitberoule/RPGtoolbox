package customCharacter;

/**
 * Created by 292925 on 12/02/2016.
 */
public class StringField extends AbstractField {
    private String content;

    public StringField(final String name, final String content) {
        setName(name);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "StringField{" +
                "name='" + getName() + "\'" +
                ", content='" + content + '\'' +
                '}';
    }
}
