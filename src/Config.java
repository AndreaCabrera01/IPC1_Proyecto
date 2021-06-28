import java.io.Serializable;

public class Config implements Serializable {
   //Atributos
    private String name;
    private String address;
    private int phone;
    private String load;

    //Lista la descripción del restaurante descita por el archivo JSON
    public void ListarConfig(){
        System.out.println("\n\t----------Config------------");
        System.out.println("> Name: " + name+"         ");
        System.out.println("> Address: " + address+"  ");
        System.out.println("> Phone: " + phone+"        ");
        System.out.println("> Load: " + load+"        ");
    }

    //GETTERS AND SETTERS
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

    public String getLoad() {
        return load;
    }

    public void setLoad(String load) {
        this.load = load;
    }
}
