
package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.*;

public class frm_cliente extends JFrame {
    
    private JLabel lbl[];
    private JTextField txt[];
    private JButton btn_cancelar;
    private JButton btn_guardar;
    private Utilidades util = new Utilidades();
    private int id;
    
    public frm_cliente (int id) throws SQLException{//id = 0 --> es para registrar cliente nuevo; cualquier otro numero es para modificar
        this.id = id;
        initComponents();
        if (this.id != 0)
            CargarDatos();
    }
    
    private void initComponents(){
        this.setLayout(null);
        this.setTitle("REGISTRO DE CLIENTES");
        this.setSize(315, 330);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setBackground(new Color(242,242,242));
        
        JLabel titulo = new JLabel("Registro de cliente");
        titulo.setBounds(50, 10, 200, 24);
        titulo.setFont(new Font("Calibri", 1, 24));
        this.add(titulo);
        txt = new JTextField[6];
        for (int i = 0; i < txt.length; i++) {
            txt[i] = new JTextField();
            txt[i].setFont(new Font("Calibri", 0, 15));
            txt[i].setBounds(110, titulo.getY()+(i + 1)*30, 160, 22);
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
                vc.validarNumeros(evt);
            }
        });
        txt[4].addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                vc.validarNumeros(evt);
            }
        });
        
        lbl = new JLabel[6];
        String campos[] = {"Nombre:", "CI / NIT:", "Direccion:", "Telefono:", "Celular:", "Correo:"};
        for (int i = 0; i < lbl.length; i++) {
            lbl[i] = new JLabel(campos[i]);
            lbl[i].setFont(new Font("Calibri", 0, 15));
            lbl[i].setBounds(30, titulo.getY()+(i + 1)*30, 100, 22);
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
                GuardarCliente();
                break;
            default:
                throw new AssertionError();
        }
    }
    
    private void CargarDatos() throws SQLException{
        ConexionBD con=new ConexionBD();
        con.conectar();
        ResultSet resultado = con.seleccionar("select * from cliente where id_cliente = '" + id + "'");
        while (resultado.next()) {            
            txt[0].setText(resultado.getString("nombre"));
            txt[1].setText(resultado.getString("ci"));
            txt[2].setText(resultado.getString("direccion"));
            txt[3].setText(resultado.getString("telefono"));
            txt[4].setText(resultado.getString("celular"));
            txt[5].setText(resultado.getString("correo"));
        }
    }
    
    private void GuardarCliente(){
        for (JTextField t : txt) {
            if (t.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Llenar todos los campos");
                return;
            }
        }
        ValidadorCampos vc = new ValidadorCampos();
        if (vc.validarCorreo(txt[5].getText())) {
            String query;
            if (this.id != 0)//viene por aqui cuando es para modificar
                query = "update cliente set nombre='"+txt[0].getText()+"', ci='"+txt[1].getText()+"', direccion='"+txt[2].getText()+"', telefono='"+txt[3].getText()+"', celular='"+txt[4].getText()+"', correo='"+txt[5].getText()+"' where id_cliente='"+this.id+"'";
            else
                query = "insert into cliente values (null,'"+txt[1].getText()+"','"+txt[0].getText()+"','"+ txt[2].getText()+"','"+ txt[3].getText()+"','"+ txt[4].getText()+"','"+ txt[5].getText()+"')";
            
            ConexionBD con = new ConexionBD();
            if (con.conectar())
                if (con.consulta(query)){
                    JOptionPane.showMessageDialog(rootPane, "La operacion se realizo con exito!!!");
                    this.dispose();
                }
        }
        else
            JOptionPane.showMessageDialog(rootPane, "correo no valido");
    }
    
}
