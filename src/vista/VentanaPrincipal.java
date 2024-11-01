package vista;

import controlador.ControladorLlamadas;
import controlador.ControladorUsuarios;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    private JPanel panelPrincipal;
    private CardLayout cardLayout;
    private Menu menu;
    public static ControladorUsuarios controladorUsuarios;
    public static ControladorLlamadas controladorLlamadas;
    public static VentanaRegistroLlamadas ventanaRegistroLlamadas;
    public static VentanaListadoUsuarios ventanaRegistroUsuarios ;
    public static VentanaRegistro ventanaRegistro;
    public static VentanaLlamadas ventanaLlamadas;

    public VentanaPrincipal(){
        setTitle("Conexión Accesible");
        setSize(1200,900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);    //centramos la ventana
        setResizable(false);  //hacemos que NO se pueda cambiar el tamaño de la ventana
        setVisible(true);

        controladorLlamadas = new ControladorLlamadas();
        controladorUsuarios = new ControladorUsuarios();

        ventanaRegistroLlamadas = new VentanaRegistroLlamadas(controladorLlamadas);
        ventanaRegistroUsuarios = new VentanaListadoUsuarios(controladorUsuarios);
        //creamos el cardLayout y el panel principal
        cardLayout = new CardLayout();
        panelPrincipal = new JPanel(cardLayout);

        //añadimos los diferentes paneles de formularios y registros al panel
        panelPrincipal.add(ventanaRegistro = new VentanaRegistro(controladorUsuarios, ventanaRegistroUsuarios), "registroUsuario");
        panelPrincipal.add(ventanaLlamadas = new VentanaLlamadas(controladorLlamadas, ventanaRegistroLlamadas), "registroLlamada");
        panelPrincipal.add(ventanaRegistroUsuarios , "listadoUsuarios");
        panelPrincipal.add(ventanaRegistroLlamadas , "historialLlamadas");


        //cardLayout.show(panelPrincipal, "registroLlamada");


        //ceramos menu y lo aladimos
        menu = new Menu(this);
        setJMenuBar(menu);

        setContentPane(panelPrincipal);

    }

    public void mostrarPanel(String nombrePanel){
        cardLayout.show(panelPrincipal, nombrePanel);
    }


}
