package vista;
import controlador.BuscarCliente;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuPrincipal extends JFrame{
    private Utilidades util = new Utilidades();
    public MenuPrincipal(){
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JLabel titulo;
        titulo=new JLabel("Menu Importadora ");
        titulo.setFont(new java.awt.Font("Times New Roman", 0, 36));
        add(titulo,BorderLayout.LINE_START);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////        
        BuscarCliente bc=new BuscarCliente();
        JButton modificar=util.btn("Buscar Cliente", 50, 50);   
        modificar.addActionListener(bc);
        add(modificar);
        
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////       
        RegistrarPedido rped=new RegistrarPedido();
        JButton pedido=new JButton ();
        pedido=util.btn("Registrar pedido", 50, 50);   
        pedido.addActionListener(rped);
        add(pedido);



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        FlowLayout nuevoorden=new FlowLayout(50,50,30);
        setLayout(nuevoorden);
        
        JButton btn_cliente = util.btn("Registro de Cliente", 50, 50);
        btn_cliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new frm_cliente(0).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        this.add(btn_cliente);
        
        JButton btn_proveedores = util.btn("Registro de Proveedores", 50, 50);
        btn_proveedores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistroProveedores().setVisible(true);
            }
        });
        this.add(btn_proveedores);
        
        
        
        
        
        
    }
    
}