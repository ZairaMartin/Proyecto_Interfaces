package componentes;

import utiles.Colores;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Selectores {
    public static JComboBox comboBoxImportanciaLLamada() {
        //dejamos la primera posicion vacia por si no tiene importancia, o o quieren marcarsela
        String[] nivelImportancia = {"", "Alta", "Media", "Baja"};
        JComboBox<String> importancia = new JComboBox<>(nivelImportancia);
        importancia.setBackground(Color.WHITE);
        importancia.setBorder(new LineBorder(Colores.VIOLETA_FUERTE, 3));
        importancia.setPreferredSize(new Dimension(400, 30));
        importancia.setMaximumSize(new Dimension(400, 30));
        importancia.setMinimumSize(new Dimension(400, 30));
        importancia.setSelectedIndex(0); //nivel de importancia por defecto

        return importancia;
    }

    public static JSpinner spinnerMotivoLlamada() {
        String[] motivoLlamada = {"", "Consulta médica", "Queja o reclamación", "Solicitud de un servicio", "Pedir informacion", "Otro motivo"};
        SpinnerListModel listaMotivos = new SpinnerListModel(motivoLlamada);
        JSpinner motivos = new JSpinner(listaMotivos);
        motivos.setBackground(Color.WHITE);
        motivos.setBorder(new LineBorder(Colores.VIOLETA_FUERTE, 3));
        motivos.setPreferredSize(new Dimension(400, 30));
        motivos.setMaximumSize(new Dimension(400, 30));
        motivos.setMinimumSize(new Dimension(400, 30));
        return motivos;
    }


    public static JComboBox comboBoxRol() {
        String[] roles = {"", "Administrador", "Recepcionista", "Coordinador", "Transportista", "Técnico sanitario"};
        JComboBox<String> rol = new JComboBox<>(roles);
        rol.setBackground(Color.WHITE);
        rol.setBorder(new LineBorder(Colores.VIOLETA_FUERTE, 3));
        rol.setPreferredSize(new Dimension(400, 40));
        rol.setMaximumSize(new Dimension(400, 40));
        rol.setMinimumSize(new Dimension(400, 40));
        rol.setSelectedIndex(0); //rol por defecto
        rol.setFont(new Font("Verdana", Font.PLAIN, 18));
        

        return rol;
    }

    public static JButton crearBoton(String txt){
        JButton boton = new JButton(txt);
        boton.setPreferredSize(new Dimension(250,50));
        boton.setMaximumSize(new Dimension(250,50));
        boton.setMinimumSize(new Dimension(250,50));
        boton.setBackground(Colores.VIOLETA_FUERTE);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Verdana", Font.BOLD, 20));
        return boton;
    }


    public static JCheckBox crearCheckBox(String txt){
        JCheckBox check = new JCheckBox(txt);
        check.setFont(new Font("Verdana", Font.PLAIN, 18));
        return check;
    }

    public static JRadioButton crearRadioButton(String txt){
        JRadioButton radioButton = new JRadioButton(txt);
        radioButton.setFont(new Font("Verdana", Font.PLAIN, 16));
        return radioButton;
    }

}
