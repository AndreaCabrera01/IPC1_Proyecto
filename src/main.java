import com.google.gson.*;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

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

    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public static String textologA = "-----------------------------LOG de ACCIONES-----------------------------";

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
        VerificarUsuarios();

        productos = gson.fromJson(archivo2, Producto[].class);
        for (Producto producto: productos) {
            if(producto!=null) {
                productosA.add(producto);
            }
        }
        VerificarProductos();

        clientes = gson.fromJson(archivo3, Cliente[].class);
        for (Cliente cliente: clientes) {
            if(cliente!=null) {
                clientesA.add(cliente);
            }
        }
        VerificarClientes();

        facturas = gson.fromJson(archivo4, Factura[].class);
        for (Factura factura: facturas) {
            if(factura!=null) {
                facturasA.add(factura);
            }

        }
        VerificarFacturas();

        Login();
       // Menu.Menu();
    }

    public static void CargaBin(){
        usuariosA = (ArrayList<Usuario>) Archivo.deserialize("users.ipcrm");
        VerificarUsuarios();

        clientesA = (ArrayList<Cliente>) Archivo.deserialize("clients.ipcrm");
        VerificarClientes();
        productosA = (ArrayList<Producto>) Archivo.deserialize("products.ipcrm");
        VerificarProductos();
        facturasA = (ArrayList<Factura>) Archivo.deserialize("invoices.ipcrm");
        VerificarFacturas();

        Login();
    }

    public static void Login(){
        System.out.println("--------------INICIAR SESIÓN--------------");
        System.out.println("USERNAME: ");
        Scanner sc1 = new Scanner(System.in);
        String username = sc1.nextLine();
        System.out.println("PASSWORD: ");
        Scanner sc2 = new Scanner(System.in);
        String password = sc1.nextLine();
        for (int i=0; i<main.usuariosA.size() ; i++) {
            if (main.usuariosA.get(i).getUsername().equals(username) && main.usuariosA.get(i).getPassword().equals(password)){
                System.out.println("Ingreso exitoso");
                Menu.Menu();
                textologA+="\n"+dtf+"\t"+username+": Inicio de sesión exitoso.";
            }
        }
        System.out.println("Usuario y/o contraseña incorrectos. Intente de nuevo");
        textologA+="\n"+dtf+"\t"+username+": Inicio de sesión fallido.";
        Login();
    }

    public static void VerificarUsuarios() {

            for (int i = 0; i < usuariosA.size(); i++) {
                for (int j = i+1; j < usuariosA.size(); j++) {
                    if (usuariosA.get(i).getUsername().equals(usuariosA.get(j).getUsername())) {
                        usuariosA.remove(j);
                        j--;
                    }
                }
            }
    }

    public static void VerificarClientes() {

        for (int i = 0; i < clientesA.size(); i++) {
            for (int j = i+1; j < clientesA.size(); j++) {
                if (clientesA.get(i).getId()==clientesA.get(j).getId()) {
                    clientesA.remove(j);
                    j--;
                }
            }
        }
    }

    public static void VerificarFacturas() {

        for (int i = 0; i < facturasA.size(); i++) {
            for (int j = i+1; j < facturasA.size(); j++) {
                if (facturasA.get(i).getId()==facturasA.get(j).getId()) {
                    facturasA.remove(j);
                    j--;
                }
            }
        }
    }

    public static void VerificarProductos() {

        for (int i = 0; i < productosA.size(); i++) {
            for (int j = i+1; j < productosA.size(); j++) {
                if (productosA.get(i).getId()==productosA.get(j).getId()) {
                    productosA.remove(j);
                    j--;
                }
            }
        }
    }
}

