import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class EditIngredientes extends JFrame{

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

    public EditIngredientes(){
        this.setBounds(500, 210, 500, 420);
        this.setTitle("EDITAR INGREDIENTE");


        // CREACIÓN DE LAS LABELS:
        JLabel Titulo = new JLabel("Editar un Ingrediente");
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
        Agregar.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                GuardarDatosIngresados();
                EditIngredientes.super.dispose();
            }

        });


    }

    public void GuardarDatosIngresados(){
        try{
            if(txtName.getText().equals("")||txtUnits.getText().equals("")||txtCantidad.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos");
            }else{
                DefaultTableModel model = (DefaultTableModel)Menu.tableIngredientes.getModel();
                String name = txtName.getText();
                String units = txtUnits.getText();
                int cant = Integer.parseInt(txtCantidad.getText());

                for (int i=0; i<main.productosA.size() ; i++) {
                    if (main.productosA.get(i).getId()== Integer.parseInt(Menu.idP2)){
                        for (int j = 0; j < main.productosA.get(i).getIngredients().size(); j++) {
                            if(main.productosA.get(i).getIngredients().get(j).getName().equals(Menu.nameI)){
                                main.productosA.get(i).getIngredients().get(j).setName(name);
                                main.productosA.get(i).getIngredients().get(j).setQuantity(cant);
                                main.productosA.get(i).getIngredients().get(j).setUnits(units);
                                textologA="\n"+dtf.format(LocalDateTime.now())+"\t"+main.username+": Ha editado los ingredientes del producto con id: "+Menu.idP2+".";
                                Archivo.LogAcciones(textologA);
                            }
                        }
                    }
                }
                model.setValueAt(name, Menu.tableIngredientes.getSelectedRow(), 0);
                model.setValueAt(String.valueOf(cant), Menu.tableIngredientes.getSelectedRow(), 1);
                model.setValueAt(units, Menu.tableIngredientes.getSelectedRow(), 2);


                EditIngredientes.super.dispose();

            }
        }catch(NumberFormatException nbr){
            JOptionPane.showMessageDialog(null, "Ha ingresado un dato erroneo.");
        }

    }


}
