package componentes;

import javax.swing.*;
import java.awt.*;

public class Paneles extends JPanel {

    public static JPanel crearPanelVertical(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        return panel;
    }

    public static JPanel crearPanelHorizontal(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        return panel;
    }



}
