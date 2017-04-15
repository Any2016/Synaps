package vista;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuPrincipal extends JFrame{
    private Utilidades util = new Utilidades();
    public MenuPrincipal(){
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
//        Menu m=new Menu();
//        
//        
//        add(m);
//        BorderLayout bl=new BorderLayout();
//        setLayout(bl);
//        add(m,BorderLayout.CENTER);
        JLabel titulo;
        titulo=new JLabel("Menu Importadora ");
        titulo.setFont(new java.awt.Font("Times New Roman", 0, 36));
        add(titulo,BorderLayout.LINE_START);
        
        
        JButton modificar=new JButton ("Modificar");
        modificar.addActionListener(null);
        add(modificar);
        
       
        FlowLayout nuevoorden=new FlowLayout(50,50,30);
        setLayout(nuevoorden);
        
        JButton btn_cliente = util.btn("Registro de Cliente", 50, 50);
        btn_cliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new frm_cliente().setVisible(true);
            }
        });
        this.add(btn_cliente);
    }
    
}