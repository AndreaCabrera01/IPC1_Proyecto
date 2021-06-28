import java.io.Serializable;
import java.util.ArrayList;

public class Factura implements Serializable {
    //Atributos
    private int id;
    private int clientID;
  //  private ArrayList<Cliente> client;
    private String date;
    private ArrayList<Producto> products;


//Lista los datos de las facturas
    public void ListarFacturas(int i){

        System.out.println("\n\t----------Factura "+i+"------------");
        System.out.println("> Id: " + id+"           ");
        System.out.println("> Cliente: " + clientID+"           ");
       /* for (int j = 0; j < client.size(); j++) {
        client.get(j).ListarClienteparaFactur();
            System.out.println("");
        }*/

        /* System.out.println("----------------Cliente------------------ ");
        for (int j = 0; j < client.size(); j++) {
            client.get(j).ListarClienteparaFactur();
            System.out.println("");
        }*/
        System.out.println("> Date: " + date+"  ");
        System.out.println("\t---------Productos-------------");
        for (int j = 0; j < products.size(); j++) {
            products.get(j).ListarProductoparaFactur();
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

  /*  public ArrayList<Cliente> getClient() {
        return client;
    }

    public void setClient(ArrayList<Cliente> client) {
        this.client = client;
    }*/

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
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
