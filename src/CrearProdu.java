import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;

public class CrearProdu extends JFrame {
    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public static String textologA = "";
    public static JTextField txtUsu;
    public static JTextField txtPass,txtDescripcion,txtPrecio,txtCosto;
    public static JTextField txtApeP;
    public static JTextField txtCorreoP;
    JTextField txtContraseñaP;
    String [] genero;
    JButton Agregar;


    public static String a;
    public CrearProdu(){
        this.setBounds(500, 210, 500, 690);
        this.setTitle("AGREGAR NUEVO PRODUCTO");


        // CREACIÓN DE LAS LABELS:
        JLabel Titulo = new JLabel("Agregar un Nuevo Producto");
        this.add(Titulo);
        this.setLayout(null);
        Titulo.setFont(new Font("Century Gothic", Font.BOLD, 24));
        Titulo.setBounds(70, 0, 500, 90);

        JLabel Codigo = new JLabel("Id: ");
        this.add(Codigo);
        this.setLayout(null);
        Codigo.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        Codigo.setBounds(20, 100, 500, 90);

        JLabel Nombre = new JLabel("Nombre: ");
        this.add(Nombre);
        this.setLayout(null);
        Nombre.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        Nombre.setBounds(20, 150, 500, 90);

        JLabel Descripcion = new JLabel("Descripcion: ");
        this.add(Descripcion);
        this.setLayout(null);
        Descripcion.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        Descripcion.setBounds(20, 200, 500, 90);

        JLabel Costo = new JLabel("Costo: ");
        this.add(Costo);
        this.setLayout(null);
        Costo.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        Costo.setBounds(20, 250, 500, 90);

        JLabel precio = new JLabel("precio: ");
        this.add(precio);
        this.setLayout(null);
        precio.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        precio.setBounds(20, 300, 500, 90);


        // LUGAR DE INGRESO DE DATOS

        //Ingreso Código:
        txtUsu = new JTextField();
        this.add(txtUsu);
        txtUsu.setBounds(150,130,250,30);
        txtUsu.setFont(new Font("Century Gothic", Font.PLAIN, 20));

        //Ingreso Nombre:
        txtPass = new JTextField();
        this.add(txtPass);
        txtPass.setBounds(150,180,250,30);
        txtPass.setFont(new Font("Century Gothic", Font.PLAIN, 20));

        //Ingreso Descripcion:
        txtDescripcion = new JTextField();
        this.add(txtDescripcion);
        txtDescripcion.setBounds(150,230,250,30);
        txtDescripcion.setFont(new Font("Century Gothic", Font.PLAIN, 20));

        //Ingreso Costo:
        txtCosto = new JTextField();
        this.add(txtCosto);
        txtCosto.setBounds(150,280,250,30);
        txtCosto.setFont(new Font("Century Gothic", Font.PLAIN, 20));

        //Ingreso Precio:
        txtPrecio = new JTextField();
        this.add(txtPrecio);
        txtPrecio.setBounds(150,330,250,30);
        txtPrecio.setFont(new Font("Century Gothic", Font.PLAIN, 20));

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
                    if(txtUsu.getText().equals("")||txtPass.getText().equals("")||txtDescripcion.getText().equals("")||txtCosto.getText().equals("")||txtPrecio.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Ingrese todos los datos");
                    }else{
                        for (int i = 0; i < Menu.tableProductos.getRowCount(); i++) {
                            s = Menu.tableProductos.getValueAt(i, 0).toString().trim();

                            if (txtUsu.getText().equals(s)) {
                                duplicado = true;
                                break;
                            }

                        }
                        if (!duplicado) {

                            int id = Integer.parseInt(txtUsu.getText());
                            String nombre = txtPass.getText();
                            String descr = txtDescripcion.getText();
                            double cost = Double.parseDouble(txtCosto.getText());
                            double price = Double.parseDouble(txtPrecio.getText());

                            AgregarIngrediente AgrIngrediente = new AgregarIngrediente();
                            AgrIngrediente.RecibirDatos(id, nombre, descr, cost, price);
                            AgrIngrediente.getContentPane().setBackground(Color.ORANGE);
                            AgrIngrediente.setVisible(true);
                            CrearProdu.super.dispose();

                        } else {
                            JOptionPane.showMessageDialog(null, "No es posible tener producto repetido, inténtelo de nuevo.");
                        }
                    }
                }catch(NumberFormatException nbr){
                    JOptionPane.showMessageDialog(null, "Ha ingresado un dato erroneo.");
                }



            }

        });

    }
}
