public class ProductosFactura {
    private String name;
    private double price;

    public ProductosFactura(String name, double price){
        this.name = name;
        this.price = price;
    }

    //Según la factura, lista los productos que se enlazan a esta (la factura)
    public void ListarProductoparaFactur() {
        System.out.println("> Name: " + name + "         ");
        System.out.println("> Price: " + price + "        ");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
