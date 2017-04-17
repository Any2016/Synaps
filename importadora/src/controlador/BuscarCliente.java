package controlador;

import modelo.ConexionBD;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import modelo.ValidadorCampos;
public class BuscarCliente extends JPanel implements ActionListener{
    private JFrame mB;
    private JPanel lB;
    private JLabel etiqueta1;
    private JButton botonBuscar;
    private JTextField campoBusqueda;
    private ResultSet resultado;
     
    private JFrame jframeMod;
    private JPanel jpanelMod; 
    private JLabel nombreMod;
    private JLabel ciMod;
    private JLabel direccionMod;
    private JLabel telefonoMod;
    private JLabel celularMod;
    private JLabel correoMod;
    private JTextField cNombreMod;
    private JTextField cCIMod;
    private JTextField cDireccionMod;
    private JTextField cTelefonoMod;
    private JTextField cCelularMod;   
    private JTextField cCorreoMod;
    private JButton registrarMod;
    private JButton cancelarMod;
    
    private JLabel cnombreMod;
    private JLabel cciMod;
    private JLabel cdireccionMod;
    private JLabel ctelefonoMod;
    private JLabel ccelularMod;
    private JLabel ccorreoMod;
    private JTextField ccNombreMod;
    private JTextField ccCIMod;
    private JTextField ccDireccionMod;
    private JTextField ccTelefonoMod;
    private JTextField ccCelularMod;   
    private JTextField ccCorreoMod;
    
    private String nse;
    private String cse;
    private String dse;
    private String tse;
    private String celse;
    private String cose;

    public BuscarCliente(){
    
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        mB=new JFrame("Busqueda");
        mB.setSize(300, 100);
        mB.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        mB.setLocationRelativeTo(null);
        mB.setVisible(true);

        lB=new JPanel();

        Font fuente=new Font("Cambria", 2, 14);
        etiqueta1=new JLabel("NIT:");
        etiqueta1.setFont(fuente);
        
        botonBuscar=new JButton("Buscar");
        botonBuscar.setFont(fuente);
        campoBusqueda=new JTextField(10);
        
    
        botonBuscar.addActionListener(new ActionListener(){
            
        public void actionPerformed(ActionEvent e){
             ConexionBD buscar=new ConexionBD();
             
            if(!campoBusqueda.getText().isEmpty()){
            try{
                 
                buscar.conectar();
                String nombre="";
                String ci="";
                String direccion="";
                String telefono="";
                String celular="";
                String correo="";
                resultado=buscar.seleccionar("select * from cliente where ci="+campoBusqueda.getText()+"");
                
                while (resultado.next()){
                nombre = resultado.getString("nombre");
                ci = resultado.getString("ci");
                direccion = resultado.getString("direccion");
                telefono = resultado.getString("telefono");
                celular = resultado.getString("celular");
                correo = resultado.getString("correo");
                mB.setVisible(false);
                if(!nombre.isEmpty()){
                jframeMod=new JFrame("MODIFICAR INFORMACION DEL CLIENTE");
                jframeMod.setSize(500, 350);
                jframeMod.setLocationRelativeTo(null);
                jframeMod.setVisible(true);
                
                jpanelMod=new JPanel();
                jpanelMod.setLayout(null);
                nombreMod=new JLabel("Nombre:");
                nombreMod.setBounds(120,60,150,20);
                jpanelMod.add(nombreMod);
                ciMod=new JLabel("CI:");
                ciMod.setBounds(120,90,150,20);
                jpanelMod.add(ciMod);
                direccionMod=new JLabel("Dirección:");
                direccionMod.setBounds(120,120,150,20);
                jpanelMod.add(direccionMod);
                telefonoMod=new JLabel("Teléfono:");
                telefonoMod.setBounds(120,150,150,20);
                jpanelMod.add(telefonoMod);
                celularMod=new JLabel("Celular:");
                celularMod.setBounds(120,180,150,20);
                jpanelMod.add(celularMod);
                correoMod=new JLabel("Correo:");
                correoMod.setBounds(120, 210, 150, 20);
                jpanelMod.add(correoMod);
                cancelarMod=new JButton("Cancelar");
                cancelarMod.setBounds(200,270,100,20);
                
                cancelarMod.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent can){
                jframeMod.dispose();
                }});
                jpanelMod.add(cancelarMod);
         
                
                cNombreMod=new JTextField(20);
                cNombreMod.setBounds(220,60,150,20);
                jpanelMod.add(cNombreMod);
                cCIMod=new JTextField(20);
                cCIMod.setBounds(220,90,150,20);
                jpanelMod.add(cCIMod);
                cDireccionMod=new JTextField(20);
                cDireccionMod.setBounds(220,120,150,20);
                jpanelMod.add(cDireccionMod);
                cTelefonoMod=new JTextField(20);
                cTelefonoMod.setBounds(220,150,150,20);
                jpanelMod.add(cTelefonoMod);
                cCelularMod=new JTextField(20);
                cCelularMod.setBounds(220,180,150,20);
                jpanelMod.add(cCelularMod);
                cCorreoMod=new JTextField(20);
                cCorreoMod.setBounds(220, 210, 150, 20);
                jpanelMod.add(cCorreoMod);
                
                cNombreMod.setText(nombre);
                cCIMod.setText(ci);
                cDireccionMod.setText(direccion);
                cTelefonoMod.setText(telefono);
                cCelularMod.setText(celular);
                cCorreoMod.setText(correo);

                registrarMod=new JButton("Registrar");
                registrarMod.setBounds(320,270,100,20);
                jpanelMod.add(registrarMod);
                registrarMod.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae3){
                ConexionBD cn=new ConexionBD();
               // RegistroPersona regMod=new RegistroPersona();
                ValidadorCampos regMod=new ValidadorCampos();
                
                if(!cNombreMod.getText().isEmpty()&&!cCIMod.getText().isEmpty()&&!cDireccionMod.getText().isEmpty()){
                if(!regMod.validarNombre(cNombreMod)&&!regMod.validarDireccion(cDireccionMod)&&regMod.validarCorreo2(cCorreoMod)){
                
                   String n=cNombreMod.getText();
                   String nse=regMod.quitarEspacios(n);
                
                   String c=cCIMod.getText();
                   String cse=regMod.quitarEspacios(c);
                
                   String d=cDireccionMod.getText();
                   String dse=regMod.quitarEspacios(d);
               
                   String t=cTelefonoMod.getText();
                   String tse=regMod.quitarEspacios(t);
                
                   String cel=cCelularMod.getText();
                   String celse=regMod.quitarEspacios(cel);
                
                   String co=cCorreoMod.getText();
                   String cose=regMod.quitarEspacios(co);
                
            try{
             cn.conectar();
             cn.consulta("update cliente set nombre='"+nse.trim()+"', ci='"+cse.trim()+"', direccion='"+dse.trim()+"', telefono='"+tse.trim()+"', celular='"+celse.trim()+"', correo='"+cose.trim()+"' where ci='"+cCIMod.getText()+"'");
             
             cNombreMod.setText("");
             cCIMod.setText("");
             cDireccionMod.setText("");
             cTelefonoMod.setText("");
             cCelularMod.setText("");
             cCorreoMod.setText("");
             JOptionPane.showMessageDialog(null, "Se guardó correctamente");
             jframeMod.setVisible(false);
            // cn.desconectar();
         }
         catch(Exception ex){
             JOptionPane.showMessageDialog(null, "Ocurrio un error en la conexión");
         }
        }}else{
                JOptionPane.showMessageDialog(null, "Debe rellenar los campos");          
            }
        }});
              
                jframeMod.add(jpanelMod);
 
                    }else{
                        JOptionPane.showMessageDialog(null, "El cliente no esta registrado en la BD");
                    }
                }
                if(nombre.isEmpty()){
                   
                        JOptionPane.showMessageDialog(null, "El cliente no esta registrado en la BD");
                    }

                campoBusqueda.setText("");
                buscar.desconectar();
             }
             catch(Exception ex){
             JOptionPane.showMessageDialog(null, "Ocurrio un error en la conexión");
            }
            }else{
                JOptionPane.showMessageDialog(null, "Introduzca la información del cliente");
            }            
        }});

        lB.add(etiqueta1);
        lB.add(campoBusqueda);
        lB.add(botonBuscar);
        mB.add(lB);
        
    }
}
