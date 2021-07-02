import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AgregarIngrediente extends JFrame{

    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public static String textologA = "";
    public static JTextField txtName, txtCantidad, txtUnits;
    JButton Agregar, Nuevo;
    public ArrayList<Ingredients> Ingredientes = new ArrayList<>();
    private int idProducto;
    private String nameProducto;
    private String descripcion;
    private double cost;
    private double price;

    public AgregarIngrediente(){
        this.setBounds(500, 210, 500, 430);
        this.setTitle("AGREGAR INGREDIENTES");


        // CREACIÓN DE LAS LABELS:
        JLabel Titulo = new JLabel("Agregar un Nuevo Ingrediente");
        this.add(Titulo);
        this.setLayout(null);
        Titulo.setFont(new Font("Century Gothic", Font.BOLD, 24));
        Titulo.setBounds(70, 0, 500, 90);

        JLabel id = new JLabel("Nombre: ");
        this.add(id);
        this.setLayout(null);
        id.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        id.setBounds(20, 100, 500, 90);

        JLabel Cliente = new JLabel("Cantidad: ");
        this.add(Cliente);
        this.setLayout(null);
        Cliente.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        Cliente.setBounds(20, 150, 500, 90);

        JLabel Fecha = new JLabel("Unidades: ");
        this.add(Fecha);
        this.setLayout(null);
        Fecha.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        Fecha.setBounds(20, 200, 500, 90);

        txtName = new JTextField();
        this.add(txtName);
        this.setLayout(null);
        txtName.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        txtName.setBounds(150,130,250,30);

        txtCantidad = new JTextField();
        this.add(txtCantidad);
        this.setLayout(null);
        txtCantidad.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        txtCantidad.setBounds(150,180,250,30);

        txtUnits = new JTextField();
        this.add(txtUnits);
        this.setLayout(null);
        txtUnits.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        txtUnits.setBounds(150,230,250,30);



        //Boton para guardar
        Agregar = new JButton("Guardar");
        this.add(Agregar);
        Agregar.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        Agregar.setBackground(new Color(10, 166, 206));
        Agregar.setBounds(75, 280, 300, 40);

        //Boton para Nuevo Ingrediente
        Nuevo = new JButton("Nuevo Ingrediente");
        this.add(Nuevo);
        Nuevo.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        Nuevo.setBackground(new Color(10, 166, 206));
        Nuevo.setBounds(75, 330, 300, 40);

        Agregar.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                try{
                    if(txtName.getText().equals("")||txtUnits.getText().equals("")||txtCantidad.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos");
                    }else{
                        GuardarDatosIngresados();
                        Producto nuevo = new Producto(idProducto, nameProducto, descripcion, cost, price, Ingredientes);
                        main.productosA.add(nuevo);
                        textologA="\n"+dtf.format(LocalDateTime.now())+"\t"+main.username+": Ha creado el producto \""+nameProducto+"\" con id: "+idProducto+".";
                        Archivo.LogAcciones(textologA);
                        Menu.FILAP(new Object[]{
                                idProducto,
                                nameProducto,
                                descripcion,
                                cost,
                                price
                        });
                        AgregarIngrediente.super.dispose();
                    }
                }catch(NumberFormatException nbr){
                    JOptionPane.showMessageDialog(null, "Ha ingresado un dato erroneo.");
                }

            }
        });

        Nuevo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
              GuardarDatosIngresados();
                txtCantidad.setText("");
                txtUnits.setText("");
                txtName.setText("");
                super.mouseClicked(e);
            }
        });
    }

    public void GuardarDatosIngresados(){
        try{
            String name = txtName.getText();
            String units = txtUnits.getText();
            int cant = Integer.parseInt(txtCantidad.getText());
            Ingredients ingrediente = new Ingredients(name, cant, units);
            Ingredientes.add(ingrediente);
        }catch(NumberFormatException nbr){
            JOptionPane.showMessageDialog(null, "Ha ingresado un dato erroneo.");
        }

    }


    public void RecibirDatos(int idProducto, String nameProducto,String descripcion, double cost, double price){
        this.idProducto = idProducto;
        this.nameProducto = nameProducto;
        this.descripcion = descripcion;
        this.cost = cost;
        this.price = price;
    }
}
