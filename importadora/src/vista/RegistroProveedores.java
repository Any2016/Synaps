
package vista;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.*;

public class RegistroProveedores extends JFrame {
    
    private JLabel lbl[];
    private JTextField txt[];
    private JButton btn_cancelar;
    private JButton btn_guardar;
    private Utilidades util = new Utilidades();
    
    public RegistroProveedores (){
        initComponents();
    }
    
    private void initComponents(){
        this.setLayout(null);
        this.setTitle("REGISTRO DE PROVEEDORES");
        this.setSize(350, 350);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setBackground(new Color(242,242,242));
        
        txt = new JTextField[6];
        for (int i = 0; i < txt.length; i++) {
            txt[i] = new JTextField();
            txt[i].setFont(new Font("Calibri", 0, 15));
            txt[i].setBounds(110, (i + 1)*30, 160, 22);
            this.add(txt[i]);
        }
        ValidadorCampos vc = new ValidadorCampos();
        txt[0].addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt){
                vc.validarNombres(evt);
            }
        });
        txt[3].addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                vc.validarNombres(evt);
            }
        });
        txt[4].addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                vc.validarNumeros(evt);
            }
        });
        
        lbl = new JLabel[6];
        String campos[] = {"Nombre:", "CI / NIT:", "Pais", "Direccion:", "Telefono:", "Correo:"};
        for (int i = 0; i < lbl.length; i++) {
            lbl[i] = new JLabel(campos[i]);
            lbl[i].setFont(new Font("Calibri", 0, 15));
            lbl[i].setBounds(30, (i + 1)*30, 100, 22);
            this.add(lbl[i]);
        }
        btn_cancelar = util.btn("Cancelar", lbl[0].getX() - 10, lbl[lbl.length-1].getY() + 50);
        btn_cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {ActionPerformed("btn_cancelar");}
        });
        this.add(btn_cancelar);
        
        btn_guardar = util.btn("GUARDAR", btn_cancelar.getX() + btn_cancelar.getWidth() + 20, btn_cancelar.getY());
        btn_guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {ActionPerformed("btn_guardar");}
        });
        this.add(btn_guardar);
        
    }
    
    private void ActionPerformed(String opc){
        switch (opc) {
            case "btn_cancelar":
                this.dispose();
                break;
            case "btn_guardar":
                GuardarProveedor();
                break;
            default:
                throw new AssertionError();
        }
    }
    private void GuardarProveedor(){
        for (JTextField t : txt) {
            if (t.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Llenar todos los campos");
                return;
            }
        }
        ValidadorCampos vc = new ValidadorCampos();
        if (vc.validarCorreo(txt[5].getText())) {
            String query = "insert into proveedor values (null,'"+txt[1].getText()+"','"+txt[0].getText()+"','"+ txt[2].getText()+"','"+ txt[3].getText()+"','"+ txt[4].getText()+"','"+ txt[5].getText()+"')";
            
            ConexionBD con = new ConexionBD();
            if (con.conectar())
                if (con.consulta(query)){
                    JOptionPane.showMessageDialog(rootPane, "Se registro al proveedor con exito!!!");
                    this.dispose();
                }
        }
        else
            JOptionPane.showMessageDialog(rootPane, "correo no valido");
    }
    
    
    
}
