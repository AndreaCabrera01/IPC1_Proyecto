import java.io.Serializable;

public class Config implements Serializable {
    private String name;
    private String address;
    private int phone;
    private String load;

    public void ListarConfig(){

        System.out.println("\n\t----------Config------------");
        System.out.println("> Name: " + name+"         ");
        System.out.println("> Address: " + address+"  ");
        System.out.println("> Phone: " + phone+"        ");
        System.out.println("> Load: " + load+"        ");
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

    public String getLoad() {
        return load;
    }

    public void setLoad(String load) {
        this.load = load;
    }
}
