import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class VerFacturas extends JFrame {

    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public static String textologA = "";
    public static JTextField txtFecha,txtId,NOMBRES;
    public static JComboBox BoxClients;
    public static JComboBox BoxDia, BoxMes;
    JButton Agregar;
    public static String fecha;
    public static int idFactura,idCliente;
    public static DefaultTableModel modelFacturas2;
    public static JTable tableProductos2;


    public static String a;
    public VerFacturas(){
        this.setBounds(500, 210, 500, 700);
        this.setTitle("VER FACTURA");


        // CREACIÓN DE LAS LABELS:
        JLabel Titulo = new JLabel("Ver Factura");
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
        txtId.setEnabled(false);
        txtId.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        txtId.setBounds(150,130,250,30);

        txtFecha = new JTextField();
        this.add(txtFecha);
        this.setLayout(null);
        txtFecha.setEnabled(false);
        txtFecha.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        txtFecha.setBounds(150,230,250,30);

        NOMBRES = new JTextField();
        this.add(NOMBRES);
        this.setLayout(null);
        NOMBRES.setEnabled(false);
        NOMBRES.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        NOMBRES.setBounds(150,180,250,30);

//        String[] NOMBRES = ListadoClientes();
//        BoxClients = new JComboBox(NOMBRES);
//        BoxClients.setBounds(150,180,250,30);
//        this.add(BoxClients);


        modelFacturas2 = new DefaultTableModel();
        tableProductos2 = new JTable(modelFacturas2);
        tableProductos2.setRowHeight(20);
        tableProductos2.setFont(new Font("Century Gothic", 0, 13));
        modelFacturas2.addColumn("Name");
        modelFacturas2.addColumn("Price");
        TablaDatosFacturas(Menu.idF);
        JScrollPane sp2 = new JScrollPane(tableProductos2);
        sp2.setEnabled(false);
        sp2.setBounds(100,300,250,200);
        sp2.setVisible(true);
        this.add(sp2);



        //Boton para guardar
        Agregar = new JButton("Aceptar");
        this.add(Agregar);
        Agregar.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        Agregar.setBackground(new Color(10, 166, 206));
        Agregar.setBounds(75, 550, 300, 40);

        Agregar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                VerFacturas.super.dispose();

            }
        });


    }

    public static void TablaDatosFacturas(int id){
      //  modelFacturas2.setRowCount(0);
        for (int i = 0; i <main.facturasA.size(); i++) {
            if(main.facturasA.get(i).getId() == id){
                ArrayList<ProductosFactura> producto = main.facturasA.get(i).getProducts();
                for (int j = 0; j < producto.size(); j++) {
                    modelFacturas2.addRow(new Object[]{producto.get(j).getName(), producto.get(j).getPrice()});
                }
            }
        }

    }


}

