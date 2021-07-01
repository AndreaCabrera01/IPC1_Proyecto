import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CrearFactu extends JFrame {

    public static JTextField txtFecha,txtId;
    public static JComboBox BoxClients;
    JButton Agregar;


    public static String a;
    public CrearFactu(){
        this.setBounds(500, 210, 500, 690);
        this.setTitle("AGREGAR NUEVA FACTURA");


        // CREACIÓN DE LAS LABELS:
        JLabel Titulo = new JLabel("Agregar una Nueva Factura");
        this.add(Titulo);
        this.setLayout(null);
        Titulo.setFont(new Font("Century Gothic", Font.BOLD, 24));
        Titulo.setBounds(70, 0, 500, 90);

        JLabel id = new JLabel("Id: ");
        this.add(id);
        this.setLayout(null);
        id.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        id.setBounds(20, 100, 500, 90);

        JLabel Cliente = new JLabel("Cliente: ");
        this.add(Cliente);
        this.setLayout(null);
        Cliente.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        Cliente.setBounds(20, 150, 500, 90);

        JLabel Fecha = new JLabel("Fecha: ");
        this.add(Fecha);
        this.setLayout(null);
        Fecha.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        Fecha.setBounds(20, 200, 500, 90);



        // LUGAR DE INGRESO DE DATOS
         txtId = new JTextField();
        this.add(txtId);
        this.setLayout(null);
        txtId.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        txtId.setBounds(150,130,250,30);

        txtFecha = new JTextField();
        this.add(txtFecha);
        this.setLayout(null);
        txtFecha.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        txtFecha.setBounds(150,230,250,30);


        String[] NOMBRES = new String[3];
        NOMBRES[0]="n1";
        NOMBRES[1]="n2";
        NOMBRES[2]="n3";
        BoxClients = new JComboBox(NOMBRES);
        BoxClients.setBounds(150,180,250,30);

        this.add(BoxClients);



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
                for (int i = 0; i <main.facturasA.size(); i++) {
                    if (Integer.parseInt(txtId.getText())==main.facturasA.get(i).getId()) {
                      duplicado=true;
                    }
                }
                if (!duplicado) {
                    Menu.FILAP(new Object[]{
                            txtId.getText(),
                            BoxClients.getSelectedItem(),
                            txtFecha.getText()

                    });
                    int id = Integer.parseInt(txtId.getText());
                    String cliente = BoxClients.getSelectedItem().toString();
                    String fecha = txtFecha.getText();

                    Factura nuevo = new Factura(id,1,fecha);
                    main.facturasA.add(nuevo);
//                    nuevo.setIngredients();

                    CrearFactu.super.dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "No es posible tener Id repetido, inténtelo de nuevo.");
                }

            }

        });

    }

}
