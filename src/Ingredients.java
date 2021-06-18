import java.io.Serializable;

public class Ingredients implements Serializable {
    private String name;
    private int quantity;
    private String units;

    public void Listar(){
            System.out.println("> Name: " + name+"         ");
            System.out.println("> Quantity: " +quantity+"     ");
            System.out.println("> Units: " + units+"        ");
    }

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
