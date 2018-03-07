import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.Random;

public class ExampleBean {

    private ObjectProperty<Boolean> p1;

    private ObjectProperty<String> p2;


    public ExampleBean() {
        p1 = new SimpleObjectProperty(true);
        p1.addListener((o, ov, nv) -> {
            System.err.println("Value changed " + ov + " -> " + nv);
        });

        p2 = new SimpleObjectProperty(Integer.toString(new Random().nextInt()));
        p2.addListener((o, ov, nv) -> {
            System.err.println("Value changed " + ov + " -> " + nv);
        });
    }

    public final ObjectProperty<Boolean> p1Property() {
        return this.p1;
    }

    public final ObjectProperty<String> p2Property() {
        return this.p2;
    }


}
