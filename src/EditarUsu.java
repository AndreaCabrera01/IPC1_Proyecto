import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EditarUsu extends JFrame {
    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public static String textologA = "";
    public static JTextField txtUsu;
    public static JTextField txtContra;
    JButton Agregar;

        public EditarUsu(){
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

            //Ingreso usuario:
            txtUsu = new JTextField();
            this.add(txtUsu);
            txtUsu.setBounds(150,130,250,30);
            txtUsu.setFont(new Font("Century Gothic", Font.PLAIN, 20));

            //Ingreso de Contraseña
            txtContra = new JTextField();
            this.add(txtContra);
            txtContra.setBounds(150,180,250,30);
            txtContra.setFont(new Font("Century Gothic", Font.PLAIN, 20));


            //Boton para guardar
            Agregar = new JButton("Agregar");
            this.add(Agregar);
            Agregar.setFont(new Font("Century Gothic", Font.PLAIN, 18));
            Agregar.setBackground(new Color(10, 166, 206));
            Agregar.setBounds(75, 240, 300, 40);
            Agregar.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e) {
                    DefaultTableModel model = (DefaultTableModel)Menu.table.getModel();
                   // String cod =txtCodP.getText();
                    String nom =txtUsu.getText();
                    String pass =txtContra.getText();

                    model.setValueAt(nom, Menu.table.getSelectedRow(), 0);
                    model.setValueAt(pass, Menu.table.getSelectedRow(), 1);


                    for (int i=0; i<main.usuariosA.size() ; i++) {
                        if (main.usuariosA.get(i).getUsername().equals(Menu.usu)){
                            textologA="\n"+dtf.format(LocalDateTime.now())+"\t"+main.username+": Ha editado al usuario: "+Menu.usu+".";
                            Archivo.LogAcciones(textologA);
                            main.usuariosA.get(i).setUsername(nom);
                            main.usuariosA.get(i).setPassword(pass);
                            EditarUsu.super.dispose();
                        }
                    }





                }

            });
        }

}
