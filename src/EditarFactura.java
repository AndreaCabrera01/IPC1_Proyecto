import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditarFactura extends JFrame {
        public static JTextField txtCodP;
        public static JTextField txtNomP;
        public static JTextField txtApe;
        public static JTextField txtCorreoP;
        public static JComboBox listaGen;
        String [] gen;
        JButton Agregar;

        public EditarFactura(){
            this.setBounds(500, 210, 500, 400);
            this.setTitle("Editar Usuarios");
            // CREACIÓN DE LAS LABELS:
            JLabel Titulo = new JLabel("Editar Usuarios");
            this.add(Titulo);
            this.setResizable(false);
            this.setLayout(null);
            Titulo.setFont(new Font("Century Gothic", Font.BOLD, 24));
            Titulo.setBounds(70, 0, 500, 90);

            JLabel User = new JLabel("Usuario: ");
            this.add(User);
            this.setLayout(null);
            User.setFont(new Font("Century Gothic", Font.PLAIN, 20));
            User.setBounds(20, 100, 500, 90);

            JLabel Contraseña = new JLabel("Contraseña: ");
            this.add(Contraseña);
            this.setLayout(null);
            Contraseña.setFont(new Font("Century Gothic", Font.PLAIN, 20));
            Contraseña.setBounds(20, 150, 500, 90);


            //EDICIÓN DE DATOS

            //Ingreso Nombre:
            txtNomP = new JTextField();
            this.add(txtNomP);
            txtNomP.setBounds(150,130,250,30);
            txtNomP.setFont(new Font("Century Gothic", Font.PLAIN, 20));

            //Ingreso de Contraseña
            txtApe = new JTextField();
            this.add(txtApe);
            txtApe.setBounds(150,180,250,30);
            txtApe.setFont(new Font("Century Gothic", Font.PLAIN, 20));


            //Boton para guardar
            Agregar = new JButton("Agregar");
            this.add(Agregar);
            Agregar.setFont(new Font("Century Gothic", Font.PLAIN, 18));
            Agregar.setBackground(Color.LIGHT_GRAY);
            Agregar.setBounds(75, 240, 300, 40);
            Agregar.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e) {
                    DefaultTableModel model = (DefaultTableModel)Menu.table.getModel();
                    // String cod =txtCodP.getText();
                    String nom =txtNomP.getText();
                    String pass =txtApe.getText();

                    model.setValueAt(nom, Menu.table.getSelectedRow(), 0);
                    model.setValueAt(pass, Menu.table.getSelectedRow(), 1);
                }

            });
        }
}
