
package vista;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class Utilidades {
    
    public JButton btn(String text, int x, int y){
        JButton b = new JButton(text);
        b.setBounds(x, y, 120, 32);
        b.setBorderPainted(false);
        b.setBackground(new Color(66,131,222));
        b.setForeground(Color.white);
        b.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent evt){MouseEntered(evt);}
            @Override
            public void mouseExited(MouseEvent evt){MouseExited(evt);}
        });
        return b;
    }
    public void MouseEntered(MouseEvent e){
        ((JButton)e.getComponent()).setBackground(new Color(88,146,226));//210,210,210//109,109,109
    }
    
    public void MouseExited(MouseEvent e) {
        ((JButton)e.getComponent()).setBackground(new Color(66,131,222));
    }
}
