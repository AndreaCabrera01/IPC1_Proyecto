import com.google.gson.*;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class main {
    //Variables y arreglos globales para guardar los archivos automaticamente
    public static ArrayList<Usuario> usuariosA = new ArrayList<>();
    public static ArrayList<Producto> productosA = new ArrayList<>();
    public static ArrayList<Cliente> clientesA = new ArrayList<>();
    public static ArrayList<Factura> facturasA = new ArrayList<>();
    public static Config configs;
    public static Usuario[] usuarios;
    public static Producto[] productos;
    public static Cliente[] clientes;
    public static Factura[] facturas;
    public static String username;
    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public static String textologA = "";
    public static String textologE = "\n\n | LOG de ERRORES " + dtf.format(LocalDateTime.now())+ " |";

    public static void main(String[] args) {
        //Dependiendo del 'load' en el archivo de config se leera el tipo de archivo
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

//Carga automática de los archivos JSON
    public static void CargaJson(){
        Gson gson = new Gson();
        String archivo1 = Archivo.getContentOfFile("users.json");
        String archivo2 = Archivo.getContentOfFile("products.json");
        String archivo3 = Archivo.getContentOfFile("clients.json");
        String archivo4 = Archivo.getContentOfFile("invoices.json");
    //Carga de usuarios y verificaciones
        usuarios = gson.fromJson(archivo1, Usuario[].class);
        for (Usuario usuario: usuarios) {
            if(usuarios!=null){
                usuariosA.add(usuario);
            }
        }
        VerificarUsuarios();

        //Carga de productos y verificaciones
        productos = gson.fromJson(archivo2, Producto[].class);
        for (Producto producto: productos) {
            if(producto!=null) {
                productosA.add(producto);
            }
        }
        VerificarProductos();

        //Carga de clientes y verificaciones
        clientes = gson.fromJson(archivo3, Cliente[].class);
        for (Cliente cliente: clientes) {
            if(cliente!=null) {
                clientesA.add(cliente);
            }
        }
        VerificarClientes();

        //Carga de facturas y verificaciones
        facturas = gson.fromJson(archivo4, Factura[].class);
        for (Factura factura: facturas) {
            if(factura!=null) {
                facturasA.add(factura);
            }

        }
        VerificarFacturas();

        //Según verificaciones, agregar al log de errores
        Archivo.LogErrores(textologE);
        //Inicio de sesión
        Login();
    }

    //Carga los archivos Binarios
    public static void CargaBin(){
        //Deserializa los archivos .ipcrm de usuarios y lee los Bin; verifica
        usuariosA = (ArrayList<Usuario>) Archivo.deserialize("users.ipcrm");
        VerificarUsuarios();

        //Deserializa los archivos .ipcrm de clientes y lee los Bin; verifica
        clientesA = (ArrayList<Cliente>) Archivo.deserialize("clients.ipcrm");
        VerificarClientes();

        //Deserializa los archivos .ipcrm de productos y lee los Bin; verifica
        productosA = (ArrayList<Producto>) Archivo.deserialize("products.ipcrm");
        VerificarProductos();

        //Deserializa los archivos .ipcrm de facturas y lee los Bin; verifica
        facturasA = (ArrayList<Factura>) Archivo.deserialize("invoices.ipcrm");
        VerificarFacturas();
//Según verificaciones, agregar al log de errores
        Archivo.LogErrores(textologE);
        //Inicio de sesión
        Login();
    }


    //Método del inicio de sesión, usuario y contraseña según los archivos de users
    public static void Login(){
        System.out.println("--------------INICIAR SESIÓN--------------");
        System.out.println("USERNAME: ");
        Scanner sc1 = new Scanner(System.in);
        username = sc1.nextLine();
        System.out.println("PASSWORD: ");
        Scanner sc2 = new Scanner(System.in);
        String password = sc1.nextLine();
        //Verificación
        for (int i=0; i<main.usuariosA.size() ; i++) {
            if (main.usuariosA.get(i).getUsername().equals(username) && main.usuariosA.get(i).getPassword().equals(password)){
                System.out.println("Ingreso exitoso");
                textologA="\n"+dtf.format(LocalDateTime.now())+"\t"+username+": Inicio de sesión exitoso.";
                Archivo.LogAcciones(textologA);
                Menu.Menu();
            }
        }
        //Manejo de error
        System.out.println("Usuario y/o contraseña incorrectos. Intente de nuevo");
        textologA="\n"+dtf.format(LocalDateTime.now())+"\t"+username+": Inicio de sesión fallido.";
        Archivo.LogAcciones(textologA);
        Login();
    }

    //Verificación de archivo de usuarios
    public static void VerificarUsuarios() {

            for (int i = 0; i < usuariosA.size(); i++) {
                for (int j = i+1; j < usuariosA.size(); j++) {
                    if (usuariosA.get(i).getUsername().equals(usuariosA.get(j).getUsername())) {
                        textologE+="\n"+dtf.format(LocalDateTime.now())+"\tUSERS: El username "+usuariosA.get(j).getUsername()+" ya existe, se omitió el registro.";
                        usuariosA.remove(j);
                        j--;
                    }
                }
            }
    }

    //Verificación de archivo de clientes
    public static void VerificarClientes() {

        for (int i = 0; i < clientesA.size(); i++) {
            for (int j = i+1; j < clientesA.size(); j++) {
                if (clientesA.get(i).getId()==clientesA.get(j).getId()) {
                    textologE+="\n"+dtf.format(LocalDateTime.now())+"\tCLIENTS: El id "+clientesA.get(j).getId()+" ya existe, se omitió el registro.";
                    clientesA.remove(j);
                    j--;
                }
            }
        }
    }

    //Verificación de archivo de facturas
    public static void VerificarFacturas() {

        for (int i = 0; i < facturasA.size(); i++) {
            for (int j = i+1; j < facturasA.size(); j++) {
                if (facturasA.get(i).getId()==facturasA.get(j).getId()) {
                    textologE+="\n"+dtf.format(LocalDateTime.now())+"\tINVOICES: El id "+facturasA.get(j).getId()+" ya existe, se omitió el registro.";
                    facturasA.remove(j);
                    j--;
                }
            }
        }
    }

    //Verificación de archivo de productos
    public static void VerificarProductos() {
        for (int i = 0; i < productosA.size(); i++) {
            for (int j = i+1; j < productosA.size(); j++) {
                if (productosA.get(i).getId()==productosA.get(j).getId()) {
                    textologE+="\n"+dtf.format(LocalDateTime.now())+"\tPRODUCTS: El id "+productosA.get(j).getId()+" ya existe, se omitió el registro.";
                    productosA.remove(j);
                    j--;
                }
            }
        }
    }
}

