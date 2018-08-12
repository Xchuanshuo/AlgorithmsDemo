package string;

/**
 * @author Legend
 * @data by on 18-6-6.
 * @description
 */
public class Model {

    private String name;
    private int key;

    public Model(String name, int key) {
        this.name = name;
        this.key = key;
    }

    @Override
    public String toString() {
        return name + " : "+key;
    }

    public int key() {
        return key;
    }
}
