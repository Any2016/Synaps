/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import modelo.ConexionBD;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class RegistrarPedido  extends JPanel implements Action{
    
    private JFrame jf;
    private JPanel jp;
    private JLabel titulo;
    private JLabel producto;
    private JLabel ci;
    private JLabel unidades;
    private JLabel subcategoria;
    private JLabel categoria;
    private JLabel observacion;
    private JTextField cProducto;
    private JTextField cCI;
    private JTextField cUnidades;
    private JTextField cSubcat;
    private JTextField cCategoria;   
    private JTextField cObservacion;
    private JButton registrar;
    private JButton cancelar;
    public RegistrarPedido(){
        
    }

    @Override
    public Object getValue(String string) {
       return null;
        
    }

    @Override
    public void putValue(String string, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        jf=new JFrame();
        jf.setSize(800, 500);
        jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        jp=new JPanel();
        jp.setLayout(null);
        jp.setBackground(Color.LIGHT_GRAY);
        
        titulo=new JLabel("Registro de pedido a enviar");
        titulo.setBounds(200,20,200,50);
        jp.add(titulo);
        producto=new JLabel("Nombre del producto:");
        producto.setBounds(100,60,150,20);
        jp.add(producto);
        ci=new JLabel("CI del cliente:");
        ci.setBounds(100,100,300,20);
        jp.add(ci);
        unidades=new JLabel("Unidades requeridas:");
        unidades.setBounds(100,140,300,20);
        jp.add(unidades);
        subcategoria=new JLabel("Subcategoria(int):");
        subcategoria.setBounds(100, 220, 300, 20);
        jp.add(subcategoria);
        categoria=new JLabel("Categoria(int):");
        categoria.setBounds(100,180,300,20);
        jp.add(categoria);
        observacion=new JLabel("Observacion(detalles):");
        observacion.setBounds(100, 260, 300, 20);
        jp.add(observacion);
        
        
        
        cProducto=new JTextField(20);
        cProducto.setBounds(450,60,150,20);
        jp.add(cProducto);
        cCI=new JTextField(20);
        cCI.setBounds(450,100,150,20);
        jp.add(cCI);
        cUnidades=new JTextField(20);
        cUnidades.setBounds(450,140,150,20);
        jp.add(cUnidades);
        cSubcat=new JTextField(20);
        cSubcat.setBounds(450, 220, 150, 20);
        jp.add(cSubcat);
        cCategoria=new JTextField(20);
        cCategoria.setBounds(450,180,150,20);
        jp.add(cCategoria);
        cObservacion=new JTextField(20);
        cObservacion.setBounds(450, 260, 150, 20);
        jp.add(cObservacion);
        
        
        cancelar=new JButton("Cancelar");
        cancelar.setBounds(200,350,100,30);
        jp.add(cancelar);
        registrar=new JButton("Registrar");
        registrar.setBounds(500,350,100,30);
        
        cancelar.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae2){
            jf.dispose();
        }});
        
        registrar.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae3){
            ConexionBD cn=new ConexionBD();
            if(!cProducto.getText().isEmpty()&&!cCI.getText().isEmpty()&&!cUnidades.getText().isEmpty()/*&&estaenbase(cCI)=true aca se podria implementar la verficiacion de si el ci que se introdujo esta en la base de datos*/){
            
             try{
             cn.conectar();
             cn.consulta("insert into pedidos(producto,ci,unidades,categoria,subcategoria,observacion) values('"+cProducto.getText()+"','"+cCI.getText()+"','"+cUnidades.getText()+"','"+cCategoria.getText()+"','"+cSubcat.getText()+"','"+cObservacion.getText()+"')");
             cProducto.setText("");
             cCI.setText("");
             cUnidades.setText("");
             cSubcat.setText("");
             cCategoria.setText("");
             cObservacion.setText("");
             JOptionPane.showMessageDialog(null, "Se guardó correctamente");
             cn.desconectar();
         }
         catch(Exception ex){
             JOptionPane.showMessageDialog(null, "Ocurrio un error en la conexión");
         }
        }else{
                JOptionPane.showMessageDialog(null, "Debe rellenar los campos");
                
            }
        }});
        
        jp.add(registrar);
        jf.add(jp);
        
        }
  
    
    public boolean estaenbase(String ci){
     return true;  
    }            
}