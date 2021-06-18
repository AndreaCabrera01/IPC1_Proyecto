import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public static String textolog="";


    public static void opciones(){
        int opcion;
        int opcionS;

        do{
        Scanner sc = new Scanner(System.in);
        opcion = sc.nextInt();

        switch (opcion) {


            case 1: {
                System.out.println("--------------INFORMACIÓN DEL RESTAURANTE--------------");
                    main.configs.ListarConfig();
                    Menu();
                break;
            }

            case 2: {
//                System.out.println("--------------USUARIOS-------------");
                SubmMenuUsers();
                break;
            }

            case 3: {
//                System.out.println("--------------PRODUCTOS-------------");
                SubmMenuProducts();
                break;
            }

            case 4: {
//                System.out.println("--------------CLIENTES-------------");
                SubmMenuCliente();
                break;
            }
            case 5: {
//                System.out.println("--------------FACTURAS-------------");
                SubmMenuFacturas();
                break;
            }
            case 6: {
//                "--------------GUARDAR CAMBIOS-------------"
                System.out.println("Ingrese la opción que desea realizar: \n" +
                        "1. JSON\n" +
                        "2. Binario");
                opcionS = sc.nextInt();

                switch (opcionS){
                    case 1:{
                        SerializacionJ();
                        textolog ="\n"+dtf.format(LocalDateTime.now())+"\t"+main.username+": Eliminó al cliente: Guardó los cambios por medio de Archivos JSON.";
                        Archivo.LogAcciones(textolog);
                        System.out.println("Se han guardado los cambios en archivos JSON.");
                        Menu();
                        break;}
                    case 2: {
                        SerializacionB();
                        textolog ="\n"+dtf.format(LocalDateTime.now())+"\t"+main.username+": Eliminó al cliente: Guardó los cambios por medio de Archivos Binarios.";
                        Archivo.LogAcciones(textolog);
                        System.out.println("Se han guardado los cambios en archivos Binarios.");
                        Menu();
                        break;}
                    default:
                        System.out.println("Ha ingresado una opción incorrecta");
                }


                break;
            }

            case 7: {
                textolog="\n"+dtf.format(LocalDateTime.now())+"\t"+main.username+": Ha cerrado sesión.";
                Archivo.LogAcciones(textolog);
                System.out.println("Ha cerrado sesión.\n");
                main.Login();
                break;
            }
            case 8: {
                System.out.println("Gracias por utilizar  RESTAURANT MANAGER");
                System.out.println("Copyright 2021 - Grupo 19.");
                System.exit(0);
                break;
            }
            default:
                System.out.println("Ha ingresado una opción incorrecta");
        }
    }while(opcion!=8);
}







    public static void Menu(){
        //Menú
      System.out.println("\n===========  RESTAURANT MANAGER  =============");
        System.out.println("|                                            |");
        System.out.println("|                                            |");
        System.out.println("|    Ingrese la accion a realizar:           |");
        System.out.println("|                                            |");
        System.out.println("|    1. Información del restaurante          |");
        System.out.println("|    2. Usuarios                             |");
        System.out.println("|    3. Productos                            |");
        System.out.println("|    4. Clientes                             |");
        System.out.println("|    5. Facturas                             |");
        System.out.println("|    6. Guardar Cambios                      |");
        System.out.println("|    7. Cerrar Sesión                        |");
        System.out.println("|    8. Cerrar Programa                      |");
        System.out.println("|                                            |");
        System.out.println("==============================================\n");
        opciones();

    }


    public static void SubmMenuUsers(){
        //Menú
      System.out.println("\n==================  USERS  ===================");
        System.out.println("|                                            |");
        System.out.println("|                                            |");
        System.out.println("|    Ingrese la accion a realizar:           |");
        System.out.println("|                                            |");
        System.out.println("|    1. Listar usuarios                      |");
        System.out.println("|    2. Eliminar usuario                     |");
        System.out.println("|    3. Ver usuario                          |");
        System.out.println("|    4. Regresar                             |");
        System.out.println("|                                            |");
        System.out.println("==============================================\n");
        OpcionesSubMenuUsers();
    }
    public static void OpcionesSubMenuUsers(){
            int opcion2;
        do{
            Scanner sc = new Scanner(System.in);
            opcion2 = sc.nextInt();
            switch (opcion2){
                case 1:{
                    ListadoUsers();
                    SubmMenuUsers();
                    break;
                }
                case 2:{
                    System.out.println("Ingrese el nombre del usuario a eliminar:");
                    Scanner sc1 = new Scanner(System.in);
                    String nombre = sc1.nextLine();
                    for (int i=0; i<main.usuariosA.size() ; i++) {
                        if (main.usuariosA.get(i).getUsername().equals(nombre)){
                            textolog ="\n"+dtf.format(LocalDateTime.now())+"\t"+main.username+": Eliminó al usuario: "+ main.usuariosA.get(i).getUsername()+".";
                            Archivo.LogAcciones(textolog);
                            System.out.println("Se ha eliminado el usuario correctamente.");
                            main.usuariosA.remove(i);
                            SubmMenuUsers();
                        }
                    }
                    System.out.println("No se ha encontrado el usuario a eliminar.");
                    textolog ="\n"+dtf.format(LocalDateTime.now())+"\t"+main.username+": No se encontró al usuario: "+ nombre + " para eliminar.";
                    Archivo.LogAcciones(textolog);
                    SubmMenuUsers();
                    break;
                }
                case 3:{
                    System.out.println("Ingrese el nombre del usuario que desea visualizar:");
                    Scanner sc1 = new Scanner(System.in);
                    String nombre = sc1.nextLine();
                    for (int i=0; i<main.usuariosA.size() ; i++) {
                        if (main.usuariosA.get(i).getUsername().equals(nombre)){
                            main.usuariosA.get(i).Listar(i+1);
                        }
                    }
                    SubmMenuUsers();
                    break;
                }
                case 4:{
                    Menu();
                    break;
                }
            }

        }while (opcion2!=4);
    }


    public static void SubmMenuProducts(){
        //Menú
      System.out.println("\n=================  PRODUCTS  =================");
        System.out.println("|                                            |");
        System.out.println("|                                            |");
        System.out.println("|    Ingrese la accion a realizar:           |");
        System.out.println("|                                            |");
        System.out.println("|    1. Listar productos                     |");
        System.out.println("|    2. Eliminar producto                    |");
        System.out.println("|    3. Ver producto                         |");
        System.out.println("|    4. Regresar                             |");
        System.out.println("|                                            |");
        System.out.println("==============================================\n");
        OpcionesSubMenuProducts();
    }
    public static void OpcionesSubMenuProducts(){
        int opcion;
        do{
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextInt();
            switch (opcion){
                case 1:{
                    ListadoProducts();
                    SubmMenuProducts();
                    break;
                }
                case 2:{
                    System.out.println("Ingrese el id del producto a eliminar:");
                    Scanner sc1 = new Scanner(System.in);
                    int id = sc1.nextInt();
                    for (int i=0; i<main.productosA.size() ; i++) {
                        if (main.productosA.get(i).getId()==id){
                            textolog ="\n"+dtf.format(LocalDateTime.now())+"\t"+main.username+": Eliminó el producto: "+ main.productosA.get(i).getName()+" con id "+main.productosA.get(i).getId()+".";
                            Archivo.LogAcciones(textolog);
                            main.productosA.remove(i);
                            System.out.println("Se ha eliminado el producto correctamente.");
                            SubmMenuProducts();
                        }
                    }
                    System.out.println("No se ha encontrado el producto a eliminar.");
                    textolog ="\n"+dtf.format(LocalDateTime.now())+"\t"+main.username+": No se encontró al producto con id: "+ id + " para eliminar.";
                    Archivo.LogAcciones(textolog);
                    SubmMenuProducts();
                    break;
                }
                case 3:{
                    System.out.println("Ingrese el id del producto a visualizar:");
                    Scanner sc1 = new Scanner(System.in);
                    int id = sc1.nextInt();
                    for (int i=0; i<main.productosA.size() ; i++) {
                        if (main.productosA.get(i).getId()==id){
                            main.productosA.get(i).ListarProducto(i+1);
                        }
                    }
                    SubmMenuProducts();
                    break;
                }
                case 4:{
                    Menu();
                    break;
                }
            }

        }while (opcion!=4);
    }


    public static void SubmMenuCliente(){
        //Menú
      System.out.println("\n=================  CLIENTS  ==================");
        System.out.println("|                                            |");
        System.out.println("|                                            |");
        System.out.println("|    Ingrese la accion a realizar:           |");
        System.out.println("|                                            |");
        System.out.println("|    1. Listar clientes                      |");
        System.out.println("|    2. Eliminar cliente                     |");
        System.out.println("|    3. Ver cliente                          |");
        System.out.println("|    4. Regresar                             |");
        System.out.println("|                                            |");
        System.out.println("==============================================\n");
        OpcionesSubMenuCliente();
    }
    public static void OpcionesSubMenuCliente(){
        int opcion;
        do{
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextInt();
            switch (opcion){
                case 1:{
                    ListadoClientes();
                    SubmMenuCliente();
                    break;
                }
                case 2:{
                    System.out.println("Ingrese el id del cliente a eliminar:");
                    Scanner sc1 = new Scanner(System.in);
                    int id = sc1.nextInt();
                    for (int i=0; i<main.clientesA.size() ; i++) {
                        if (main.clientesA.get(i).getId()==id){
                            textolog ="\n"+dtf.format(LocalDateTime.now())+"\t"+main.username+": Eliminó al cliente: "+ main.clientesA.get(i).getName()+" con id "+main.clientesA.get(i).getId()+".";
                            Archivo.LogAcciones(textolog);
                            main.clientesA.remove(i);
                            System.out.println("Se ha eliminado el cliente correctamente.");
                            SubmMenuCliente();
                        }
                    }
                    System.out.println("No se ha encontrado el cliente a eliminar.");
                    textolog ="\n"+dtf.format(LocalDateTime.now())+"\t"+main.username+": No se encontró al cliente con id: "+ id + " para eliminar.";
                    Archivo.LogAcciones(textolog);
                    SubmMenuCliente();
                    break;
                }
                case 3:{
                    System.out.println("Ingrese el id del cliente que desea visualizar:");
                    Scanner sc1 = new Scanner(System.in);
                    int id = sc1.nextInt();
                    for (int i=0; i<main.clientesA.size() ; i++) {
                        if (main.clientesA.get(i).getId()==id){
                            main.clientesA.get(i).ListarClientes(i+1);
                        }
                    }
                    SubmMenuCliente();
                    System.out.println();
                    break;
                }
                case 4:{
                    Menu();
                    break;
                }
            }

        }while (opcion!=4);
    }


    public static void SubmMenuFacturas(){
        //Menú
      System.out.println("\n=================  INVOICES  =================");
        System.out.println("|                                            |");
        System.out.println("|                                            |");
        System.out.println("|    Ingrese la accion a realizar:           |");
        System.out.println("|                                            |");
        System.out.println("|    1. Listar facturas                      |");
        System.out.println("|    2. Eliminar factura                     |");
        System.out.println("|    3. Ver factura                          |");
        System.out.println("|    4. Regresar                             |");
        System.out.println("|                                            |");
        System.out.println("==============================================\n");
        OpcionesSubMenuFacturas();
    }
    public static void OpcionesSubMenuFacturas(){
        int opcion;
        do{
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextInt();
            switch (opcion){
                case 1:{
                    ListadoFacturas();
                    SubmMenuFacturas();
                    break;
                }
                case 2:{
                    System.out.println("Ingrese el id de la factura a eliminar:");
                    Scanner sc1 = new Scanner(System.in);
                    int id = sc1.nextInt();
                    for (int i=0; i<main.facturasA.size() ; i++) {
                        if (main.facturasA.get(i).getId()==id){
                            textolog ="\n"+dtf.format(LocalDateTime.now())+"\t"+main.username+": Eliminó la factura con id "+main.facturasA.get(i).getId()+".";
                            Archivo.LogAcciones(textolog);
                            main.facturasA.remove(i);
                            System.out.println("Se ha eliminado la factura correctamente.");
                            SubmMenuFacturas();
                        }
                    }
                    System.out.println("No se ha encontrado la factura a eliminar.");
                    textolog ="\n"+dtf.format(LocalDateTime.now())+"\t"+main.username+": No se encontró la factura con id: "+ id + " para eliminar.";
                    Archivo.LogAcciones(textolog);
                    SubmMenuFacturas();
                    break;
                }
                case 3:{
                    System.out.println("Ingrese el id de la factura que desea visualizar:");
                    Scanner sc1 = new Scanner(System.in);
                    int id = sc1.nextInt();
                    for (int i=0; i<main.facturasA.size() ; i++) {
                        if (main.facturasA.get(i).getId()==id){
                            main.facturasA.get(i).ListarFacturas(i+1);
                        }
                    }

                    SubmMenuFacturas();
                    break;
                }
                case 4:{
                    Menu();
                    break;
                }
            }

        }while (opcion!=4);
    }




    public static void ListadoUsers(){
    for (int i = 0; i <main.usuariosA.size(); i++) {
        main.usuariosA.get(i).Listar(i+1);
    }

}
    public static void ListadoProducts(){
        for (int i = 0; i <main.productosA.size(); i++) {
            main.productosA.get(i).ListarProducto(i+1);
        }
    }
    public static void ListadoClientes(){
        for (int i = 0; i <main.clientesA.size(); i++) {
            main.clientesA.get(i).ListarClientes(i+1);
        }
    }
    public static void ListadoFacturas(){
        for (int i = 0; i <main.facturasA.size(); i++) {
            main.facturasA.get(i).ListarFacturas(i+1);
        }
    }

    public static void SerializacionJ(){
        Gson gson = new Gson();
        String JsonUsuarios = gson.toJson(main.usuariosA);
        Archivo.writeOnFile("users.json",JsonUsuarios,false);

        String JsonClientes = gson.toJson(main.clientesA);
        Archivo.writeOnFile("clients.json",JsonClientes,false);

        String JsonProductos = gson.toJson(main.productosA);
        Archivo.writeOnFile("products.json",JsonProductos,false);

        String JsonFacturas = gson.toJson(main.facturasA);
        Archivo.writeOnFile("invoices.json",JsonFacturas,false);
    }

    public static void SerializacionB(){
            Archivo.serialize("users.ipcrm", main.usuariosA);
            Archivo.serialize("clients.ipcrm", main.clientesA);
            Archivo.serialize("products.ipcrm", main.productosA);
            Archivo.serialize("invoices.ipcrm", main.facturasA);
    }
}
