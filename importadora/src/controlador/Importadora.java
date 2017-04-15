
package controlador;

import vista.MenuPrincipal;

public class Importadora {

    public static void main(String[] args) {
        Iniciar();
    }
    private static void Iniciar(){
        MenuPrincipal mp=new MenuPrincipal();
        mp.setTitle("Importadora");
        mp.setVisible(true);
    }
}
