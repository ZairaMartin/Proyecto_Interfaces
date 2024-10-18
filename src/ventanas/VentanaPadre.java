package ventanas;

import javax.swing.*;

public abstract class VentanaPadre extends JFrame {
    /*
    Usare esta ventana padre para usar la herencia y crear aqui el menu principal,
     que te lleva a registro, login o ver usuarios registrados

     Será una clase abstracta para tener el codigo mas organizado */

    //creamos el atributo del menu
    private JMenuBar menuBar;
    private JMenu menuInicio;
    private JMenuItem resgitrar, iniciarSesion, verRegistros;

    public VentanaPadre(){
        setTitle("Aplicacion de eventos digitales");
        setSize(400,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        configurarMenu();
        setJMenuBar(menuBar);

    }

    private void configurarMenu(){
        menuBar = new JMenuBar();
        menuInicio = new JMenu("Inicio");

        //añadimos las secciones del menu
        resgitrar = new JMenuItem("Regitrarse");
        iniciarSesion = new JMenuItem("Iniciar sesión");
        verRegistros = new JMenuItem("Ver registrados");

        //primero insertamos las opciones al menu, luego insertamos el menu en el navegador
        menuInicio.add(resgitrar);
        menuInicio.add(iniciarSesion);
        menuInicio.add(verRegistros);

        menuBar.add(menuInicio);

    }

    public abstract void inicializarComponentes();


}
