import com.google.gson.Gson;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    //Variables globales
    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public static String textolog="";
    public static JPanel usuarios;

    public static JPanel clientes;
    public static JPanel productos;
    public static JPanel facturas;
    public static JPanel guardar;
    public static DefaultTableModel modelUsuario;
    public static JTable table;
    public static JTable tableProductos;
    public static DefaultTableModel modelProductos2;
    public static JTable tableFacturas;
    public static DefaultTableModel modelFacturas2;
    public static  JTable tableClientes;

    //Variables para obtener los datos
    //**Usuarios**
    public static String usu;
    public static String con;

    //**Clientes**
    public static String idCliente;
    public static String NCliente;
    public static String address;
    public static String phone;
    public static String NIT;

    //**Facturas**
    public static String id;
    public static String cliente;
    public static String date;


    //**Productos**
    public static String idP;
    public static String nameP;
    public static String descP;
    public static String costP, priceP;


    public static void FILA(Object[] usuariosexistentes){
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.addRow(usuariosexistentes);
    }

    //**PRODUCTOS**
    public static void FILAP(Object[] usuariosexistentes){
        DefaultTableModel model = (DefaultTableModel)tableProductos.getModel();
        model.addRow(usuariosexistentes);
    }


    //**Clientes**

    public static void FILAC(Object[] clientes){
        DefaultTableModel model = (DefaultTableModel)tableClientes.getModel();
        model.addRow(clientes);
    }

    //**FACTURAS**
    public static void FILAF(Object[] facturas){
        DefaultTableModel model = (DefaultTableModel)tableFacturas.getModel();
        model.addRow(facturas);
    }
    public static void FILAF2(Object[] ProduFacturas){
        modelFacturas2.setRowCount(0);
        modelFacturas2.addRow(ProduFacturas);
    }



    public static void  Menu (){
        //Interfaz general del menú
        JFrame frame = new JFrame();
        frame.setBounds(250, 250, 1400, 900);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JLabel titulo = new JLabel();
        titulo.setText("Restaurant Management: Welcome "+main.username);
        titulo.setBounds(10,20,1000,40);
        titulo.setFont(new Font("Century Gothic", 1, 30));
        titulo.setForeground(Color.black);


        JLabel labelIcon = new JLabel();
        labelIcon.setIcon(new ImageIcon("FondoMenu.jpg"));
        labelIcon.setBounds(0, 0, 1400, 900);

        JButton cerrarS = new JButton("Cerrar Sesión");
        cerrarS.setBounds(1070, 20, 250, 50);
        cerrarS.setFont(new Font("Century Gothic", 0, 22));
        cerrarS.setBackground(new Color(147, 28, 28));
        cerrarS.setForeground(Color.WHITE);

//-------------------------PESTAÑAS------------------------------------------

        JTabbedPane pestañas=new JTabbedPane();
        pestañas.setBounds(0,80,1400,850);

        //--------------------INFO--------------------
        JPanel info = new JPanel();
        JLabel fotoFondo = new JLabel();
        fotoFondo.setIcon(new ImageIcon("FondoMenu.jpg"));
        fotoFondo.setBounds(0, 0, 1400, 850);

        JPanel cuadroBlanco = new JPanel();
        cuadroBlanco.setBounds(450, 200, 800,300);
        cuadroBlanco.setBackground(Color.WHITE);

        JPanel cuadro = new JPanel();
        cuadro.setBounds(465, 215, 800,300);
        cuadro.setBackground(new Color(0,0,0, 178));

        //Nombre del restaurante
        JLabel Config_Nombre = new JLabel("Nombre del Restaurante:");
        info.setLayout(null);
        Config_Nombre.setBounds(500, 220, 400, 50);
        Config_Nombre.setFont(new Font("Bahnschrift", 2, 27));
        info.add(Config_Nombre);

        JLabel ConfigName = new JLabel(String.valueOf(main.configs.getName()));
        ConfigName.setBounds(850, 220, 400, 50);
        ConfigName.setFont(new Font("Bahnschrift", 0, 27));
        info.add(ConfigName);


        //Dirección
        JLabel Config_Dir = new JLabel("Dirección del Restaurante:");
        Config_Dir.setBounds(500, 320, 400, 50);
        Config_Dir.setFont(new Font("Bahnschrift", 2, 27));
        info.add(Config_Dir);

        JLabel ConfigAddress = new JLabel(String.valueOf(main.configs.getAddress()));
        ConfigAddress.setBounds(850, 320, 400, 50);
        ConfigAddress.setFont(new Font("Bahnschrift", 0, 27));
        info.add(ConfigAddress);

        //Teléfono del restaurante
        JLabel Config_Tel = new JLabel("Teléfono del Restaurante:");
        Config_Tel.setBounds(500, 420, 400, 50);
        Config_Tel.setFont(new Font("Bahnschrift", 2, 27));
        info.add(Config_Tel);


        JLabel ConfigPhone = new JLabel(String.valueOf(main.configs.getPhone()));
        ConfigPhone.setBounds(850, 420, 400, 50);
        ConfigPhone.setFont(new Font("Bahnschrift", 0, 27));
        info.add(ConfigPhone);

        JLabel fotoDec = new JLabel();
        fotoDec.setIcon(new ImageIcon("ComidaDec.jpg"));
        fotoDec.setBounds(50, 50, 300, 625);
        info.add(fotoDec);

        JButton editarConfig = new JButton("Editar");
        editarConfig.setBounds(750, 570, 200, 75);
        editarConfig.setBackground(new Color(234, 195, 47));
        editarConfig.setFont(new Font("Century Gothic", 1, 20));
        editarConfig.setForeground(new Color(0, 0, 0));
        info.add(editarConfig);
        info.add(cuadroBlanco);
        info.add(cuadro);
        info.add(fotoFondo);

        //--------------------USUARIOS--------------------
        usuarios=new JPanel();
        usuarios.setLayout(null);
        CrearTablaUsuarios2();

        JLabel fotoFondoUsu = new JLabel();
        fotoFondoUsu.setIcon(new ImageIcon("FondoMenu.jpg"));
        fotoFondoUsu.setBounds(0, 0, 1400, 850);

        JLabel tUsuario = new JLabel("Usuarios:");
        tUsuario.setBounds(40, 20, 500, 50);
        tUsuario.setFont(new Font("Century Gothic", 1+2, 45));

        JLabel cUsuario = new JLabel("Configuración:");
        cUsuario.setBounds(700, 180, 500, 50);
        cUsuario.setFont(new Font("Century Gothic", 1+2, 38));

        JPanel cuadroBlancoU = new JPanel();
        cuadroBlancoU.setBounds(670, 170, 650,450);
        cuadroBlancoU.setBackground(new Color(255,255,255, 169));


        //Botones de Configuración
        //Editar
        JButton editarUsuarios = new JButton("Editar");
        editarUsuarios.setBounds(920, 300, 175, 45);
        editarUsuarios.setBackground(new Color(255, 188, 14));
        editarUsuarios.setFont(new Font("Bahnschrift", 0, 30));
        editarUsuarios.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                int sR = table.getSelectedRow();
                TableModel m = table.getModel();
                usu = m.getValueAt(sR, 0).toString();
                con = m.getValueAt(sR, 1).toString();

                EditarUsu EUsu = new EditarUsu();
                EUsu.getContentPane().setBackground(Color.ORANGE);
                EUsu.setVisible(true);

                EditarUsu.txtNomP.setText(usu);
                EditarUsu.txtApe.setText(con);
            }
        });

        //Eliminar
        JButton eliminarUsuarios = new JButton("Eliminar");
        eliminarUsuarios.setBounds(920, 400, 175, 45);
        eliminarUsuarios.setBackground(new Color(198, 11, 11));
        eliminarUsuarios.setFont(new Font("Bahnschrift", 0, 30));

        eliminarUsuarios.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                DefaultTableModel model = (DefaultTableModel)table.getModel();
                try{
                    int S = table.getSelectedRow();
                    model.removeRow(S);
                    main.usuariosA.remove(S);

                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });

        //Crear
        JButton crearUsuario = new JButton("Crear Nuevo Usuario");
        crearUsuario.setBounds(770, 500, 500, 45);
        crearUsuario.setBackground(new Color(82, 186, 42));
        crearUsuario.setFont(new Font("Bahnschrift", 0, 30));
        crearUsuario.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                CrearUsu CrU = new CrearUsu();
                CrU.getContentPane().setBackground(Color.ORANGE);
                CrU.setVisible(true);




            }

        });


        usuarios.add(tUsuario);
        usuarios.add(cUsuario);
        usuarios.add(editarUsuarios);
        usuarios.add(crearUsuario);
        usuarios.add(eliminarUsuarios);
        usuarios.add(cuadroBlancoU);
        usuarios.add(fotoFondoUsu);

        //--------------------CLIENTES--------------------
        clientes=new JPanel();
        clientes.setLayout(null);

        JLabel tClientes = new JLabel("Clientes:");
        tClientes.setBounds(40, 20, 500, 50);
        tClientes.setFont(new Font("Century Gothic", 1+2, 45));

        JLabel cClientes = new JLabel("Configuración:");
        cClientes.setBounds(790, 180, 500, 50);
        cClientes.setFont(new Font("Century Gothic", 1+2, 38));

        JPanel cuadroBlancoC = new JPanel();
        cuadroBlancoC.setBounds(750, 170, 520,450);
        cuadroBlancoC.setBackground(new Color(255,255,255, 169));

        //Botones de configuración
        //Editar
        JButton editarClientes = new JButton("Editar");
        editarClientes.setBounds(920, 300, 175, 45);
        editarClientes.setBackground(new Color(255, 188, 14));
        editarClientes.setFont(new Font("Bahnschrift", 0, 30));
        editarClientes.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                int sR = tableClientes.getSelectedRow();
                TableModel m = tableClientes.getModel();
                idCliente = m.getValueAt(sR, 0).toString();
                NCliente = m.getValueAt(sR, 1).toString();
                address = m.getValueAt(sR, 2).toString();
                phone = m.getValueAt(sR, 3).toString();
                NIT = m.getValueAt(sR, 4).toString();

                EditarClient EClient = new EditarClient();
                EClient.getContentPane().setBackground(Color.ORANGE);
                EClient.setVisible(true);

                EditarClient.txtID.setText(idCliente);
                EditarClient.txtNClient.setText(NCliente);
                EditarClient.txtAddress.setText(address);
                EditarClient.txtPhone.setText(phone);
                EditarClient.txtNIT.setText(NIT);
            }
        });
     //Eliminar
        JButton eliminarClientes= new JButton("Eliminar");
        eliminarClientes.setBounds(920, 400, 175, 45);
        eliminarClientes.setBackground(new Color(198, 11, 11));
        eliminarClientes.setFont(new Font("Bahnschrift", 0, 30));

        eliminarClientes.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                DefaultTableModel model = (DefaultTableModel)tableClientes.getModel();
                try{
                    int S = tableClientes.getSelectedRow();
                    model.removeRow(S);
                    main.clientesA.remove(S);

                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });
        //Crear
        JButton crearClientes = new JButton("Crear Nuevo Cliente");
        crearClientes.setBounds(780, 500, 480, 45);
        crearClientes.setBackground(new Color(82, 186, 42));
        crearClientes.setFont(new Font("Bahnschrift", 0, 30));
        crearClientes.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                CrearClient CrC = new CrearClient();
                CrC.getContentPane().setBackground(Color.ORANGE);
                CrC.setVisible(true);
            }

        });

        JLabel fotoFondoClientes = new JLabel();
        fotoFondoClientes.setIcon(new ImageIcon("FondoMenu.jpg"));
        fotoFondoClientes.setBounds(0, 0, 1400, 850);

        CrearTablaClientes();


        clientes.add(tClientes);
        clientes.add(cClientes);
        clientes.add(crearClientes);
        clientes.add(eliminarClientes);
        clientes.add(editarClientes);
        clientes.add(cuadroBlancoC);
        clientes.add(fotoFondoClientes);
        //--------------------PRODUCTOS--------------------
        productos=new JPanel();
        productos.setLayout(null);
        CrearTablaProductos();

        JLabel tProductos = new JLabel("Productos:");
        tProductos.setBounds(40, 20, 500, 50);
        tProductos.setFont(new Font("Century Gothic", 1+2, 45));

        JLabel tIngre = new JLabel("Ingredientes:");
        tIngre.setBounds(650, 30, 500, 50);
        tIngre.setFont(new Font("Century Gothic", 1+2, 25));

        JLabel cProductos = new JLabel("Configuración:");
        cProductos.setBounds(1020, 180, 500, 50);
        cProductos.setFont(new Font("Century Gothic", 1+2, 30));

        JPanel cuadroBlancoP = new JPanel();
        cuadroBlancoP.setBounds(1000, 170, 320,450);
        cuadroBlancoP.setBackground(new Color(255,255,255, 169));

        //Botones de Configuracion
        //Editar
        JButton editarProductos = new JButton("Editar");
        editarProductos.setBounds(1070, 300, 175, 45);
        editarProductos.setBackground(new Color(255, 188, 14));
        editarProductos.setFont(new Font("Bahnschrift", 0, 30));
        editarProductos.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                int sR = tableProductos.getSelectedRow();
                TableModel m = tableProductos.getModel();
                idP = (m.getValueAt(sR, 0).toString());
                nameP = m.getValueAt(sR, 1).toString();
                descP = m.getValueAt(sR, 2).toString();
                costP = (m.getValueAt(sR, 3).toString());
                priceP =(m.getValueAt(sR, 4).toString());

                EditarProdu EPru = new EditarProdu();
                EPru.getContentPane().setBackground(Color.ORANGE);
                EPru.setVisible(true);

                EditarProdu.txtUsu.setText(idP);
                EditarProdu.txtPass.setText(nameP);
                EditarProdu.txtDescripcion.setText(descP);
                EditarProdu.txtCosto.setText(costP);
                EditarProdu.txtPrecio.setText(priceP);
            }
        });

        JButton crearProducto = new JButton("Crear Producto");
        crearProducto.setBounds(1030, 500, 250, 45);
        crearProducto.setBackground(new Color(82, 186, 42));
        crearProducto.setFont(new Font("Bahnschrift", 0, 23));
        crearProducto.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                CrearProdu CrP = new CrearProdu();
                CrP.getContentPane().setBackground(Color.ORANGE);
                CrP.setVisible(true);
            }

        });


        JButton eliminarProducto = new JButton("Eliminar");
        eliminarProducto.setBounds(1070, 400, 175, 45);
        eliminarProducto.setBackground(new Color(198, 11, 11));
        eliminarProducto.setFont(new Font("Bahnschrift", 0, 30));
        eliminarProducto.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                DefaultTableModel model = (DefaultTableModel)tableProductos.getModel();
                try{
                    int S = tableProductos.getSelectedRow();
                    model.removeRow(S);
                    main.productosA.remove(S);
                    modelProductos2.setRowCount(0);


                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });


        JLabel fotoFondoProductos = new JLabel();
        fotoFondoProductos.setIcon(new ImageIcon("FondoMenu.jpg"));
        fotoFondoProductos.setBounds(0, 0, 1400, 850);

        productos.add(tIngre);
        productos.add(tProductos);
        productos.add(cProductos);
        productos.add(editarProductos);
        productos.add(crearProducto);
        productos.add(eliminarProducto);
        productos.add(cuadroBlancoP);
        productos.add(fotoFondoProductos);

        //--------------------FACTURAS--------------------
        facturas=new JPanel();
        facturas.setLayout(null);
        CrearTablaFacturas();

        JLabel fotoFondoFacturas = new JLabel();
        fotoFondoFacturas.setIcon(new ImageIcon("FondoMenu.jpg"));
        fotoFondoFacturas.setBounds(0, 0, 1400, 850);


        JLabel tFacturas = new JLabel("Facturas:");
        tFacturas.setBounds(40, 20, 500, 50);
        tFacturas.setFont(new Font("Century Gothic", 1+2, 45));

        JLabel tCli = new JLabel("Compra:");
        tCli.setBounds(550, 30, 500, 50);
        tCli.setFont(new Font("Century Gothic", 1+2, 25));

        JLabel cFacturas = new JLabel("Configuración:");
        cFacturas.setBounds(910, 200, 500, 50);
        cFacturas.setFont(new Font("Century Gothic", 1+2, 30));

        JPanel cuadroBlancoF = new JPanel();
        cuadroBlancoF.setBounds(890, 170, 320,380);
        cuadroBlancoF.setBackground(new Color(255,255,255, 169));

        //Botones de configuración:

        JButton crearFactura = new JButton("Crear Factura");
        crearFactura.setBounds(940, 320, 230, 60);
        crearFactura.setBackground(new Color(82, 186, 42));
        crearFactura.setFont(new Font("Bahnschrift", 0, 23));
        crearFactura.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                CrearFactu CrF = new CrearFactu();
                CrF.getContentPane().setBackground(Color.ORANGE);
                CrF.setVisible(true);
            }

        });

        facturas.add(tFacturas);
        facturas.add(tCli);
        facturas.add(cFacturas);
        facturas.add(crearFactura);
        facturas.add(cuadroBlancoF);
        facturas.add(fotoFondoFacturas);


        //--------------------GUARDAR--------------------
        JButton guardar = new JButton("Guardar");
        guardar.setBounds(790, 20, 250, 50);
        guardar.setFont(new Font("Century Gothic", 0, 22));
        guardar.setBackground(new Color(139, 147, 28));
        guardar.setForeground(Color.WHITE);

        guardar.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
               SerializacionJ();
                JOptionPane.showMessageDialog(null, "Se han guardado los datos.");
            }

        });


        //Cada una de las pestañas para seleccionar opción/submenú
        pestañas.add("Information", info);
        pestañas.add("Users", usuarios);
        pestañas.add("Clients", clientes);
        pestañas.add("Products", productos);
        pestañas.add("Invoices", facturas);
        pestañas.setBackground(Color.white);
        pestañas.setFont(new Font("Century Gothic", 0, 20));

        frame.add(pestañas);
        frame.add(titulo);
        frame.add(guardar);
        frame.add(cerrarS);
        frame.add(labelIcon);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//Botón para cerrar sesión y volver al login
        cerrarS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.Login();
                frame.dispose();
            }
        });

        //GUARDAR TODO
        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //METER EL MÉTODO
            }
        });

        //EDICIÓN DE CONFIG.JSON
        editarConfig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame editConfig = new JFrame();
                editConfig.setBounds(670, 100, 700, 600);
                editConfig.setBackground(new Color(255, 193, 77));
                editConfig.setLayout(null);
                editConfig.setResizable(false);

                //Config del nombre
                JLabel nombre = new JLabel("Nombre del Restaurante: ");
                nombre.setBounds(10, 100, 300, 30);
                nombre.setFont(new Font("Century Gothic", 0, 20));
                JTextField name = new JTextField();
                name.setBounds(300, 102, 330, 30);
                name.setFont(new Font("Century Gothic", 0, 20));


                //Config de la dirección
                JLabel direccion = new JLabel("Direccion del Restaurante: ");
                direccion.setBounds(10, 200, 300, 30);
                direccion.setFont(new Font("Century Gothic", 0, 20));
                JTextField address = new JTextField();
                address.setBounds(300, 202, 330, 30);
                address.setFont(new Font("Century Gothic", 0, 20));


                //Config del numero
                JLabel numero = new JLabel("Teléfono del Restaurante: ");
                numero.setBounds(10, 300, 300, 30);
                numero.setFont(new Font("Century Gothic", 0, 20));
                JTextField number = new JTextField();
                number.setBounds(300, 302, 330, 30);
                number.setFont(new Font("Century Gothic", 0, 20));


                //Botón guardar Config
                JButton guardarConfig = new JButton("Guardar");
                guardarConfig.setBounds(100, 400, 200, 75);
                guardarConfig.setBackground(new Color(234, 195, 47));
                guardarConfig.setFont(new Font("Century Gothic", 1, 20));
                guardarConfig.setForeground(new Color(0, 0, 0));


                editConfig.add(name);
                editConfig.add(address);
                editConfig.add(number);

                editConfig.add(direccion);
                editConfig.add(nombre);
                editConfig.add(numero);

                editConfig.add(guardarConfig);

                guardarConfig.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        boolean guardar = false;
                        if(name.getText().equals("") && address.getText().equals("") && number.getText().equals("")){
                            JOptionPane.showMessageDialog(null,"No se han encontrado datos que actualizar.");
                        }

                        if(!name.getText().equals("")){
                            String newName = name.getText();
                            main.configs.setName(newName);
                            guardar = true;
                        }
                        if(!address.getText().equals("")){
                            String newAddress = address.getText();
                            main.configs.setAddress(newAddress);
                            guardar = true;
                        }
                        if(!number.getText().equals("")){
                            String newNumber = number.getText();
                            main.configs.setPhone(Integer.parseInt(newNumber));
                            guardar = true;
                        }

                        if(guardar){
                            JOptionPane.showMessageDialog(null,"Datos actualizados.");
                            ConfigName.setText(main.configs.getName());
                            ConfigPhone.setText(String.valueOf(main.configs.getPhone()));
                            ConfigAddress.setText(main.configs.getAddress());
                        }


                        editConfig.dispose();
                    }
                });


                editConfig.setVisible(true);
            }
        });
    }






    public static void CrearTablaUsuarios2(){
        modelUsuario = new DefaultTableModel();
        table = new JTable(modelUsuario);
        table.setFont(new Font("Century Gothic", 0, 18));
        table.setRowHeight(25);
        modelUsuario.addColumn("Username");
        modelUsuario.addColumn("Password");


        for (int i = 0; i <main.usuariosA.size(); i++) {
            modelUsuario.addRow(new Object[]{main.usuariosA.get(i).getUsername(), main.usuariosA.get(i).getPassword()});
        }

        JScrollPane sp = new JScrollPane(table);
        sp.setEnabled(false);
        sp.setBounds(100,80,500,600);
        sp.setVisible(true);


        usuarios.add(sp);

    }

        public static void CrearTablaClientes(){
        DefaultTableModel modelCliente = new DefaultTableModel();
        tableClientes = new JTable(modelCliente);
        tableClientes.setRowHeight(25);
        tableClientes.setFont(new Font("Century Gothic", 0, 18));
        modelCliente.addColumn("ID");
        modelCliente.addColumn("Name");
        modelCliente.addColumn("Address");
        modelCliente.addColumn("Phone");
        modelCliente.addColumn("NIT");

        for (int i = 0; i <main.clientesA.size(); i++) {
            modelCliente.addRow(new Object[]{main.clientesA.get(i).getId(),main.clientesA.get(i).getName(), main.clientesA.get(i).getAddress(),main.clientesA.get(i).getPhone(),main.clientesA.get(i).getNit()});
        }

        JScrollPane sp = new JScrollPane(tableClientes);
        sp.setEnabled(false);
        sp.setBounds(100,80,600,600);
        sp.setVisible(true);
        clientes.add(sp);
    }

    public static void CrearTablaProductos(){
        DefaultTableModel modelProductos = new DefaultTableModel();
        tableProductos = new JTable(modelProductos);
        tableProductos.setRowHeight(25);
        tableProductos.setFont(new Font("Century Gothic", 0, 18));
        modelProductos.addColumn("ID");
        modelProductos.addColumn("Name");
        modelProductos.addColumn("Description");
        modelProductos.addColumn("Cost");
        modelProductos.addColumn("Price");


        for (int i = 0; i <main.productosA.size(); i++) {
            modelProductos.addRow(new Object[]{main.productosA.get(i).getId(),main.productosA.get(i).getName(), main.productosA.get(i).getDescription(),main.productosA.get(i).getCost(),main.productosA.get(i).getPrice()});
        }

        JScrollPane sp = new JScrollPane(tableProductos);
        sp.setEnabled(false);
        sp.setBounds(80,80,500,600);
        sp.setVisible(true);
        productos.add(sp);

        modelProductos2 = new DefaultTableModel();
        JTable tableP = new JTable(modelProductos2);
        tableP.setRowHeight(20);
        tableP.setFont(new Font("Century Gothic", 0, 13));
        modelProductos2.addColumn("Name");
        modelProductos2.addColumn("Quantity");
        modelProductos2.addColumn("Units");

        DefaultTableModel modelP = (DefaultTableModel)tableProductos.getModel();
        tableProductos.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                try{
                    int S = tableProductos.getSelectedRow();
                    int id =Integer.parseInt(modelP.getValueAt(S, 0).toString());
                    TablaDatosProductos(id);
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "producto sin ingredientes");
                }
            }

        });

        JScrollPane sp2 = new JScrollPane(tableP);
        sp2.setEnabled(false);
        sp2.setBounds(650,80,300,600);
        sp2.setVisible(true);
        productos.add(sp2);

    }

    public static void TablaDatosProductos(int id){
        modelProductos2.setRowCount(0);

        for (int i = 0; i <main.productosA.size(); i++) {
            if(main.productosA.get(i).getId() == id){
                ArrayList<Ingredients> ingrediente = main.productosA.get(i).getIngredients();
                for (int j = 0; j < ingrediente.size(); j++) {

                    modelProductos2.addRow(new Object[]{ingrediente.get(j).getName(), ingrediente.get(j).getQuantity(),ingrediente.get(j).getUnits()});
                }
            }
        }

    }


    public static void CrearTablaFacturas(){
        DefaultTableModel modelFacturas = new DefaultTableModel();
        tableFacturas = new JTable(modelFacturas);
        tableFacturas.setRowHeight(25);
        tableFacturas.setFont(new Font("Century Gothic", 0, 18));
        modelFacturas.addColumn("ID");
        modelFacturas.addColumn("Cliente");
        modelFacturas.addColumn("Date");

        for (int i = 0; i <main.facturasA.size(); i++) {
            String nombreCliente = Factura.BuscarClienteFactura(main.facturasA.get(i).getClient());
            modelFacturas.addRow(new Object[]{main.facturasA.get(i).getId(),nombreCliente, main.facturasA.get(i).getDate()});
        }

        JScrollPane sp = new JScrollPane(tableFacturas);
        sp.setEnabled(false);
        sp.setBounds(100,80,400,600);
        sp.setVisible(true);
        facturas.add(sp);

        modelFacturas2 = new DefaultTableModel();
        JTable tableF = new JTable(modelFacturas2);
        tableF.setRowHeight(20);
        tableF.setFont(new Font("Century Gothic", 0, 13));
        modelFacturas2.addColumn("Name");
        modelFacturas2.addColumn("Price");

        DefaultTableModel modelF = (DefaultTableModel)tableFacturas.getModel();
        tableFacturas.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                try{
                    int S = tableFacturas.getSelectedRow();
                    int id =Integer.parseInt(modelF.getValueAt(S, 0).toString());
                    TablaDatosFacturas(id);
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "la factura no posee productos");
                }
            }
        });

        JScrollPane sp2 = new JScrollPane(tableF);
        sp2.setEnabled(false);
        sp2.setBounds(550,80,250,400);
        sp2.setVisible(true);
        facturas.add(sp2);
    }


    public static void TablaDatosFacturas(int id){
        modelFacturas2.setRowCount(0);
        for (int i = 0; i <main.facturasA.size(); i++) {
            if(main.facturasA.get(i).getId() == id){
                ArrayList<ProductosFactura> producto = main.facturasA.get(i).getProducts();
                for (int j = 0; j < producto.size(); j++) {
                    modelFacturas2.addRow(new Object[]{producto.get(j).getName(), producto.get(j).getPrice()});
                }
            }
        }

    }




    public static void opciones(){
        int opcion;
        int opcionS;

        do{
        Scanner sc = new Scanner(System.in);
        opcion = sc.nextInt();

        switch (opcion) {

//selección de opción del menú principal
            case 1: {
                //Despliega la información del restaurante
                System.out.println("--------------INFORMACIÓN DEL RESTAURANTE--------------");
                    main.configs.ListarConfig();
                  //  Menu();
                break;
            }

            case 2: {
                //Despliega las opciones del submenú de usuarios
                SubmMenuUsers();
                break;
            }

            case 3: {
                //Despliega las opciones del submenú de productos
                SubmMenuProducts();
                break;
            }

            case 4: {
                //Despliega las opciones del submenú de clientes
                SubmMenuCliente();
                break;
            }
            case 5: {
                //Despliega las opciones del submenú de facturas
                SubmMenuFacturas();
                break;
            }
            case 6: {
                //Opcion para guardar los cambios en JSON o en Binario (Bin)
                System.out.println("Ingrese la opción que desea realizar: \n" +
                        "1. JSON\n" +
                        "2. Binario");
                opcionS = sc.nextInt();

                switch (opcionS){
                    case 1:{
                        //JSON - serializa los datos a JSON y los guarda
                        SerializacionJ();
                        textolog ="\n"+dtf.format(LocalDateTime.now())+"\t"+main.username+": Eliminó al cliente: Guardó los cambios por medio de Archivos JSON.";
                        Archivo.LogAcciones(textolog);
                        System.out.println("Se han guardado los cambios en archivos JSON.");
                        //Menu();
                        break;}
                    case 2: {
                        //JSON - serializa los datos a Binario y los guarda
                        SerializacionB();
                        textolog ="\n"+dtf.format(LocalDateTime.now())+"\t"+main.username+": Eliminó al cliente: Guardó los cambios por medio de Archivos Binarios.";
                        Archivo.LogAcciones(textolog);
                        System.out.println("Se han guardado los cambios en archivos Binarios.");
                        //Menu();
                        break;}
                    default:
                        System.out.println("Ha ingresado una opción incorrecta");
                }


                break;
            }
            //Cierre de sesión
            case 7: {
                textolog="\n"+dtf.format(LocalDateTime.now())+"\t"+main.username+": Ha cerrado sesión.";
                Archivo.LogAcciones(textolog);
                System.out.println("Ha cerrado sesión.\n");
                main.Login();
                break;
            }
            //Cierre del programa
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

   /* public static void Menu(){
        //Menú principal
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

    }*/


    public static void SubmMenuUsers(){
        //Menú usuarios
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
            //Opciones a elegir de usuarios
        do{
            Scanner sc = new Scanner(System.in);
            opcion2 = sc.nextInt();
            switch (opcion2){
                case 1:{
                    //Despliega a todos los usuarios únicos
                    ListadoUsers();
                    SubmMenuUsers();
                    break;
                }
                case 2:{
                    //Se elimina el usuario elegido por su user
                    System.out.println("Ingrese el nombre del usuario a eliminar:");
                    Scanner sc1 = new Scanner(System.in);
                    String nombre = sc1.nextLine();
                    //Manejo de error
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
                    //Despliega un usuario en específico
                    System.out.println("Ingrese el nombre del usuario que desea visualizar:");
                    Scanner sc1 = new Scanner(System.in);
                    String nombre = sc1.nextLine();
                    for (int i=0; i<main.usuariosA.size() ; i++) {
                        if (main.usuariosA.get(i).getUsername().equals(nombre)){
                            main.usuariosA.get(i).Listar(i+1);
                            SubmMenuUsers();
                        }
                    }
                    System.out.println("No se ha encontrado el usuario a visualizar.");
                    //Despliegue de submenú
                    SubmMenuUsers();
                    break;
                }
                case 4:{
                    //Regreso al menú principal
                    //Menu();
                    break;
                }
            }

        }while (opcion2!=4);
    }

    public static void SubmMenuProducts(){
        //Menú productos
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
            //Selección de opción
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextInt();
            switch (opcion){
                case 1:{
                    //Se listan todos los productos
                    ListadoProducts();
                    SubmMenuProducts();
                    break;
                }
                case 2:{
                    //Se elimina un producto por medio de su id
                    System.out.println("Ingrese el id del producto a eliminar:");
                    try{
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
                    }catch(InputMismatchException e){
                        System.out.println("Por favor, ingrese un id correcto.");
                        SubmMenuProducts();
                    }
                    break;
                }
                case 3:{
                    try{
                        //Por medio del ID se visualiza un producto en específico
                        System.out.println("Ingrese el id del producto a visualizar:");
                        Scanner sc1 = new Scanner(System.in);
                        int id = sc1.nextInt();
                        for (int i=0; i<main.productosA.size() ; i++) {
                            if (main.productosA.get(i).getId()==id){
                                main.productosA.get(i).ListarProducto(i+1);
                                SubmMenuProducts();
                            }
                        }
                        System.out.println("No se ha encontrado el producto a visualizar.");
                        SubmMenuProducts();
                    }catch(InputMismatchException e){
                        System.out.println("Por favor, ingrese un id correcto.");
                        SubmMenuProducts();
                    }
                    break;
                }
                case 4:{
                    //Regreso al menú principal
                    //Menu();
                    break;
                }
            }

        }while (opcion!=4);
    }

    public static void SubmMenuCliente(){
        //Menú de clientes
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
            //Selección de opción del submenú de clientes
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextInt();
            switch (opcion){
                case 1:{
                    //Listan todos los clientes
                    ListadoClientes();
                    SubmMenuCliente();
                    break;
                }
                case 2:{
                    try{
                        //Se elimina un cliente por medio de su id
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
                    }catch(InputMismatchException e){
                        System.out.println("Por favor, ingrese un id correcto.");
                        SubmMenuCliente();
                    }
                    break;
                }
                case 3:{
                    try{
                        //Se visualiza un cliente en específico
                        System.out.println("Ingrese el id del cliente que desea visualizar:");
                        Scanner sc1 = new Scanner(System.in);
                        int id = sc1.nextInt();
                        for (int i=0; i<main.clientesA.size() ; i++) {
                            if (main.clientesA.get(i).getId()==id){
                                main.clientesA.get(i).ListarClientes(i+1);
                                SubmMenuCliente();
                            }
                        }
                        System.out.println("No se ha encontrado el cliente a visualizar.");
                        SubmMenuCliente();
                        System.out.println();
                    }catch(InputMismatchException e){
                        System.out.println("Por favor, ingrese un id correcto.");
                        SubmMenuCliente();
                    }
                    break;
                }
                case 4:{
                    //Regreso al menú principal
                    //Menu();
                    break;
                }
            }

        }while (opcion!=4);
    }

    public static void SubmMenuFacturas(){
        //Menú de facturas
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
            //Selección de la opción del menú de facturas
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextInt();
            switch (opcion){
                case 1:{
                    //Se listan todas las facturas
                    ListadoFacturas();
                    SubmMenuFacturas();
                    break;
                }
                case 2:{
                    try{

                        //Se elimina una factura por medio de su id
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
                    }catch(InputMismatchException e){
                        System.out.println("Por favor, ingrese un id correcto.");
                        SubmMenuFacturas();
                    }

                    break;
                }
                case 3:{
                    try{
                        //Despliega una factura en específico
                        System.out.println("Ingrese el id de la factura que desea visualizar:");
                        Scanner sc1 = new Scanner(System.in);
                        int id = sc1.nextInt();
                        for (int i=0; i<main.facturasA.size() ; i++) {
                            if (main.facturasA.get(i).getId()==id){
                                main.facturasA.get(i).ListarFacturas(i+1);
                                SubmMenuFacturas();
                            }
                        }
                        System.out.println("No se ha encontrado la factura a visualizar.");
                        SubmMenuFacturas();
                    }catch(InputMismatchException e){
                        System.out.println("Por favor, ingrese un id correcto.");
                        SubmMenuFacturas();
                    }
                    break;
                }
                case 4:{
                    //Regresa al menú principal
                    //Menu();
                    break;
                }
            }

        }while (opcion!=4);
    }

    //Método que lista los users
    public static void ListadoUsers(){
    for (int i = 0; i <main.usuariosA.size(); i++) {
        main.usuariosA.get(i).Listar(i+1);
    }
}

    //Método que lista los productos
    public static void ListadoProducts(){
        for (int i = 0; i <main.productosA.size(); i++) {
            main.productosA.get(i).ListarProducto(i+1);
        }
    }

    //Método que lista los clientes
    public static void ListadoClientes(){
        for (int i = 0; i <main.clientesA.size(); i++) {
            main.clientesA.get(i).ListarClientes(i+1);
        }
    }

    //Método que lista las facturas
    public static void ListadoFacturas(){
        for (int i = 0; i <main.facturasA.size(); i++) {
            main.facturasA.get(i).ListarFacturas(i+1);
        }
    }

    //Método que serializa a Json
    public static void SerializacionJ(){
        Gson gson = new Gson();

        String JsonConfig = gson.toJson(main.configs);
        Archivo.writeOnFile("config.json",JsonConfig,false);

        String JsonUsuarios = gson.toJson(main.usuariosA);
        Archivo.writeOnFile("users.json",JsonUsuarios,false);

        String JsonClientes = gson.toJson(main.clientesA);
        Archivo.writeOnFile("clients.json",JsonClientes,false);

        String JsonProductos = gson.toJson(main.productosA);
        Archivo.writeOnFile("products.json",JsonProductos,false);

        String JsonFacturas = gson.toJson(main.facturasA);
        Archivo.writeOnFile("invoices.json",JsonFacturas,false);
    }

    //Método que serializa a Bin
    public static void SerializacionB(){
            Archivo.serialize("users.ipcrm", main.usuariosA);
            Archivo.serialize("clients.ipcrm", main.clientesA);
            Archivo.serialize("products.ipcrm", main.productosA);
            Archivo.serialize("invoices.ipcrm", main.facturasA);
    }
}
