import java.io.Serializable;

public class Ingredients implements Serializable {
    private String name;
    private int quantity;
    private String units;

    public void Listar(){
        System.out.println("> Name: " + name+"         ");
        System.out.println("> Quantity: " + quantity+"     ");
        System.out.println("> Units: " + units+"        ");
    }
}