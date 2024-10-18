package ventanas;

import javax.swing.*;

public class VentanaRegistro extends VentanaPadre {
    public VentanaRegistro(){
        super();  //llamamos al constructor del ventanaPadre
        setTitle("Registro de usuarios");
        inicializarComponentes();
        setVisible(true);  //la hacemos visible
    }

    @Override
    public void inicializarComponentes() {

    }

}
