import java.io.Serializable;

public class Ingredients implements Serializable {
    //Atributos
    private String name;
    private int quantity;
    private String units;

    public Ingredients(String name, int quantity, String units){
        this.name = name;
        this.quantity = quantity;
        this.units = units;
    }

    //Lista los ingredientes del producto
    public void Listar(){
            System.out.println("> Name: " + name+"         ");
            System.out.println("> Quantity: " +quantity+"     ");
            System.out.println("> Units: " + units+"        ");
    }

    //GETTERS AND SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
}
