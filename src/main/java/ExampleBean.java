import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class ExampleBean {

    private ObjectProperty<Boolean> p1;


    public ExampleBean() {
        p1 = new SimpleObjectProperty(true);
        p1.addListener((o, ov, nv) -> {
            System.err.println("Value changed " + ov + " -> " + nv);
        });
    }

    public final ObjectProperty<Boolean> p1Property() {
        return this.p1;
    }


}
