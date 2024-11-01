package vista;

import utiles.Colores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static vista.VentanaPrincipal.ventanaRegistroLlamadas;
import static vista.VentanaPrincipal.ventanaRegistroUsuarios;

public class Menu extends JMenuBar {
    private JMenu llamada, usuarios;
    private JMenuItem registroLlamada, registros, registroUsuario, listadoUsuarios;
    private JPanel panelPrincipal;
    private CardLayout card;
    private VentanaPrincipal ventanaPrincipal;
    public Menu(VentanaPrincipal ventanaPrincipal){

        this.ventanaPrincipal = ventanaPrincipal;
        //creo objeto fuente para poner el menu mas accesible
        Font font = new Font("Verdana", Font.PLAIN, 16);
        Dimension dimension = new Dimension(150,30);
        //Elementos del menu
        usuarios = new JMenu("Usuarios");
        usuarios.setFont(font);

        llamada = new JMenu("Llamadas");
        llamada.setFont(font);


        //elementos del submenu
        registroLlamada = new JMenuItem("Registrar llamada");
        registroLlamada.setPreferredSize(dimension);
        registroLlamada.setFont(font);
        registroLlamada.setMnemonic('R'); // Atajo de teclado Alt + R
        registroLlamada.setToolTipText("Formulario para registrar una nueva llamada");

        registros = new JMenuItem("Historial llamadas");
        registros.setPreferredSize(dimension);
        registros.setFont(font);
        registros.setMnemonic('H'); // Atajo de teclado Alt + H
        registros.setToolTipText("Ver historial de llamadas registradas");

        registroUsuario = new JMenuItem("Registrar usuario");
        registroUsuario.setPreferredSize(dimension);
        registroUsuario.setFont(font);
        registroUsuario.setMnemonic('U'); // Atajo de teclado Alt + U
        registroUsuario.setToolTipText("Formulario para registrar un nuevo usuario");

        listadoUsuarios = new JMenuItem("Lista usuarios");
        listadoUsuarios.setPreferredSize(dimension);
        listadoUsuarios.setFont(font);
        listadoUsuarios.setMnemonic('L'); // Atajo de teclado Alt + L
        listadoUsuarios.setToolTipText("Ver lista de usuarios registrados");


        registroLlamada.addActionListener(e -> ventanaPrincipal.mostrarPanel("registroLlamada"));
      //  registros.addActionListener(e -> ventanaPrincipal.mostrarPanel("historialLlamadas"));
        registros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.mostrarPanel("historialLlamadas");
                ventanaRegistroLlamadas.actualizarTabla();

            }
        });
        registroUsuario.addActionListener(e -> ventanaPrincipal.mostrarPanel("registroUsuario"));
      //  listadoUsuarios.addActionListener(e -> ventanaPrincipal.mostrarPanel("listadoUsuarios"));
        listadoUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.mostrarPanel("listadoUsuarios");
                ventanaRegistroUsuarios.actualizarTabla();

            }
        });



        //metemos los submenus dentro de su elemento del menu
        llamada.add(registroLlamada);
        llamada.addSeparator();
        llamada.add(registros);

        usuarios.add(registroUsuario);
        usuarios.addSeparator();
        usuarios.add(listadoUsuarios);

        //metemos el menu en la barra

        this.add(usuarios);
        this.add(llamada);



    }






}
