import com.google.gson.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static ArrayList<Usuario> usuariosA = new ArrayList<>();
    public static ArrayList<Producto> productosA = new ArrayList<>();
    public static ArrayList<Cliente> clientesA = new ArrayList<>();
    public static ArrayList<Factura> facturasA = new ArrayList<>();
    public static Config configs;
    public static Usuario[] usuarios;
    public static Producto[] productos;
    public static Cliente[] clientes;
    public static Factura[] facturas;



    public static void main(String[] args) {

        String archivo5 = Archivo.getContentOfFile("config.json");
        Gson gson = new Gson();
        configs = gson.fromJson(archivo5, Config.class);
        if(configs.getLoad().equals("json")){
            CargaJson();
        }else if(configs.getLoad().equals("bin")){
            CargaBin();
        }else{
            System.out.println("Los archivos no son compatibles.");
        }




}

    public static void CargaJson(){
        Gson gson = new Gson();
        String archivo1 = Archivo.getContentOfFile("users.json");
        String archivo2 = Archivo.getContentOfFile("products.json");
        String archivo3 = Archivo.getContentOfFile("clients.json");
        String archivo4 = Archivo.getContentOfFile("invoices.json");

        usuarios = gson.fromJson(archivo1, Usuario[].class);
        for (Usuario usuario: usuarios) {
            if(usuarios!=null){
                usuariosA.add(usuario);
            }
        }


        productos = gson.fromJson(archivo2, Producto[].class);
        for (Producto producto: productos) {
            if(producto!=null) {
                productosA.add(producto);
            }
        }

        clientes = gson.fromJson(archivo3, Cliente[].class);
        for (Cliente cliente: clientes) {
            if(cliente!=null) {
                clientesA.add(cliente);
            }
        }

        facturas = gson.fromJson(archivo4, Factura[].class);
        for (Factura factura: facturas) {
            if(factura!=null) {
                facturasA.add(factura);
            }

        }

        System.out.println();

        Menu.Menu();
    }

    public static void CargaBin(){
        usuariosA = (ArrayList<Usuario>) Archivo.deserialize("users.ipcrm");

        clientesA = (ArrayList<Cliente>) Archivo.deserialize("clients.ipcrm");

        productosA = (ArrayList<Producto>) Archivo.deserialize("products.ipcrm");

        facturasA = (ArrayList<Factura>) Archivo.deserialize("invoices.ipcrm");


        System.out.println();

        Menu.Menu();
    }

}

