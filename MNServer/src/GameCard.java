import java.io.Serializable;

/**
 * Created by Danila on 20.01.17.
 */
public abstract class GameCard implements Serializable  {
    String type;
    String name;

    public  String getName() {
        return name;
    }
    public  String getT() { return type;}
    public abstract void setT();
}
