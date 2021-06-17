import java.io.Serializable;
import java.util.ArrayList;

public class Factura implements Serializable {
    private int id;
    private int client;
    private String date;
    private ArrayList<Producto> products;



    public void ListarFacturas(int i){

        System.out.println("\n\t----------Factura "+i+"------------");
        System.out.println("> Id: " + id+"           ");
        System.out.println("> Client: " + client+"         ");
        System.out.println("> Date: " + date+"  ");
        products.get(i-1).ListarProductoparaFactur(i);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Producto> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Producto> products) {
        this.products = products;
    }
}
