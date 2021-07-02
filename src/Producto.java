import java.io.Serializable;
import java.util.ArrayList;

public class Producto implements Serializable {
    //Atributos de los productos
    private int id;
    private String name;
    private String description;
    private double cost;
    private double price;
    private ArrayList<Ingredients> ingredients;

    public Producto(int id, String name, String description, double cost, double price, ArrayList<Ingredients> ingredients){
    this.id=id;
    this.name=name;
    this.description=description;
    this.cost=cost;
    this.price=price;
    this.ingredients = ingredients;

    }

    //Lista los datos de los productos
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



    //GETTERS AND SETTERS
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
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
