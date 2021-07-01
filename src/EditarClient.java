import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;

public class EditarClient extends JFrame {
    public static JTextField txtID;
    public static JTextField txtNClient;
    public static JTextField txtAddress;
    public static JTextField txtPhone;
    public static JTextField txtNIT;
    String [] gen;
    JButton Agregar;

    public EditarClient(){
        this.setBounds(500, 220, 500, 600);
        this.setTitle("Editar Clientes");
        // CREACIÓN DE LAS LABELS:
        JLabel Titulo = new JLabel("Editar Clientes");
        this.add(Titulo);
        this.setResizable(false);
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
        txtID.setEditable(false);

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
        Agregar.setBounds(75, 390, 300, 40);
        Agregar.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                DefaultTableModel model = (DefaultTableModel)Menu.tableClientes.getModel();
                String id = txtID.getText();
                String nom = txtNClient.getText();
                String add = txtAddress.getText();
                String ph = txtPhone.getText();
                String nit = txtNIT.getText();

                model.setValueAt(id, Menu.tableClientes.getSelectedRow(), 0);
                model.setValueAt(nom, Menu.tableClientes.getSelectedRow(), 1);
                model.setValueAt(add, Menu.tableClientes.getSelectedRow(), 2);
                model.setValueAt(ph, Menu.tableClientes.getSelectedRow(), 3);
                model.setValueAt(nit, Menu.tableClientes.getSelectedRow(), 4);


                for (int i=0; i<main.clientesA.size() ; i++) {
                    if (main.clientesA.get(i).getId() == Integer.parseInt(Menu.idCliente)){
                        main.clientesA.get(i).setId(Integer.parseInt(id));
                        main.clientesA.get(i).setName(nom);
                        main.clientesA.get(i).setAddress(add);
                        main.clientesA.get(i).setPhone(Integer.parseInt(ph));
                        main.clientesA.get(i).setNit(nit);
                        EditarClient.super.dispose();
                    }
                }

            }

        });
    }

}
