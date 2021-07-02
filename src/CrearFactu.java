import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CrearFactu extends JFrame {

    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public static String textologA = "";
    public static JTextField txtFecha,txtId;
    public static JComboBox BoxClients;
    public static JComboBox BoxDia, BoxMes;
    JButton Agregar;
    public static String fecha;
     public static int idFactura,idCliente;


    public static String a;
    public CrearFactu(){
        this.setBounds(500, 210, 500, 400);
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
        txtFecha.setBounds(150,230,100,30);

        String[] dias = new String[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        BoxDia = new JComboBox(dias);
        BoxDia.setBounds(350,230,80,30);
        this.add(BoxDia);

        String[] mes = new String[]{"01","02","03","04","05","06","07","08","09","10","11","12"};
        BoxMes = new JComboBox(mes);
        BoxMes.setBounds(260,230,80,30);
        this.add(BoxMes);


        String[] NOMBRES = ListadoClientes();
        BoxClients = new JComboBox(NOMBRES);
        BoxClients.setBounds(150,180,250,30);
        this.add(BoxClients);



        //Boton para guardar
        Agregar = new JButton("Siguiente");
        this.add(Agregar);
        Agregar.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        Agregar.setBackground(new Color(10, 166, 206));
        Agregar.setBounds(75, 300, 300, 40);


        Agregar.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                String s = "";
                boolean duplicado = false;
                try{
                    if(txtId.getText().equals("")||txtFecha.getText().equals("")||BoxClients.getSelectedItem().equals("Seleccione un Cliente")){
                        JOptionPane.showMessageDialog(null, "Ingrese todos los datos.");
                    }else{
                        for (int i = 0; i <main.facturasA.size(); i++) {
                            if (Integer.parseInt(txtId.getText())==main.facturasA.get(i).getId()) {
                                duplicado=true;
                            }
                        }
                        if (!duplicado) {
                            String cliente = BoxClients.getSelectedItem().toString();
                            String[] datosCliente = cliente.split("-");

                            String año = txtFecha.getText();
                            String mes = BoxMes.getSelectedItem().toString();
                            String dia = BoxDia.getSelectedItem().toString();

                            idFactura = Integer.parseInt(txtId.getText());
                            String nombreCliente = datosCliente[1];
                            idCliente = Integer.parseInt(datosCliente[0]);
                            fecha = año+"-"+mes+"-"+dia;

                            AgregarProducto AgrPro = new AgregarProducto();
                            AgrPro.RecibirDatos(idFactura,idCliente,nombreCliente,fecha);
                            AgrPro.getContentPane().setBackground(new Color(159, 167, 53));
                            AgrPro.setVisible(true);
                            CrearFactu.super.dispose();

                        } else {
                            JOptionPane.showMessageDialog(null, "No es posible tener Id repetido, inténtelo de nuevo.");
                        }
                    }
                }catch(NumberFormatException nbr){
                    JOptionPane.showMessageDialog(null, "Ha ingresado un dato erroneo.");
                }
            }
        });

    }

    public String[] ListadoClientes(){
        String[] nombresClientes = new String[main.clientesA.size()+1];
        nombresClientes[0]="Seleccione un Cliente";
        for (int i = 0; i < main.clientesA.size(); i++) {
            nombresClientes[i+1]=main.clientesA.get(i).getId()+"-"+main.clientesA.get(i).getName();
        }
        return nombresClientes;
    }






}
