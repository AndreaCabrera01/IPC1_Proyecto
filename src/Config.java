public class Config {
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


}
