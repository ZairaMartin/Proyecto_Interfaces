package componentes;

import javax.swing.*;
import java.awt.*;

public class AreaTexto {
    /*
    * Esta clase tendrá componentes JTextArea y JScrollPane
    * para gestionar entradas de texto mas largas como comentarios y direcciones,
    *  con sus respectivos metodos para gestionar y validar los contenidos
    *
    * Es una clase que encapsula la creacion y confugiracion de los componentes anteriormente mencionados
    * */

    //METODO PARA CREAR UN CAMPO DE TEXTO SIMPLE
    public JTextField crearCampoTxt (String placeholder){
        JTextField campoTexto = new JTextField(placeholder);
        campoTexto.setPreferredSize(new Dimension(250, 30));
        campoTexto.setFont(new Font("Verdana", Font.PLAIN, 16));
        campoTexto.setForeground(Color.BLACK);
        campoTexto.setBackground(Color.WHITE);
        campoTexto.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));

        return campoTexto; //devolvemos el componente con una personalizacion ya creada
    }

    public JPasswordField crearCampoPssw(String placeholder){
        JPasswordField campoPassword = new JPasswordField(placeholder);
        campoPassword.setPreferredSize(new Dimension(250,30));
        campoPassword.setFont(new Font("Verdana", Font.PLAIN, 16));
        campoPassword.setForeground(Color.BLACK);
        campoPassword.setBackground(Color.WHITE);
        campoPassword.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));

        return campoPassword;
    }

}
