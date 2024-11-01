package vista;

import componentes.CampoTexto;
import componentes.Paneles;
import componentes.Selectores;
import controlador.ControladorLlamadas;
import modelo.Llamada;
import utiles.Colores;

import static vista.VentanaPrincipal.controladorLlamadas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class VentanaRegistroLlamadas extends JPanel {
    private JTable tablaLlamadas;
    private DefaultTableModel modeloTabla;
    private JPanel panelTitulo, panelBotones;
    private JButton btnEliminar;
    private JLabel titulo;

    public VentanaRegistroLlamadas(ControladorLlamadas controladorLlamadas) {
        controladorLlamadas = new ControladorLlamadas();
        setLayout(new BorderLayout());

        panelTitulo = new JPanel();
        titulo = CampoTexto.crearTitulo("Historial de llamadas");
        panelTitulo.setBackground(Colores.VIOLETA);
        panelTitulo.add(titulo);
        add(panelTitulo, BorderLayout.NORTH);

        //Tabla
        modeloTabla = new DefaultTableModel(new String[]{
                "Nombre", "Destinatario", "Numero", "Mensaje", "Importancia", "Tipo de destinatario", "Notas", "Control"
        }, 0);
        tablaLlamadas = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tablaLlamadas);
        //ponemos que el scroll aparezca segun lo que se muestre
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scroll, BorderLayout.CENTER);
        tablaLlamadas.setFillsViewportHeight(true);

        ponerBonito();

        panelBotones = Paneles.crearPanelHorizontal();
        btnEliminar = Selectores.crearBoton("Eliminar llamada");
        btnEliminar.setBackground(Color.BLACK);
        panelBotones.add(btnEliminar);
        add(panelBotones, BorderLayout.SOUTH);

        eliminarLlamada();
    }

    private void ponerBonito() {
        //quitamos que se ajuste al tamaños del panel
        tablaLlamadas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tablaLlamadas.setSelectionBackground(Colores.VIOLETA);
        tablaLlamadas.setFont(new Font("Verdana", Font.PLAIN, 18));
        //padding vertical
        tablaLlamadas.setRowHeight(40);
        //permitimos que se seleccionen varias filas
        tablaLlamadas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tablaLlamadas.setForeground(Color.DARK_GRAY);


        //modificamos el ancho de las columnas
        tablaLlamadas.getColumnModel().getColumn(0).setPreferredWidth(200);  //nombre
        tablaLlamadas.getColumnModel().getColumn(1).setPreferredWidth(200);  //destinatario
        tablaLlamadas.getColumnModel().getColumn(2).setPreferredWidth(150);  //telefono
        tablaLlamadas.getColumnModel().getColumn(3).setPreferredWidth(500);  //mensaje
        tablaLlamadas.getColumnModel().getColumn(4).setPreferredWidth(90);  //importancia
        tablaLlamadas.getColumnModel().getColumn(5).setPreferredWidth(200);  //tipo destinatario
        tablaLlamadas.getColumnModel().getColumn(6).setPreferredWidth(500);  //notas adicionales
        tablaLlamadas.getColumnModel().getColumn(7).setPreferredWidth(50);  //necesita seguimiento


    }


    public void actualizarTabla() {
        modeloTabla.setRowCount(0);
        for (Llamada llamada : controladorLlamadas.getListaLlamadas()) {
            modeloTabla.addRow(new Object[]{
                    llamada.getNombre(),
                    llamada.getDestinatario(),
                    llamada.getTelefono(),
                    llamada.getMensaje(),
                    llamada.getImportancia(),
                    llamada.getTipoDestinatario(),
                    llamada.getNotaAdicional(),
                    llamada.isSeguimiento() ? "SI" : "NO"  //ternatia para marcar si necesita seguimiento
            });
        }
    }

    private void eliminarLlamada() {
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] filasSeleccionadas = tablaLlamadas.getSelectedRows();

                //mostramos mensaje de confirmacion para eliminar
                int vistoBueno = JOptionPane.showConfirmDialog(VentanaRegistroLlamadas.this, "¿Estas seguro de querer eliminar los datos?", "Eliminar",
                        JOptionPane.YES_NO_OPTION);
                if (vistoBueno == JOptionPane.YES_NO_OPTION) {
                    //eliminamos al reves para no tener fallo de incides
                    for (int i = filasSeleccionadas.length - 1; i >= 0; i--) {
                        controladorLlamadas.eliminarLlammada(filasSeleccionadas[i]);
                    }
                    //guardamos cambios
                    actualizarTabla();
                }
            }
        });
    }
}
