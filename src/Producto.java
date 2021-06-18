import java.io.Serializable;
import java.util.ArrayList;

public class Producto implements Serializable {
    private int id;
    private String name;
    private String description;
    private int cost;
    private double price;
    private ArrayList<Ingredients> ingredients;

    public void Producto(int id, String name, String description, int cost, double price){
    this.id=id;
    this.name=name;
    this.description=description;
    this.cost=cost;
    this.price=price;

    }

    public void ListarProducto(int i){
            System.out.println("\n\t----------Product "+i+"------------");
            System.out.println("> Id: " + id+"           ");
            System.out.println("> Name: " + name+"         ");
            System.out.println("> Description: " + description+"  ");
            System.out.println("> Cost: " + cost+"        ");
            System.out.println("> Price: " + price+"        ");
            System.out.println("\t---------Ingredients-------------");
            for (int j = 0; j < ingredients.size(); j++) {
                    ingredients.get(j).Listar();
                    System.out.println("");
            }
    }
    public void     ListarProductoparaFactur() {

        System.out.println("> Name: " + name + "         ");
        System.out.println("> Price: " + price + "        ");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }
}
