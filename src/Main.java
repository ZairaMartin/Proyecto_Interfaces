
import vista.VentanaPrincipal;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //para ejecutar de forma mas segura
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
    }
}