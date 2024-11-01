package vista;




import componentes.CampoTexto;
import componentes.Paneles;
import componentes.Selectores;
import controlador.ControladorUsuarios;
import modelo.Usuario;
import utiles.Colores;


import static vista.VentanaPrincipal.controladorUsuarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import static vista.VentanaPrincipal.ventanaRegistroUsuarios;


public class VentanaRegistro extends JPanel {
    // Atributos
    private JPanel panelPrincipal, panelDerecha, panelIzquierda,pTitulo, pNombre, pApellido, pEmail, pContrasena, pRol, pBotones;
    private JPanel pErrorNombre, pErrorApellido, pErrorEmail, pErrorPassword, pErrorRol;
    private JLabel titulo, txtNombre, txtApellido, txtEmail, txtContrasena, txtRol;
    private JTextField nombre, apellido, email;
    private JPasswordField contrasena;
    private JComboBox<String> rol;
    private JButton btnRegistrar, btnCancelar;

        //atributos para los mensajes de error
    private JLabel errorNombre, errorApellido, errorEmail, errorPassword, errorRol;




    public VentanaRegistro(ControladorUsuarios controladorUsuarios, VentanaListadoUsuarios ventanaListadoUsuarios){
        setSize(1200,900);

        panelPrincipal();
        //añadimos el panel principal al panel de ventanaRegistro
        this.add(panelPrincipal);
        //crearemos dos paneles para partir la interfaz
        crearPanelIzquierda();
        crearPanelDerecha();

        //creamos instancia de nuestra clase que valida los campos del formulario
   }

    private void panelPrincipal(){
        //creamos panel principal para organizar
        panelPrincipal = new JPanel(new BorderLayout());

    }

    private void crearPanelIzquierda(){
        panelIzquierda = new JPanel();
        panelIzquierda.setPreferredSize(new Dimension(400, 900));
        panelIzquierda.setBackground(Colores.VIOLETA);
        panelIzquierda.setLayout(new BoxLayout(panelIzquierda, BoxLayout.Y_AXIS));
        crearComponentesPanelIzquierdo();

        panelPrincipal.add(panelIzquierda, BorderLayout.WEST);
    }


   private void crearPanelDerecha(){
        panelDerecha = new JPanel();
        //organizaremos el panel verticalmente
        panelDerecha.setLayout(new BoxLayout(panelDerecha, BoxLayout.Y_AXIS));
        panelDerecha.setPreferredSize(new Dimension(800,900));
        crearComponentesFormulario();
        panelPrincipal.add(panelDerecha, BorderLayout.CENTER);
        //actualizamos la vista
        panelDerecha.revalidate();
        // dibujamos el panel
        panelDerecha.repaint();

   }

    private void crearComponentesPanelIzquierdo(){
        //titulo formulario
        pTitulo = new JPanel();
        pTitulo.setBorder(BorderFactory.createEmptyBorder(40, 30, 40, 10));
        pTitulo.setBackground(Colores.VIOLETA);
        titulo = CampoTexto.crearTitulo("Registro de Usuarios");
        pTitulo.setLayout(new FlowLayout(FlowLayout.CENTER));  //ajustamos titulo al centro
        pTitulo.add(titulo);
        pTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        //pTitulo.setAlignmentY(Component.CENTER_ALIGNMENT);
        panelIzquierda.add(pTitulo);


        //añadimos imagen
        ImageIcon imagenUsuario = new ImageIcon("resources"+ File.separator+"more_users.png");  //llamamos a la imagen
        Image imagen = imagenUsuario.getImage().getScaledInstance(300,400,Image.SCALE_SMOOTH);  //escalamos la imagen
        ImageIcon iconUsuario = new ImageIcon(imagen);  //la volvemos a convertir
        JLabel imgUsuario = new JLabel(iconUsuario);  //la introducimos en la etiqueta
        imgUsuario.setBorder(BorderFactory.createEmptyBorder(40, 10, 40, 10));
        imgUsuario.setAlignmentX(Component.CENTER_ALIGNMENT); //centramos la imagen horizontal
        imgUsuario.setAlignmentY(Component.CENTER_ALIGNMENT); //centramos la imagen vertical
        panelIzquierda.add(imgUsuario);


    }


    private void crearComponentesFormulario() {


        //añadimos espacio en la parte superior del formulario
        panelDerecha.add(Box.createVerticalStrut(40));
        // Creamos los componentes
        txtNombre = CampoTexto.crearEtiqueta("Nombre: ");
        nombre = CampoTexto.crearCampoTexto();
        nombre.setToolTipText("Introduce tu nombre");
        txtNombre.setLabelFor(nombre);
        pNombre = Paneles.crearPanelHorizontal();
        pNombre.add(txtNombre);
        pNombre.add(nombre);
        ////errores
        pErrorNombre = Paneles.crearPanelVertical();
        errorNombre = CampoTexto.crearEtiquetaError();
        pErrorNombre.add(pNombre);
        pErrorNombre.add(errorNombre);



        txtApellido = CampoTexto.crearEtiqueta("Apellido: ");
        apellido = CampoTexto.crearCampoTexto();
        apellido.setToolTipText("Introduce tu apellido");
        txtApellido.setLabelFor(apellido);
        pApellido = Paneles.crearPanelHorizontal();
        pApellido.add(txtApellido);
        pApellido.add(apellido);
        /////errores
        pErrorApellido = Paneles.crearPanelVertical();
        errorApellido = CampoTexto.crearEtiquetaError();
        pErrorApellido.add(pApellido);
        pErrorApellido.add(errorApellido);



        txtEmail = CampoTexto.crearEtiqueta("Email: ");
        email = CampoTexto.crearCampoTexto();
        email.setToolTipText("Introduce tu email");
        txtEmail.setLabelFor(email);
        pEmail = Paneles.crearPanelHorizontal();
        pEmail.add(txtEmail);
        pEmail.add(email);
        ////errores
        pErrorEmail = Paneles.crearPanelVertical();
        errorEmail = CampoTexto.crearEtiquetaError();
        pErrorEmail.add(pEmail);
        pErrorEmail.add(errorEmail);



        txtContrasena = CampoTexto.crearEtiqueta("Contraseña: ");
        contrasena = CampoTexto.crearCampoPassword();
        contrasena.setToolTipText("Introduce tu contraseña");
        txtContrasena.setLabelFor(contrasena);
        pContrasena = Paneles.crearPanelHorizontal();
        pContrasena.add(txtContrasena);
        pContrasena.add(contrasena);
        ////errores
        pErrorPassword = Paneles.crearPanelVertical();
        errorPassword = CampoTexto.crearEtiquetaError();
        pErrorPassword.add(pContrasena);
        pErrorPassword.add(errorPassword);




        txtRol = CampoTexto.crearEtiqueta("Rol: ");
        rol = Selectores.comboBoxRol();
        rol.setToolTipText("Selecciona el rol del usuario");
        txtRol.setLabelFor(rol);
        pRol = Paneles.crearPanelHorizontal();
        pRol.add(txtRol);
        pRol.add(rol);
        ////errores
        pErrorRol = Paneles.crearPanelVertical();
        errorRol = CampoTexto.crearEtiquetaError();
        pErrorRol.add(pRol);
        pErrorRol.add(errorRol);




        // Añadimos todos los pequeños paneles al panel principal

        panelDerecha.add(pErrorNombre);
        panelDerecha.add(pErrorApellido);
        panelDerecha.add(pErrorEmail);
        panelDerecha.add(pErrorPassword);
        panelDerecha.add(pErrorRol);


        // Boton para enviar el registro
        btnRegistrar = Selectores.crearBoton("Registrar Usuario");
        btnCancelar = Selectores.crearBoton("Cancelar");
        btnCancelar.setBackground(Color.BLACK);
        pBotones = Paneles.crearPanelHorizontal();
        pBotones.add(btnRegistrar);
        pBotones.add(Box.createHorizontalStrut(30));
        pBotones.add(btnCancelar);
        panelDerecha.add(pBotones);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarUsuario();
                //metodo para actualizar la tabla
                //ventanaListadoUsuarios.actualizarTabla();
            }
        });
        btnCancelar.addActionListener(e -> limpiarFormularioUsuarios());

    }

    private void registrarUsuario(){
        //recogemos los campos del formulario
        String nombreUsuario = nombre.getText().trim();
        String apellidoUsuario = apellido.getText().trim();
        String emailUsuario = email.getText().trim();
        //debemos hacer este cambio para cambiar de contraseña a String
        String passwordUsuario = new String(contrasena.getPassword()).trim();
        // casteamos el elemento que esta seleccionado
        String rolUsuario = (String) rol.getSelectedItem();



        // validamos los datos y recogemos los mensajes de error
        String smsErrorNombre = controladorUsuarios.validarNombre(nombreUsuario);
        String smsErrorApellido = controladorUsuarios.validarApellido(apellidoUsuario);
        String smsErrorEmail = controladorUsuarios.valiadarEmail(emailUsuario);
        String smsErrorPassword = controladorUsuarios.validarPassword(passwordUsuario);
        String smsErrorRol = controladorUsuarios.validarRol(rolUsuario);

        //Limpiamos las etiquetas de error o nos da fallo  -> IMPORTANTE
        errorNombre.setText("");
        errorApellido.setText("");
        errorEmail.setText("");
        errorPassword.setText("");
        errorRol.setText("");


        //mostramos errores
        if(!smsErrorNombre.isEmpty()){
            this.errorNombre.setText(smsErrorNombre);
        }

        if(!smsErrorApellido.isEmpty()){
            // añadimos el mensaej y lo metemos en el panel
            this.errorApellido.setText(smsErrorApellido);
        }

        if(!smsErrorEmail.isEmpty()){
            this.errorEmail.setText(smsErrorEmail);
        }

        if(!smsErrorPassword.isEmpty()){
            this.errorPassword.setText(smsErrorPassword);
        }

        if(!smsErrorRol.isEmpty()){
            this.errorRol.setText(smsErrorRol);
        }

        //revalidar para ajuste el tamaño automaticamente para cuando se añade o se quita un componente
        panelDerecha.revalidate();
        //actualizamos la interfaz que se muestra
        panelDerecha.repaint();


        //Si no hay errores, se guardan los datos en el usuario
        if(smsErrorNombre.isEmpty() && smsErrorApellido.isEmpty() && smsErrorEmail.isEmpty()
                && smsErrorPassword.isEmpty() && smsErrorRol.isEmpty()){

            controladorUsuarios.agregarUsuario(nombreUsuario, apellidoUsuario, emailUsuario, passwordUsuario, rolUsuario);
            ventanaRegistroUsuarios.actualizarTabla();
            //mostramos por pantalla que el usuarios se ha guardado
            JOptionPane.showMessageDialog(this, "Usuario registrado correctamente");
            limpiarFormularioUsuarios(); //vaciamos formulario despues de guardar
        }

    }

    private void limpiarFormularioUsuarios(){
        this.nombre.setText("");
        this.apellido.setText("");
        this.email.setText("");
        this.contrasena.setText("");
        this.rol.setSelectedIndex(0);

        //limpiamos errores
        errorNombre.setText("");
        errorApellido.setText("");
        errorEmail.setText("");
        errorPassword.setText("");
        errorRol.setText("");
    }


}









