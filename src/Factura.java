import java.io.Serializable;
import java.util.ArrayList;

public class Factura implements Serializable {
    //Atributos
    private int id;
    private int client;
    private String date;
    private ArrayList<Producto> products;


//Lista los datos de las facturas
    public void ListarFacturas(int i){

        System.out.println("\n\t----------Factura "+i+"------------");
        System.out.println("> Id: " + id+"           ");
        System.out.println("> Cliente: " + client+"           ");
       // BuscarClienteFactura();
        System.out.println("> Date: " + date+"  ");
        System.out.println("\t---------Productos-------------");
        for (int j = 0; j < products.size(); j++) {
            products.get(j).ListarProductoparaFactur();
            System.out.println("");
        }

    }

    public static String BuscarClienteFactura(int idCliente){
        for (int j = 0; j < main.clientesA.size(); j++) {
            if(main.clientesA.get(j).getId() == idCliente){
               String nombre = main.clientesA.get(j).getName();
               return nombre;
            }
        }
        return  "Cliente no registrado";
    }

    //GETTERS AND SETTERS
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
