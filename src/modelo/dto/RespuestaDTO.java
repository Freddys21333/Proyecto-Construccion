package modelo.dto;

public class RespuestaDTO {

    private int idRespuesta;
    private int idMensaje;
    private int idUsuario;
    private String contenido;
    private String fechaRespuesta;

    // Campo adicional (no se guarda en BD), usado para mostrar el nombre
    // del autor de la respuesta en el listado sin consultar aparte.
    private String nombreUsuario;

    public RespuestaDTO() {
    }

    public RespuestaDTO(int idRespuesta, int idMensaje, int idUsuario, String contenido, String fechaRespuesta) {
        this.idRespuesta = idRespuesta;
        this.idMensaje = idMensaje;
        this.idUsuario = idUsuario;
        this.contenido = contenido;
        this.fechaRespuesta = fechaRespuesta;
    }

    public RespuestaDTO(int idMensaje, int idUsuario, String contenido) {
        this.idMensaje = idMensaje;
        this.idUsuario = idUsuario;
        this.contenido = contenido;
    }

    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(String fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
