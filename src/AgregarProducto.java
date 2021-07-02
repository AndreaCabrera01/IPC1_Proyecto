import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AgregarProducto extends JFrame {

    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public static String textologA = "";
    public static JTextField txtPrecio;
    public static JComboBox BoxProductos;
    JButton Agregar, Nuevo;
    public ArrayList<ProductosFactura> Producto = new ArrayList<>();
    private String fecha, nombreCliente;
    private int idFactura,idCliente;

    public AgregarProducto(){
        this.setBounds(500, 210, 500, 690);
        this.setTitle("AGREGAR PRODUCTO");


        // CREACIÓN DE LAS LABELS:
        JLabel Titulo = new JLabel("Agregar un Producto a Factura");
        this.add(Titulo);
        this.setLayout(null);
        Titulo.setFont(new Font("Century Gothic", Font.BOLD, 24));
        Titulo.setBounds(70, 0, 500, 90);

        JLabel id = new JLabel("Producto: ");
        this.add(id);
        this.setLayout(null);
        id.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        id.setBounds(20, 100, 500, 90);

        JLabel Cliente = new JLabel("Precio: ");
        this.add(Cliente);
        this.setLayout(null);
        Cliente.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        Cliente.setBounds(20, 150, 500, 90);


        String[] NOMBRES = ListadoProductos();
        BoxProductos = new JComboBox(NOMBRES);
        BoxProductos.setBounds(150,130,250,30);
        this.add(BoxProductos);

        txtPrecio = new JTextField();
        this.add(txtPrecio);
        this.setLayout(null);
        txtPrecio.setEnabled(false);
        txtPrecio.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        txtPrecio.setBounds(150,180,250,30);


        //Boton para guardar
        Agregar = new JButton("Guardar");
        this.add(Agregar);
        Agregar.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        Agregar.setBackground(Color.LIGHT_GRAY);
        Agregar.setBounds(75, 280, 300, 40);

        //Boton para Nuevo Producto
        Nuevo = new JButton("Nuevo Producto");
        this.add(Nuevo);
        Nuevo.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        Nuevo.setBackground(Color.LIGHT_GRAY);
        Nuevo.setBounds(75, 230, 300, 40);

        BoxProductos.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String producto = BoxProductos.getSelectedItem().toString();
                if(!producto.equals("Seleccione un producto")){
                    String[] datosProducto = producto.split("-");

                    for (int i = 0; i < main.productosA.size(); i++) {
                        if(Integer.parseInt(datosProducto[0])== main.productosA.get(i).getId()){
                            txtPrecio.setText(String.valueOf(main.productosA.get(i).getPrice()));
                        }
                    }
                }else{
                    txtPrecio.setText("");
                }
            }
        });


        Agregar.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(BoxProductos.getSelectedItem().equals("Seleccione un producto")){
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione un producto para añadir a la factura");
                }else{
                    GuardarDatosIngresados();
                    Factura nuevo = new Factura(idFactura,idCliente,fecha, Producto);
                    textologA="\n"+dtf.format(LocalDateTime.now())+"\t"+main.username+": Ha creado la factura con id: "+idFactura+".";
                    Archivo.LogAcciones(textologA);
                    main.facturasA.add(nuevo);
                    Menu.FILAF(new Object[]{
                            idFactura,
                            nombreCliente,
                            fecha

                    });
                    AgregarProducto.super.dispose();
                }
            }

        });

        Nuevo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(BoxProductos.getSelectedItem().equals("Seleccione un producto")){
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione un producto para añadir a la factura");
                }else{
                GuardarDatosIngresados();

                BoxProductos.setSelectedIndex(0);
                txtPrecio.setText("");
                }
                    super.mouseClicked(e);
            }
        });
    }

    public String[] ListadoProductos(){
        String[] nombresProductos = new String[main.productosA.size()+1];
        nombresProductos[0]="Seleccione un producto";
        for (int i = 0; i < main.productosA.size(); i++) {
            nombresProductos[i+1]=main.productosA.get(i).getId()+"-"+main.productosA.get(i).getName();
        }
        return nombresProductos;
    }

    public void GuardarDatosIngresados(){
            try{
                String producto = BoxProductos.getSelectedItem().toString();
                String[] datosProducto = producto.split("-");
                ProductosFactura productosfactura = new ProductosFactura(datosProducto[1], Double.parseDouble(txtPrecio.getText()));
                Producto.add(productosfactura);
            }catch(NumberFormatException nbr){
                JOptionPane.showMessageDialog(null, "Ha ingresado un dato erroneo.");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }


    }

    public void RecibirDatos(int idFactura, int idCliente,String nombreCliente, String fecha){
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
    }



}
