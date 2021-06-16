import com.google.gson.*;

import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static ArrayList<Usuario> usuariosA;
    public static ArrayList<Producto> productosA;
    public static ArrayList<Cliente> clientesA;
    public static ArrayList<Factura> facturasA;
    public static ArrayList<Config> configsA;


    public static void main(String[] args) {

        String archivo1 = Archivo.getContentOfFile("C:\\Users\\usuario\\Desktop\\Archivos Prueba Darwin\\users.json");
        String archivo2 = Archivo.getContentOfFile("C:\\Users\\usuario\\Desktop\\Archivos Prueba Darwin\\products.json");
        String archivo3 = Archivo.getContentOfFile("C:\\Users\\usuario\\Desktop\\Archivos Prueba Darwin\\clients.json");
        String archivo4 = Archivo.getContentOfFile("C:\\Users\\usuario\\Desktop\\Archivos Prueba Darwin\\invoices.json");
        String archivo5 = Archivo.getContentOfFile("C:\\Users\\usuario\\Desktop\\Archivos Prueba Darwin\\config.json");



        Gson gson = new Gson();
        Usuario[] usuarios = gson.fromJson(archivo1, Usuario[].class);
        usuariosA = new ArrayList<>();
        for (Usuario usuario: usuarios) {
            usuariosA.add(usuario);
        }


        Producto[] productos = gson.fromJson(archivo2, Producto[].class);
        productosA = new ArrayList<>();
        for (Producto producto: productos) {
            productosA.add(producto);
        }

        Cliente[] clientes = gson.fromJson(archivo3, Cliente[].class);
        clientesA = new ArrayList<>();
        for (Cliente cliente: clientes) {
            clientesA.add(cliente);
        }

        Factura[] facturas = gson.fromJson(archivo4, Factura[].class);
        facturasA = new ArrayList<>();
        for (Factura factura: facturas) {
            facturasA.add(factura);
        }

        Config[] configs = gson.fromJson(archivo5, Config[].class);
        configsA = new ArrayList<>();
        for (Config config: configs) {
            configsA.add(config);
        }


        System.out.println();

        Menu.Menu();

}    }

