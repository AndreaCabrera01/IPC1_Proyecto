import com.google.gson.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    public static void Login (){

        //Interfaz gráfica del Login


        JFrame login = new JFrame();
        login.setBounds(250, 250, 1200, 900);
        login.setLayout(null);
       // login.getContentPane().setBackground(new Color(147, 161, 104));
        login.setResizable(false);
        login.setLocationRelativeTo(null);

        JLabel titulo = new JLabel();
        titulo.setText("Restaurant Manager");
        titulo.setBounds(450, 10, 400, 50);
        titulo.setFont(new Font("Century Gothic",2,30));
        titulo.setForeground(new Color(255, 255, 255));

        JLabel Loginlbl = new JLabel();
        Loginlbl.setText("Login");
        Loginlbl.setBounds(550, 210, 400, 100);
        Loginlbl.setFont(new Font("Bahnschrift",0,60));
        Loginlbl.setForeground(new Color(0, 0, 0));

        JPanel paneldeco = new JPanel();
        paneldeco.setBounds(380, 5, 440, 60);
        paneldeco.setBackground(new Color(0, 0, 0, 185));

        JPanel panellog = new JPanel();
        panellog.setBounds(150, 150, 900, 600);
        panellog.setBackground(new Color(255, 255, 255));

        JPanel panel = new JPanel();
        panel.setBounds(165, 165, 900, 600);
        panel.setBackground(new Color(47, 43, 43, 159));

        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("FondoMadera.png"));
        label.setBounds(0, 0, 2000, 1200);

        JLabel labelIcon = new JLabel();
        labelIcon.setIcon(new ImageIcon("LoginIcon.png"));
        labelIcon.setBounds(400, 190, 128, 128);

        JLabel usernamelbl = new JLabel();
        usernamelbl.setText("USERNAME: ");
        usernamelbl.setBounds(300, 330, 200, 100);
        usernamelbl.setFont(new Font("Century Gothic",2,27));

        JLabel passwordlbl = new JLabel();
        passwordlbl.setText("PASSWORD: ");
        passwordlbl.setBounds(300, 455, 200, 100);
        passwordlbl.setFont(new Font("Century Gothic",2,27));

        JTextField txt1 = new JTextField();
        txt1.setBounds(500, 360, 375, 35);
        txt1.setBorder(null);
        txt1.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.BLACK));
        txt1.setFont(new Font("Bahnschrift",0,27));
        txt1.setBackground(new Color(142, 137, 137));
        txt1.setForeground(new Color(0, 0, 0));

        JPasswordField txt2 = new JPasswordField();
        txt2.setBounds(500, 485, 375, 35);
        txt2.setBorder(null);
        txt2.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.BLACK));
        txt2.setFont(new Font("Bahnschrift",0,27));
        txt2.setBackground(new Color(142, 137, 137));
        txt2.setForeground(new Color(0, 0, 0));

        JButton log = new JButton("Login");
        log.setBounds(520, 600, 200, 75);
        log.setFont(new Font("Century Gothic", 0, 27));
        log.setBackground(new Color(84, 158, 177));
        log.setForeground(Color.WHITE);

        JButton cerrar = new JButton("Cerrar Programa");
        cerrar.setBounds(50, 770, 250, 50);
        cerrar.setFont(new Font("Century Gothic", 0, 22));
        cerrar.setBackground(new Color(147, 28, 28));
        cerrar.setForeground(Color.WHITE);

        login.setVisible(true);
        login.add(txt1);
        login.add(txt2);
        login.add(log);
        login.add(usernamelbl);
        login.add(passwordlbl);
        login.add(labelIcon);
        login.add(Loginlbl);
        login.add(panellog);
        login.add(panel);
        login.add(titulo);
        login.add(paneldeco);
        login.add(cerrar);
        login.add(label);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //---------------------------------------------------------------------
        //Funcionamiento del login

        log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               /* System.out.println("--------------INICIAR SESIÓN--------------");
                System.out.println("USERNAME: ");
                Scanner sc1 = new Scanner(System.in);
                username = sc1.nextLine();
                System.out.println("PASSWORD: ");
                Scanner sc2 = new Scanner(System.in);
                String password = sc1.nextLine();
                //Verificación

                //Manejo de error
                //Login();*/

                username = txt1.getText();
               String password =String.valueOf(txt2.getPassword());
                System.out.println(username);
                System.out.println(password);
                for (int i=0; i<main.usuariosA.size() ; i++) {
                    if (main.usuariosA.get(i).getUsername().equals(username) && main.usuariosA.get(i).getPassword().equals(password)){
                        System.out.println("Ingreso exitoso");
                        textologA="\n"+dtf.format(LocalDateTime.now())+"\t"+username+": Inicio de sesión exitoso.";
                        Archivo.LogAcciones(textologA);
                        login.dispose();
                        Menu.Menu();
                    }
                }
              /*  System.out.println("Usuario y/o contraseña incorrectos. Intente de nuevo");
                textologA="\n"+dtf.format(LocalDateTime.now())+"\t"+username+": Inicio de sesión fallido.";
                Archivo.LogAcciones(textologA);
                login.dispose();*/
              //  Login();
            }
        });
        cerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

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

