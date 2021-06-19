import java.io.Serializable;

public class Cliente implements Serializable {
   //Atributos
    private int id;
    private String name;
    private String address;
    private int phone;
    private String nit;


    //Listado de clientes
    public void ListarClientes(int i){

        System.out.println("\n\t----------Client "+i+"------------");
        System.out.println("> Id: " + id+"           ");
        System.out.println("> Name: " + name+"         ");
        System.out.println("> Address: " + address+"  ");
        System.out.println("> Phone: " + phone+"        ");
        System.out.println("> Nit: " + nit+"        ");
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
}
