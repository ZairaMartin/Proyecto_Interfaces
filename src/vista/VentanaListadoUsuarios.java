package vista;

import componentes.CampoTexto;
import componentes.Paneles;
import componentes.Selectores;
import controlador.ControladorUsuarios;
import modelo.Usuario;
import utiles.Colores;

import static vista.VentanaPrincipal.controladorUsuarios;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaListadoUsuarios extends JPanel {
    private JTable tablaUsuarios;
    private DefaultTableModel modeloTabla;
    private JPanel panelTitulo, panelBotones;
    private JButton btnEditar, btnEliminar;
    private JLabel titulo;

    public VentanaListadoUsuarios(ControladorUsuarios controladorUsuarios){
        setLayout(new BorderLayout());

        panelTitulo = new JPanel();
        titulo = CampoTexto.crearTitulo("Lista de usuarios");
        panelTitulo.setBackground(Colores.VIOLETA);
        panelTitulo.add(titulo);
        add(panelTitulo, BorderLayout.NORTH);

        //Creamos las columnas de la tabla con los titulos
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellido");
        modeloTabla.addColumn("Email");
        modeloTabla.addColumn("Contraseña");
        modeloTabla.addColumn("Rol");

        actualizarTabla();

        //creamos la tabla
        tablaUsuarios = new JTable(modeloTabla);
        tablaUsuarios.setFillsViewportHeight(true);

        //quitamos que se ajuste al tamaños del panel
        tablaUsuarios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //hacemos el formulario mas accesible
        tablaUsuarios.setSelectionBackground(Colores.VIOLETA);
        tablaUsuarios.setFont(new Font("Verdana", Font.PLAIN, 18));
        tablaUsuarios.setRowHeight(40);  //aumentamos el alto de las filas
        //permitimos que se sellecionen multiples filas
        tablaUsuarios.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tablaUsuarios.setForeground(Color.DARK_GRAY);

        //ajustamos el tamaño de cada columna
        tablaUsuarios.getColumnModel().getColumn(0).setPreferredWidth(200); //nombre
        tablaUsuarios.getColumnModel().getColumn(1).setPreferredWidth(200); //apellido
        tablaUsuarios.getColumnModel().getColumn(2).setPreferredWidth(400); //email
        tablaUsuarios.getColumnModel().getColumn(3).setPreferredWidth(300); //contraseña
        tablaUsuarios.getColumnModel().getColumn(4).setPreferredWidth(200); //rol





        //añadimos scroll a la tabla
        JScrollPane scroll = new JScrollPane(tablaUsuarios);
        //ponemos que el scroll aparezca segun lo que se muestre
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scroll, BorderLayout.CENTER);


        panelBotones = Paneles.crearPanelHorizontal();
        btnEliminar = Selectores.crearBoton("Eliminar usuario");
        btnEliminar.setBackground(Color.BLACK);
        panelBotones.add(btnEliminar);
        add(panelBotones, BorderLayout.SOUTH);

        eliminarUsuario();
    }

    public void actualizarTabla(){
        //esta linea vacia la tabla, CUIDADO
        modeloTabla.setRowCount(0);

        for(Usuario usuario : controladorUsuarios.getlUsuarios()){
            modeloTabla.addRow(new Object[]{
                    usuario.getNombre(),
                    usuario.getApellido(),
                    usuario.getEmail(),
                    usuario.getPassword(),
                    usuario.getRol()
            });
        }

    }



    private void eliminarUsuario(){
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int [] filasSeleccionadas = tablaUsuarios.getSelectedRows();

                //mostramos mensaje de confirmacion para eliminar
                int vistoBueno = JOptionPane.showConfirmDialog(VentanaListadoUsuarios.this,"¿Estas seguro de querer eliminar los datos?",
                        "Eliminar", JOptionPane.YES_NO_OPTION);
                // si da el visto bueno
                if(vistoBueno == JOptionPane.YES_OPTION){
                    //Eliminamos al reves -> Error de incices
                    for(int i = filasSeleccionadas.length-1; i>=0; i--){
                        controladorUsuarios.eliminarUsuario(filasSeleccionadas[i]);
                    }
                    //guardamos cambios
                    actualizarTabla();
                }

            }
        });
    }
}
