package componentes;

import utiles.Colores;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class CampoTexto {

    public static JTextField crearCampoTexto(){
        JTextField campoTexto = new JTextField();
        campoTexto.setBorder(new LineBorder(Colores.VIOLETA_FUERTE, 3));
        campoTexto.setFont(new Font("Verdana", Font.PLAIN, 20));
        Dimension dimension = new Dimension(400, 40);
        campoTexto.setPreferredSize(dimension);
        campoTexto.setMinimumSize(dimension); // tamaño mínimo
        campoTexto.setMaximumSize(dimension); // tamaño máximo
        campoTexto.setBackground(Color.WHITE);
        campoTexto.setForeground(Colores.GRIS_OSCURO);
        campoTexto.setColumns(100);
        campoTexto.setFocusable(true);

        //metodo para cambiar el color cuando se hace foco
        campoTexto.addFocusListener(new FocusAdapter() {
            @Override    //cuando tiene el foco
            public void focusGained(FocusEvent e) {
                campoTexto.setBackground(Colores.GRIS_TRASPARENTOSO);
            }

            @Override   //cuando pierde el foco
            public void focusLost(FocusEvent e) {
                campoTexto.setBackground(Color.WHITE);
            }
        });


        return campoTexto;
    }



    public static JPasswordField crearCampoPassword(){
        JPasswordField campoPassword = new JPasswordField();
        campoPassword.setBorder(new LineBorder(Colores.VIOLETA_FUERTE, 3));
        campoPassword.setFont(new Font("Verdana", Font.PLAIN, 20));
        Dimension dimension = new Dimension(400, 40);
        campoPassword.setPreferredSize(dimension);
        campoPassword.setMinimumSize(dimension); // tamaño mínimo
        campoPassword.setMaximumSize(dimension); //
        campoPassword.setBackground(Color.WHITE);
        campoPassword.setForeground(Colores.GRIS_OSCURO);
        campoPassword.setColumns(100);
        campoPassword.setFocusable(true);

        //metodo para cambiar el color cuando se hace foco
        campoPassword.addFocusListener(new FocusAdapter() {
            @Override    //cuando tiene el foco
            public void focusGained(FocusEvent e) {
                campoPassword.setBackground(Colores.GRIS_TRASPARENTOSO);
            }

            @Override   //cuando pierde el foco
            public void focusLost(FocusEvent e) {
                campoPassword.setBackground(Color.WHITE);
            }
        });

        return campoPassword;
    }
    public static JLabel crearEtiqueta(String texto){
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setFont(new Font("Verdana", Font.BOLD, 20));
        etiqueta.setForeground(Colores.GRIS_OSCURO);
        Dimension dimension = new Dimension(200, 40);
        etiqueta.setPreferredSize(dimension);
        etiqueta.setMinimumSize(dimension); // tamaño mínimo
        etiqueta.setMaximumSize(dimension); // tamaño máxim

        //setLabelFor(Componente componenete)  para asociar el label con el campo de texto

        return etiqueta;
    }

    public static JLabel crearTitulo(String texto){
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setFont(new Font("Verdana", Font.BOLD, 26));
        etiqueta.setForeground(Colores.GRIS_OSCURO);
        Dimension dimension = new Dimension(400, 60);
        etiqueta.setPreferredSize(dimension);
        etiqueta.setMinimumSize(dimension); // tamaño mínimo
        etiqueta.setMaximumSize(dimension); // tamaño máxim

        //setLabelFor(Componente componenete)  para asociar el label con el campo de texto

        return etiqueta;
    }

    public static JLabel crearEtiquetaError(){
        JLabel etiqueta = new JLabel();
        etiqueta.setFont(new Font("Verdana", Font.BOLD, 18));
        etiqueta.setForeground(Color.RED);
        Dimension dimension = new Dimension(400, 40);
        etiqueta.setPreferredSize(dimension);
        etiqueta.setMinimumSize(dimension); // tamaño mínimo
        etiqueta.setMaximumSize(dimension); // tamaño máxim

        return etiqueta;
    }

    public static JTextArea crearTextArea(){
        JTextArea textArea = new JTextArea();
        textArea.setRows(7); //7 filas
        textArea.setColumns(100);
        textArea.setLineWrap(true);  // activamos el ajuste de linea
        textArea.setBackground(Color.WHITE);
        textArea.setForeground(Colores.GRIS_OSCURO);
        textArea.setBorder(new LineBorder(Colores.VIOLETA_FUERTE, 3));
        Dimension dimension = new Dimension(400, 100);
        textArea.setPreferredSize(dimension);
        textArea.setMinimumSize(dimension); // tamaño mínimo
        textArea.setMaximumSize(dimension); //
        textArea.setFont(new Font("Verdana", Font.PLAIN, 20));
        textArea.setFocusable(true);

        //metodo para cambiar el color cuando se hace foco
        textArea.addFocusListener(new FocusAdapter() {
            @Override    //cuando tiene el foco
            public void focusGained(FocusEvent e) {
                textArea.setBackground(Colores.GRIS_TRASPARENTOSO);
            }

            @Override   //cuando pierde el foco
            public void focusLost(FocusEvent e) {
                textArea.setBackground(Color.WHITE);
            }
        });

        return textArea;
    }

}
