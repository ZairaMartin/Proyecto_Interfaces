package modelo;

public class Llamada {

    //atributos
    private String nombre;
    private String destinatario;
    private String telefono;
    private String mensaje;
    private String importancia;
    private String tipoDestinatario;
    private String notaAdicional;
    private boolean seguimiento;

    //constructor parametrizado
    public Llamada(String nombre, String destinatario, String telefono, String mensaje, String importancia, String tipoDestinatario, String notaAdicional, boolean seguimiento) {
        this.nombre = nombre;
        this.destinatario = destinatario;
        this.telefono = telefono;
        this.mensaje = mensaje;
        this.importancia = importancia;
        this.tipoDestinatario = tipoDestinatario;
        this.notaAdicional = notaAdicional;
        this.seguimiento = seguimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getImportancia() {
        return importancia;
    }

    public void setImportancia(String importancia) {
        this.importancia = importancia;
    }

    public String getTipoDestinatario() {
        return tipoDestinatario;
    }

    public void setTipoDestinatario(String tipoDestinatario) {
        this.tipoDestinatario = tipoDestinatario;
    }


    public boolean isSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(boolean seguimiento) {
        this.seguimiento = seguimiento;
    }

    public String getNotaAdicional() {
        return notaAdicional;
    }

    public void setNotaAdicional(String notaAdicional) {
        this.notaAdicional = notaAdicional;
    }

    @Override
    public String toString() {
        return "Llamada{" +
                "nombre='" + nombre + '\'' +
                ", destinatario='" + destinatario + '\'' +
                ", telefono='" + telefono + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", importancia='" + importancia + '\'' +
                ", tipoDestinatario='" + tipoDestinatario + '\'' +
                ", notaAdicional='" + notaAdicional + '\'' +
                ", seguimiento=" + seguimiento +
                '}';
    }
}
