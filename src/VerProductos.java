import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VerProductos  extends JFrame {
    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public static String textologA = "";
    public static JTextField txtUsu,txtPass,txtDescripcion,txtCosto,txtPrecio;

    JButton Agregar;

    public VerProductos(){
        this.setBounds(500, 210, 500, 500);
        this.setTitle("Editar producto");
        // CREACIÓN DE LAS LABELS:
        JLabel Titulo = new JLabel("Producto");
        this.add(Titulo);
        this.setLayout(null);
        Titulo.setFont(new Font("Century Gothic", Font.BOLD, 24));
        Titulo.setBounds(140, 0, 500, 90);

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
        txtUsu.setEnabled(false);
        txtUsu.setBounds(150,130,250,30);
        txtUsu.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        txtUsu.setEditable(false);

        //Ingreso Nombre:
        txtPass = new JTextField();
        this.add(txtPass);
        txtPass.setBounds(150,180,250,30);
        txtPass.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        txtPass.setEditable(false);

        //Ingreso Descripcion:
        txtDescripcion = new JTextField();
        this.add(txtDescripcion);
        txtDescripcion.setBounds(150,230,250,30);
        txtDescripcion.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        txtDescripcion.setEditable(false);

        //Ingreso Costo:
        txtCosto = new JTextField();
        this.add(txtCosto);
        txtCosto.setBounds(150,280,250,30);
        txtCosto.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        txtCosto.setEditable(false);

        //Ingreso Precio:
        txtPrecio = new JTextField();
        this.add(txtPrecio);
        txtPrecio.setBounds(150,330,250,30);
        txtPrecio.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        txtPrecio.setEditable(false);

        //Boton para guardar
        Agregar = new JButton("Aceptar");
        this.add(Agregar);
        Agregar.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        Agregar.setBackground(new Color(10, 166, 206));
        Agregar.setBounds(75, 380, 300, 40);
        Agregar.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                try{
                    DefaultTableModel model = (DefaultTableModel)Menu.tableProductos.getModel();
                    int id = Integer.parseInt(txtUsu.getText());
                    String name =txtPass.getText();
                    String desc =txtDescripcion.getText();
                    double cost = Double.parseDouble(txtCosto.getText());
                    double price = Double.parseDouble(txtPrecio.getText());


                    for (int i=0; i<main.productosA.size() ; i++) {
                        if (main.productosA.get(i).getId()== Integer.parseInt(Menu.idP)){
                            textologA="\n"+dtf.format(LocalDateTime.now())+"\t"+main.username+": Ha visto el producto \""+main.productosA.get(i).getName()+"\" con id: "+Menu.idP+".";
                            main.productosA.get(i).setName(name);
                            main.productosA.get(i).setDescription(desc);
                            main.productosA.get(i).setCost(cost);
                            main.productosA.get(i).setPrice(price);

                            Archivo.LogAcciones(textologA);

                            VerProductos.super.dispose();
                        }
                    }

                    model.setValueAt(String.valueOf(id), Menu.tableProductos.getSelectedRow(), 0);
                    model.setValueAt(name, Menu.tableProductos.getSelectedRow(), 1);
                    model.setValueAt(desc, Menu.tableProductos.getSelectedRow(), 2);
                    model.setValueAt(String.valueOf(cost), Menu.tableProductos.getSelectedRow(), 3);
                    model.setValueAt(String.valueOf(price), Menu.tableProductos.getSelectedRow(), 4);

                }catch(NumberFormatException nbr){
                    JOptionPane.showMessageDialog(null, "Ha ingresado un dato erroneo.");
                }

            }

        });
    }
}
