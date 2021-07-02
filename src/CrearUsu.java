import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CrearUsu extends JFrame {

    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public static String textologA = "";
    public static JTextField txtUsu;
    public static JTextField txtPass;
    JButton Agregar;


    public static String a;
    public CrearUsu(){
        this.setBounds(500, 210, 500, 590);
        this.setTitle("AGREGAR NUEVO USUARIO");


        // CREACIÓN DE LAS LABELS:
        JLabel Titulo = new JLabel("Agregar un Nuevo Usuario");
        this.add(Titulo);
        this.setLayout(null);
        Titulo.setFont(new Font("Century Gothic", Font.BOLD, 24));
        Titulo.setBounds(70, 0, 500, 90);

        JLabel Codigo = new JLabel("Usuario: ");
        this.add(Codigo);
        this.setLayout(null);
        Codigo.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        Codigo.setBounds(20, 100, 500, 90);

        JLabel Nombre = new JLabel("Contraseña: ");
        this.add(Nombre);
        this.setLayout(null);
        Nombre.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        Nombre.setBounds(20, 150, 500, 90);
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

        //Boton para guardar
        Agregar = new JButton("Agregar");
        this.add(Agregar);
        Agregar.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        Agregar.setBackground(new Color(10, 166, 206));
        Agregar.setBounds(75, 450, 300, 40);


        Agregar.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                String s = "";
                boolean duplicado = false;
                if(txtUsu.getText().equals("")||txtPass.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Ingrese todos los datos");
                }else{
                    for (int i = 0; i < Menu.table.getRowCount(); i++) {
                        s = Menu.table.getValueAt(i, 0).toString().trim();

                        if (txtUsu.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "Ingrese todos los datos.");
                        } else {
                            if (txtUsu.getText().equals(s)) {
                                duplicado = true;
                                break;
                            }
                        }
                    }
                    if (!duplicado) {
                        Menu.FILA(new Object[]{
                                txtUsu.getText(),
                                txtPass.getText(),
                        });
                        String txt = txtUsu.getText();
                        String pass = txtPass.getText();

                        Usuario nuevo = new Usuario(txt,pass);
                        main.usuariosA.add(nuevo);
                        textologA="\n"+dtf.format(LocalDateTime.now())+"\t"+main.username+": Ha creado al usuario: "+txt+".";
                        Archivo.LogAcciones(textologA);
                        CrearUsu.super.dispose();


                    } else {
                        JOptionPane.showMessageDialog(null, "No es posible tener usuario repetido, inténtelo de nuevo.");
                    }
                }


            }

        });

    }
}
