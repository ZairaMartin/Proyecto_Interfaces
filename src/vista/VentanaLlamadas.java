package vista;

import componentes.CampoTexto;
import componentes.Paneles;
import componentes.Selectores;
import controlador.ControladorLlamadas;
import utiles.Colores;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import static vista.VentanaPrincipal.ventanaRegistroLlamadas;
import static vista.VentanaPrincipal.controladorLlamadas;
import static componentes.Selectores.crearRadioButton;

public class VentanaLlamadas extends JPanel {
    //atributos
    private JPanel panelPrincipal, panelIzquierda, panelDerecha;
    private JPanel pBotones, pTitulo, pNombre, pDestinatario, pTelefono, pMensaje, pImportancia, pTipoDestinatario, panelTipoDestinatario,
            pNotasAdicionales, pSeguimiento;
    private JPanel pErrorNombre, pErrorDestinatario, pErrorTelefono, pErrorMensaje, pErrorImportancia, pErrorTipoDestinatario;
    private JLabel titulo, txtNombre, txtDestinatario, txtTelefono, txtMensaje, txtImportancia, txtTipoDestinatario, comentario;
    private JLabel errorNombre, errorDestinatario, errorTelefono, errorMensaje, errorImportancia, errorTipoDestinatario;
    private JTextField nombre, destinatario, telefono;
    private JTextArea mensaje, notasAdicionales;
    private JComboBox importancia;
    private JRadioButton pInterno, pExterno, sanitario, transporte, otroTrabajador;
    private ButtonGroup grupoDestinatarios;
    private JCheckBox seguimiento;
    private JButton btnRegistrar, btnCancelar;



    public VentanaLlamadas(ControladorLlamadas controladorLlamadas, VentanaRegistroLlamadas ventanaRegistroLlamadas) {

        setSize(1200, 900);
        controladorLlamadas = new ControladorLlamadas();
        ventanaRegistroLlamadas = new VentanaRegistroLlamadas(controladorLlamadas);
        panelPrincipal();
        this.add(panelPrincipal);
        //crearemos dos paneles para partir la interfaz
        crearPanelIzquierda();
        crearPanelDerecha();

    }

    private void panelPrincipal() {
        //creamos panel principal para organizar
        panelPrincipal = new JPanel(new BorderLayout());
    }

    private void crearPanelIzquierda() {
        panelIzquierda = new JPanel();
        panelIzquierda.setBackground(Colores.VIOLETA);
        panelIzquierda.setPreferredSize(new Dimension(400, 900));

        //añadimos imagen
        ImageIcon imagenLlamada = new ImageIcon("resources" + File.separator + "call.png");  //llamamos a la imagen
        Image imagen = imagenLlamada.getImage().getScaledInstance(300, 400, Image.SCALE_SMOOTH);  //escalamos la imagen
        ImageIcon iconLlamada = new ImageIcon(imagen);  //la volvemos a convertir
        JLabel imgLlamada = new JLabel(iconLlamada);  //la introducimos en la etiqueta
        imgLlamada.setBorder(BorderFactory.createEmptyBorder(40, 10, 40, 10));
        imgLlamada.setAlignmentX(Component.CENTER_ALIGNMENT); //centramos la imagen horizontal
        imgLlamada.setAlignmentY(Component.CENTER_ALIGNMENT); //centramos la imagen vertical
        // panelIzquierda.add(Box.createVerticalStrut(60));
        panelIzquierda.add(imgLlamada);


        panelPrincipal.add(panelIzquierda, BorderLayout.WEST);

    }

    private void crearPanelDerecha() {
        panelDerecha = new JPanel();
        //organizaremos el panel verticalmente
        panelDerecha.setLayout(new BoxLayout(panelDerecha, BoxLayout.Y_AXIS));
        panelDerecha.setPreferredSize(new Dimension(800, 1300));
        panelDerecha.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 30));
        //creamos los componentes del formularop
        crearComponentesFormulario();

        // Crear un JScrollPane y añadimos el panelDerecha al scroll
        JScrollPane scrollPane = new JScrollPane(panelDerecha);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // scroll vertical
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Sin scroll horizontal
        scrollPane.setPreferredSize(new Dimension(800, 800));


        // Añadir el JScrollPane al panel principal
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);
    }


    private void crearComponentesFormulario() {

        //titulo formulario
        pTitulo = new JPanel();
        titulo = CampoTexto.crearTitulo("Registro de llamada");
        pTitulo.setLayout(new FlowLayout(FlowLayout.CENTER));  //ajustamos titulo al centro
        pTitulo.add(titulo);

        //creamos paneles y ordenamos los componentes de cada campo del fomularo

        txtNombre = CampoTexto.crearEtiqueta("Nombre: ");
        nombre = CampoTexto.crearCampoTexto();
        nombre.setToolTipText("Nombre de la persona que realiza la llamada");
        txtNombre.setLabelFor(nombre);
        pNombre = Paneles.crearPanelHorizontal();
        JLabel iconoNombre = new JLabel(escalarImagen("person.png"));
        iconoNombre.setBorder(crearBorde());
        pNombre.add(iconoNombre);
        pNombre.add(txtNombre);
        pNombre.add(nombre);
        ////errores
        pErrorNombre = Paneles.crearPanelVertical();
        errorNombre = CampoTexto.crearEtiquetaError();
        pErrorNombre.add(pNombre);
        pErrorNombre.add(errorNombre);


        txtDestinatario = CampoTexto.crearEtiqueta("Destinatario: ");
        destinatario = CampoTexto.crearCampoTexto();
        destinatario.setToolTipText("Persona a la que va dirigido el mensaje");
        txtDestinatario.setLabelFor(destinatario);
        pDestinatario = Paneles.crearPanelHorizontal();
        JLabel iconoDestinatario = new JLabel(escalarImagen("serach_person.png"));
        iconoDestinatario.setBorder(crearBorde());
        pDestinatario.add(iconoDestinatario);
        pDestinatario.add(txtDestinatario);
        pDestinatario.add(destinatario);
        ////errores
        pErrorDestinatario = Paneles.crearPanelVertical();
        errorDestinatario = CampoTexto.crearEtiquetaError();
        pErrorDestinatario.add(pDestinatario);
        pErrorDestinatario.add(errorDestinatario);


        txtTelefono = CampoTexto.crearEtiqueta("Telefono: ");
        telefono = CampoTexto.crearCampoTexto();
        telefono.setToolTipText("Telefono con el que realiza la llamada");
        txtTelefono.setLabelFor(telefono);
        pTelefono = Paneles.crearPanelHorizontal();
        JLabel iconoTelefono = new JLabel(escalarImagen("call.png"));
        iconoTelefono.setBorder(crearBorde());
        pTelefono.add(iconoTelefono);
        pTelefono.add(txtTelefono);
        pTelefono.add(telefono);
        ////errores
        pErrorTelefono = Paneles.crearPanelVertical();
        errorTelefono = CampoTexto.crearEtiquetaError();
        pErrorTelefono.add(pTelefono);
        pErrorTelefono.add(errorTelefono);


        txtMensaje = CampoTexto.crearEtiqueta("Mensage:");
        mensaje = CampoTexto.crearTextArea();
        mensaje.setToolTipText("Mensaje que quiere dejar");
        txtMensaje.setLabelFor(mensaje);
        pMensaje = Paneles.crearPanelHorizontal();
        JLabel iconoMensaje = new JLabel(escalarImagen("notes.png"));
        iconoMensaje.setBorder(crearBorde());
        pMensaje.add(iconoMensaje);
        pMensaje.add(txtMensaje);
        pMensaje.add(mensaje);
        ////errores
        pErrorMensaje = Paneles.crearPanelVertical();
        errorMensaje = CampoTexto.crearEtiquetaError();
        pErrorMensaje.add(pMensaje);
        pErrorMensaje.add(errorMensaje);


        txtImportancia = CampoTexto.crearEtiqueta("Importancia: ");
        importancia = Selectores.comboBoxImportanciaLLamada();
        importancia.setToolTipText("Importancia que tiene el mensaje");
        txtImportancia.setLabelFor(importancia);
        pImportancia = Paneles.crearPanelHorizontal();
        JLabel iconoImportancia = new JLabel(escalarImagen("important.png"));
        iconoImportancia.setBorder(crearBorde());
        pImportancia.add(iconoImportancia);
        pImportancia.add(txtImportancia);
        pImportancia.add(importancia);
        ////errores
        pErrorImportancia = Paneles.crearPanelVertical();
        errorImportancia = CampoTexto.crearEtiquetaError();
        pErrorImportancia.add(pImportancia);
        pErrorImportancia.add(errorImportancia);


        txtTipoDestinatario = CampoTexto.crearEtiqueta("Tipo destiatario: ");
        pInterno = Selectores.crearRadioButton("Paciente interno");
        pExterno = Selectores.crearRadioButton("Paciente externo");
        sanitario = Selectores.crearRadioButton("Sanitario");
        transporte = Selectores.crearRadioButton("Transporte");
        otroTrabajador = Selectores.crearRadioButton("Otro trabajador");
        grupoDestinatarios = new ButtonGroup();
        grupoDestinatarios.add(pInterno);
        grupoDestinatarios.add(pExterno);
        grupoDestinatarios.add(sanitario);
        grupoDestinatarios.add(transporte);
        grupoDestinatarios.add(otroTrabajador);
        pTipoDestinatario = Paneles.crearPanelVertical();  //creamos panel
        pTipoDestinatario.add(pInterno);
        pTipoDestinatario.add(pExterno);
        pTipoDestinatario.add(sanitario);
        pTipoDestinatario.add(transporte);
        pTipoDestinatario.add(otroTrabajador);
        panelTipoDestinatario = Paneles.crearPanelHorizontal();
        JLabel iconoTipoDestinatario = new JLabel(escalarImagen("people.png"));
        iconoTipoDestinatario.setBorder(crearBorde());
        panelTipoDestinatario.add(iconoTipoDestinatario);
        panelTipoDestinatario.add(txtTipoDestinatario);
        panelTipoDestinatario.add(Box.createHorizontalStrut(100));
        panelTipoDestinatario.add(pTipoDestinatario);
        // panelTipoDestinatario.setAlignmentX(Component.RIGHT_ALIGNMENT);
        ////errores
        pErrorTipoDestinatario = Paneles.crearPanelVertical();
        errorTipoDestinatario = CampoTexto.crearEtiquetaError();
        pErrorTipoDestinatario.add(panelTipoDestinatario);
        pErrorTipoDestinatario.add(errorTipoDestinatario);



        comentario = CampoTexto.crearEtiqueta("Notas:");
        notasAdicionales = CampoTexto.crearTextArea();
        notasAdicionales.setToolTipText("Campo para añadir notas adicionales de esta llamada");
        comentario.setLabelFor(notasAdicionales);
        pNotasAdicionales = Paneles.crearPanelHorizontal();
        JLabel iconoNota = new JLabel(escalarImagen("more_notes.png"));
        iconoNota.setBorder(crearBorde());
        pNotasAdicionales.add(iconoNota);
        pNotasAdicionales.add(comentario);
        pNotasAdicionales.add(notasAdicionales);


        seguimiento = Selectores.crearCheckBox("¿Necesita seguimiento?");
        pSeguimiento = Paneles.crearPanelHorizontal();
        JLabel iconoSeguimiento = new JLabel(escalarImagen("seguimiento.png"));
        iconoSeguimiento.setBorder(crearBorde());
        pSeguimiento.add(iconoSeguimiento);
        pSeguimiento.add(seguimiento);

        // Boton para enviar el registro
        btnRegistrar = Selectores.crearBoton("Registrar llamada");
        btnCancelar = Selectores.crearBoton("Cancelar");
        btnCancelar.setBackground(Color.BLACK);
        pBotones = Paneles.crearPanelHorizontal();
        pBotones.add(btnRegistrar);
        pBotones.add(Box.createHorizontalStrut(30));
        pBotones.add(btnCancelar);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarLlamada();
                //metodo de actualizar tabla
                ventanaRegistroLlamadas.actualizarTabla();
            }
        });
        btnCancelar.addActionListener(e -> limpiarFormulario());

        //Añadimos todos los pequeños paneles al panel de la derecha
        panelDerecha.add(pTitulo);
        panelDerecha.add(pErrorNombre);
        panelDerecha.add(pErrorDestinatario);
        panelDerecha.add(pErrorTelefono);
        panelDerecha.add(pErrorMensaje);
        panelDerecha.add(pErrorImportancia);
        panelDerecha.add(pErrorTipoDestinatario);
        panelDerecha.add(pNotasAdicionales);
        panelDerecha.add(pSeguimiento);
        panelDerecha.add(pBotones);
        panelDerecha.add(Box.createVerticalStrut(50)); //espacio bajo el boton
        panelDerecha.add(Box.createVerticalStrut(50)); //espacio bajo el boton

    }

    //metodo para escalar las imagenes
    private ImageIcon escalarImagen(String ruta) {
        ImageIcon iconoOriginal = new ImageIcon("resources" + File.separator + "icons" + File.separator + ruta);
        Image imagen = iconoOriginal.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        return new ImageIcon(imagen);
    }

    //metodo para crear borde para los iconos
    private Border crearBorde() {
        return BorderFactory.createEmptyBorder(10, 10, 10, 10);
    }

    private void registrarLlamada() {
        //recogemos los campos del formulario
        String nombreLlamada = nombre.getText().trim();
        String destinatarioLlamada = destinatario.getText().trim();
        String telefonoLlamada = telefono.getText().trim();
        String mensajeLlamada = mensaje.getText().trim();
        String importanciaLlamada = (String) importancia.getSelectedItem();
        String tipoDestinatarioLlamada = obtenerTipoDestinatario();
        String notasLlamada = notasAdicionales.getText().trim();
        boolean seguimientoLlamada = seguimiento.isSelected();

        //validamos los datos y recogemos los mensajes de error
        String smsNombreLlamada = controladorLlamadas.validarNombre(nombreLlamada);
        String smsDestinatarioLlamada = controladorLlamadas.validarDestinatario(destinatarioLlamada);
        String smsTelefonoLlamada = controladorLlamadas.validarTelefono(telefonoLlamada);
        String smsMensajeLlamada = controladorLlamadas.validarMensaje(mensajeLlamada);
        String smsImportancia = controladorLlamadas.validarImportancia(importancia);
        String smsTipoDestinatarioLlamada = controladorLlamadas.validarTipoDestinatario(grupoDestinatarios);

        //Limpiamos los errores
        errorNombre.setText("");
        errorDestinatario.setText("");
        errorTelefono.setText("");
        errorMensaje.setText("");
        errorImportancia.setText("");
        errorTipoDestinatario.setText("");

        //mostramos errores
        if (!smsNombreLlamada.isEmpty()) {
            this.errorNombre.setText(smsNombreLlamada);
        }

        if (!smsDestinatarioLlamada.isEmpty()) {
            this.errorDestinatario.setText(smsDestinatarioLlamada);
        }

        if (!smsTelefonoLlamada.isEmpty()) {
            this.errorTelefono.setText(smsTelefonoLlamada);
        }

        if (!smsMensajeLlamada.isEmpty()) {
            this.errorMensaje.setText(smsMensajeLlamada);
        }

        if (!smsImportancia.isEmpty()) {
            this.errorImportancia.setText(smsImportancia);
        }

        if (!smsTipoDestinatarioLlamada.isEmpty()) {
            this.errorTipoDestinatario.setText(smsTipoDestinatarioLlamada);
        }

        //ajustamos tamaño automaticamente cuando se añade o se quitan componentes
        panelDerecha.revalidate();
        //actualizamos interfaz
        panelDerecha.repaint();


        //si no hay errores, guardamos los datos de la llamada
        if (smsNombreLlamada.isEmpty() && smsDestinatarioLlamada.isEmpty() && smsTelefonoLlamada.isEmpty()
                 && smsMensajeLlamada.isEmpty() && smsImportancia.isEmpty() && smsTipoDestinatarioLlamada.isEmpty()){

            controladorLlamadas.agregarLlamada(nombreLlamada, destinatarioLlamada, telefonoLlamada, mensajeLlamada, importanciaLlamada,
                    tipoDestinatarioLlamada, notasLlamada, seguimientoLlamada);
            ventanaRegistroLlamadas.actualizarTabla();
            //mostramos mensaje de extio
            JOptionPane.showMessageDialog(this,"Llamada registrada correctamente");
            limpiarFormulario();//vaciamos el formulario despued de registrar la llamada

        }

    }

    private String obtenerTipoDestinatario() {
        if (pInterno.isSelected()) {
            return "Paciente interno";
        } else if (pExterno.isSelected()) {
            return "Paciente externo";
        } else if (sanitario.isSelected()) {
            return "Sanitario";
        } else if (transporte.isSelected()) {
            return "Transporte";
        } else if (otroTrabajador.isSelected()) {
            return "Otro trabajador";
        }
        return "";
    }

    private void limpiarFormulario(){
        System.out.println("1");
        nombre.setText("");
        destinatario.setText("");
        telefono.setText("");
        mensaje.setText("");
        importancia.setSelectedIndex(0);
        //motivos;
        notasAdicionales.setText("");
        seguimiento.setSelected(false);

        //Limpiamos los errores
        errorNombre.setText("");
        errorDestinatario.setText("");
        errorTelefono.setText("");
        errorMensaje.setText("");
        errorImportancia.setText("");
        errorTipoDestinatario.setText("");
    }

}
