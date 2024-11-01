package controlador;

import modelo.Usuario;

import javax.imageio.ImageTranscoder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ControladorUsuarios {

    private ArrayList<Usuario> lUsuarios;

    public ControladorUsuarios(){
        //pasamos la lista de usuarios por el constructor
        lUsuarios = new ArrayList<>();
        datosDePrueba();
    }


    //validar que no este vacio
    public String validarNombre(String nombre){
        if(nombre == null || nombre.trim().isEmpty()){
            return "El nombre no puede estar vacio";
        }
        return ""; //no devuelve mensaje de error

    }

    //validar que no este vacio
    public String validarApellido(String apellido){
        if(apellido == null || apellido.trim().isEmpty()){
            return "El apellido no puede estar vacío";
        }
        return ""; //no devolvemos mensaje de error

    }

    //validar que no este vacio y que contenga @
    public String valiadarEmail(String email){
        if(email == null || email.trim().isEmpty()){
            return "El email no puede estar vacío";
        }
        if(!email.contains("@")){
            return "El email es erroneo, debe contener @";
        }
        return "";
    }

    //validar que no este vacio, mas de 8 caracteres, con numero y caracteres
    public String validarPassword(String password){

        if(password == null || password.trim().isEmpty()){
            return "La contraseña no puede estar vacía";
        }else{

            // controlar que tenga todos los requisitos: mayuscula, minuscula,
            // numero, caracteres especiales y 8 caracteres minimo
            if(!password.trim().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_])[A-Za-z\\d\\W_]{8,}$")){
                return "La contraseña debe contener mayuscula, minuscula, numeros y caracteres especiales";
            }

        }
        return "";

    }

    //validar que seleccione un rol
    public String validarRol(String rol){
        if(rol == null || rol.trim().isEmpty()){
            return "Debe selecionar un rol";
        }
        return "";
    }

    // creamos el usuario y lo añadimos a la lista
    public void agregarUsuario(String nombre, String apellido, String email, String password, String rol){
        Usuario usuarioNuevo = new Usuario(nombre, apellido, email, password, rol);
        lUsuarios.add(usuarioNuevo);
        System.out.println(usuarioNuevo);
    }

    public void eliminarUsuario(int u){
        lUsuarios.remove(u);
    }

    //getter para recoger la lista de usuarios
    public ArrayList<Usuario> getlUsuarios() {
        return lUsuarios;
    }



    public void datosDePrueba(){
        Usuario u1 = new Usuario("Juan", "Pérez", "juan.perez@example.com", "contrasena123", "Administrador");
        Usuario u2 = new Usuario("María", "Gómez", "maria.gomez@example.com", "contrasena456", "Recepcionista");
        Usuario u3 = new Usuario("Carlos", "López", "carlos.lopez@example.com", "contrasena789", "Coordinador");
        Usuario u4 = new Usuario("Laura", "Martínez", "laura.martinez@example.com", "contrasena321", "Transportista");
        Usuario u5 = new Usuario("Ana", "Sánchez", "ana.sanchez@example.com", "contrasena654", "Técnico sanitario");
        Usuario u6 = new Usuario("Pedro", "Fernández", "pedro.fernandez@example.com", "contrasena987", "Administrador");
        Usuario u7 = new Usuario("Lucía", "Rodríguez", "lucia.rodriguez@example.com", "contrasena159", "Recepcionista");
        Usuario u8 = new Usuario("David", "Hernández", "david.hernandez@example.com", "contrasena753", "Coordinador");
        Usuario u9 = new Usuario("Elena", "Jiménez", "elena.jimenez@example.com", "contrasena852", "Transportista");
        Usuario u10 = new Usuario("Santiago", "Morales", "santiago.morales@example.com", "contrasena246", "Técnico sanitario");
        lUsuarios.add(u1);
        lUsuarios.add(u2);
        lUsuarios.add(u3);
        lUsuarios.add(u4);
        lUsuarios.add(u5);
        lUsuarios.add(u6);
        lUsuarios.add(u7);
        lUsuarios.add(u8);
        lUsuarios.add(u9);
        lUsuarios.add(u10);

    }
}
