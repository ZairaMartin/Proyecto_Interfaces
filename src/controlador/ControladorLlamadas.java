package controlador;

import modelo.Llamada;

import javax.swing.*;
import java.util.ArrayList;

public class ControladorLlamadas {
    private ArrayList <Llamada> listaLlamadas;

    public ControladorLlamadas(){
        listaLlamadas = new ArrayList<>();
        datosPrueba();
    }

    //controlar que no este vacio
    public String validarNombre(String nombre){
        if(nombre == null || nombre.trim().isEmpty()){
            return "El nombre no puede estar vacío";
        }
        return ""; //no devuelve mensaje de error
    }

    //controlar que no este vacio
    public String validarDestinatario(String destinatario){
        if(destinatario == null || destinatario.trim().isEmpty()){
            return "El nombre del destinatario no puede estar vacío";
        }
        return "";
    }

    //controlar que sean numeros
    public String validarTelefono(String telefono){
        if(telefono == null || telefono.trim().isEmpty()){
            return "El telefono no puede estar vacío";
        }
        if(!telefono.matches("\\d+")){
            return "El telefono debe contener solo numeros";
        }
        if(telefono.length() != 9){
            return "El telefono debe tener 9 digitos";
        }

        return "";
    }

    //controlar que el mensaje no este vacio
    public String validarMensaje(String mensaje){
        if(mensaje==null || mensaje.trim().isEmpty()){
            return "El mensaje no puede estar vacio";
        }
        return "";
    }

    //controlar que el tipo de despinatario no este vacio
    public String validarTipoDestinatario(ButtonGroup tiposDestinatarios){
        if(tiposDestinatarios.getSelection() == null){
            return "Debe elegir el destinatario de la llamada";
        }
        return "";
    }

    //controlar que le asigne importancia
    public String validarImportancia(JComboBox importancia){
        if(importancia.getSelectedIndex() == 0){
            return "Debe seleccionar un nivel de importancia";
        }
        return "";
    }

    public void agregarLlamada(String nombre, String destitanario, String telefono, String mensaje, String importancia, String tipoDestinatario, String notasAdicionales, boolean seguimiento){

        Llamada nuevaLlamada = new Llamada(nombre, destitanario, telefono, mensaje, importancia, tipoDestinatario, notasAdicionales, seguimiento);
        listaLlamadas.add(nuevaLlamada);
        System.out.println(nuevaLlamada);
    }

    public ArrayList<Llamada> getListaLlamadas() {
        return listaLlamadas;
    }

    public void eliminarLlammada(int u){
        listaLlamadas.remove(u);
    }

    private void datosPrueba(){
        Llamada llamada1 = new Llamada("Zaira", "Irene", "666123456", "Consulta sobre tratamiento", "Alta", "Paciente externo", "Urgente", true);
        Llamada llamada2 = new Llamada("Carlos", "Juan", "666987654", "Revisión de historia clínica", "Media", "Sanitario", "Revisar medicamentos", false);
        Llamada llamada3 = new Llamada("Lucía", "Ana", "666345678", "Solicitud de cita", "Baja", "Paciente interno", "Cita para el jueves", true);
        Llamada llamada4 = new Llamada("Diego", "Marta", "666876543", "Información sobre servicios", "Media", "Otro trabajador", "Consulta de servicios", false);
        Llamada llamada5 = new Llamada("Sofía", "Pedro", "666234567", "Urgente: falta medicamento", "Alta", "Transporte", "Enviar medicamentos hoy", true);
        Llamada llamada6 = new Llamada("Javier", "Clara", "666543210", "Problema con el horario", "Media", "Paciente externo", "Revisar horario de consultas", false);
        Llamada llamada7 = new Llamada("Valeria", "Luis", "666678901", "Confirmar cita", "Baja", "Paciente interno", "Confirmar para el viernes", true);
        Llamada llamada8 = new Llamada("Andrés", "Patricia", "666345789", "Queja sobre servicio", "Alta", "Sanitario", "Atención al cliente", true);
        Llamada llamada9 = new Llamada("Natalia", "Diego", "666789012", "Consulta de resultados", "Media", "Paciente externo", "Resultados de análisis", false);
        Llamada llamada10 = new Llamada("Fernando", "Sara", "666567890", "Información sobre tratamientos", "Baja", "Otro trabajador", "Solicitar información", true);
        listaLlamadas.add(llamada1);
        listaLlamadas.add(llamada2);
        listaLlamadas.add(llamada3);
        listaLlamadas.add(llamada4);
        listaLlamadas.add(llamada5);
        listaLlamadas.add(llamada6);
        listaLlamadas.add(llamada7);
        listaLlamadas.add(llamada8);
        listaLlamadas.add(llamada9);
        listaLlamadas.add(llamada10);
    }
}
