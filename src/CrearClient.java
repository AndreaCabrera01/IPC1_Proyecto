import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CrearClient extends JFrame {

    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public static String textologA = "";
    public static JTextField txtID;
    public static JTextField txtNClient;
    public static JTextField txtAddress;
    public static JTextField txtPhone;
    public static JTextField txtNIT;
    JButton Agregar;


    public static String a;
    public CrearClient(){
        this.setBounds(500, 210, 500, 590);
        this.setTitle("AGREGAR NUEVO CLIENTE");


        // CREACIÓN DE LAS LABELS:
        JLabel Titulo = new JLabel("Agregar un Nuevo Cliente");
        this.add(Titulo);
        this.setLayout(null);
        Titulo.setFont(new Font("Century Gothic", Font.BOLD, 24));
        Titulo.setBounds(70, 0, 500, 90);

        JLabel ID = new JLabel("ID: ");
        this.add(ID);
        this.setLayout(null);
        ID.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        ID.setBounds(20, 100, 500, 90);

        JLabel Nombre = new JLabel("Nombre: ");
        this.add(Nombre);
        this.setLayout(null);
        Nombre.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        Nombre.setBounds(20, 150, 500, 90);

        JLabel Direccion = new JLabel("Dirección: ");
        this.add(Direccion);
        this.setLayout(null);
        Direccion.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        Direccion.setBounds(20, 200, 500, 90);

        JLabel phone = new JLabel("Teléfono: ");
        this.add(phone);
        this.setLayout(null);
        phone.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        phone.setBounds(20, 250, 500, 90);

        JLabel NIT = new JLabel("NIT: ");
        this.add(NIT);
        this.setLayout(null);
        NIT.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        NIT.setBounds(20, 300, 500, 90);


        //EDICIÓN DE DATOS

        //Ingreso ID:
        txtID = new JTextField();
        this.add(txtID);
        txtID.setBounds(150,130,250,30);
        txtID.setFont(new Font("Century Gothic", Font.PLAIN, 20));

        //Ingreso de Contraseña
        txtNClient = new JTextField();
        this.add(txtNClient);
        txtNClient.setBounds(150,180,250,30);
        txtNClient.setFont(new Font("Century Gothic", Font.PLAIN, 20));

        txtAddress = new JTextField();
        this.add(txtAddress);
        txtAddress.setBounds(150,230,250,30);
        txtAddress.setFont(new Font("Century Gothic", Font.PLAIN, 20));

        txtPhone= new JTextField();
        this.add(txtPhone);
        txtPhone.setBounds(150,280,250,30);
        txtPhone.setFont(new Font("Century Gothic", Font.PLAIN, 20));

        txtNIT= new JTextField();
        this.add(txtNIT);
        txtNIT.setBounds(150,330,250,30);
        txtNIT.setFont(new Font("Century Gothic", Font.PLAIN, 20));


        //Boton para guardar
        Agregar = new JButton("Agregar");
        this.add(Agregar);
        Agregar.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        Agregar.setBackground(Color.LIGHT_GRAY);
        Agregar.setBounds(75, 450, 300, 40);


        Agregar.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                String s = "";
                boolean duplicado = false;
                try{
                    if(txtID.getText().equals("")||txtNClient.getText().equals("")||txtAddress.getText().equals("")||txtPhone.getText().equals("")||txtNIT.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Ingrese todos los datos.");
                    }else{
                        for (int i = 0; i < Menu.tableClientes.getRowCount(); i++) {
                            s = Menu.tableClientes.getValueAt(i, 0).toString().trim();

                            if (txtID.getText().equals("")) {
                                JOptionPane.showMessageDialog(null, "Ingrese todos los datos.");
                            } else {
                                if (txtID.getText().equals(s)) {
                                    duplicado = true;
                                    break;
                                }
                            }
                        }
                        if (!duplicado) {
                            int ID = Integer.parseInt(txtID.getText());
                            String Nom = txtNClient.getText();
                            String Add = txtAddress.getText();
                            int Phone = Integer.parseInt(txtPhone.getText());
                            String NIT = txtNIT.getText();

                            Menu.FILAC(new Object[]{txtID.getText(), txtNClient.getText(),txtAddress.getText(), txtPhone.getText(), txtNIT.getText()});


                            Cliente nuevo = new Cliente(ID, Nom, Add, Phone, NIT);
                            main.clientesA.add(nuevo);
                            textologA="\n"+dtf.format(LocalDateTime.now())+"\t"+main.username+": Ha creado al cliente con id: "+ID+".";
                            Archivo.LogAcciones(textologA);
                            CrearClient.super.dispose();

                        } else {
                            JOptionPane.showMessageDialog(null, "No es posible tener usuario repetido, inténtelo de nuevo.");
                        }
                    }
                }catch(NumberFormatException nbr){
                    JOptionPane.showMessageDialog(null, "Ha ingresado un dato erroneo.");
                }
            }

        });

    }
}
