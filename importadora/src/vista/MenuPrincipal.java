package vista;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuPrincipal extends JFrame{
    
    public MenuPrincipal(){
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Menu m=new Menu();
        
        
        add(m);
        BorderLayout bl=new BorderLayout();
        setLayout(bl);
        add(m,BorderLayout.CENTER);
        JLabel titulo;
        titulo=new JLabel("Menu Importadora ");
        titulo.setFont(new java.awt.Font("Times New Roman", 0, 36));
        add(titulo,BorderLayout.LINE_START);
        
        
        JMenuBar barra=new JMenuBar();
        JMenu registrar=new JMenu("Registrar");
        
        RegistroPersona rp=new RegistroPersona();
        JMenuItem persona=new JMenuItem();
        persona.setText("Persona"); 
        persona.addActionListener(rp);
        
        RegistroInstitucion ri=new RegistroInstitucion();
        JMenuItem institucion=new JMenuItem();
        institucion.setText("Institución");
        institucion.addActionListener(ri);
        
        registrar.add(persona);
        registrar.add(institucion);
        barra.add(registrar);
        add(barra);
        
        
        
        JButton modificar=new JButton ("Modificar");
        modificar.addActionListener(null);
        add(modificar);
        
       
        FlowLayout nuevoorden=new FlowLayout(50,50,30);
        setLayout(nuevoorden);
       
    }
    
}
class Menu extends JPanel{
   
}