/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Andrea
 */
public class ValidadorCampos {
    public void validarNombres(java.awt.event.KeyEvent evt){//PAO TIENES QUE MODIFICAR E IMPLENTAR PARA LOS ESPACIOS
        char c = evt.getKeyChar();
        if((c < 'a' || c > 'z') && ( c < 'A' || c > 'Z'))evt.consume();
    }
    public void validarNumeros(java.awt.event.KeyEvent evt){
        char c = evt.getKeyChar();
        if(c < '0' || c > '9') evt.consume();
    }
    public boolean validarCorreo(String email){
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
         Matcher mather = pattern.matcher(email);
 
        if (mather.find() == true) {
            return true;
//            System.out.println("El email ingresado es válido.");
        } else {
            return false;
//            System.out.println("El email ingresado es inválido.");
        }
    }
}
