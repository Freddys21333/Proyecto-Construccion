package modelo.dto;

public class MensajeDTO {

    private int idMensaje;
    private String titulo;
    private String contenido;
    private int idUsuario;
    private int idCategoria;
    private String fechaPublicacion;

    // Campos adicionales (no se guardan en BD), usados para mostrar
    // el nombre del autor y de la categoria en los listados del foro
    // sin tener que hacer una consulta aparte por cada mensaje.
    private String nombreUsuario;
    private String nombreCategoria;

    public MensajeDTO() {
    }

    public MensajeDTO(int idMensaje, String titulo, String contenido, int idUsuario,
            int idCategoria, String fechaPublicacion) {
        this.idMensaje = idMensaje;
        this.titulo = titulo;
        this.contenido = contenido;
        this.idUsuario = idUsuario;
        this.idCategoria = idCategoria;
        this.fechaPublicacion = fechaPublicacion;
    }

    public MensajeDTO(String titulo, String contenido, int idUsuario, int idCategoria) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.idUsuario = idUsuario;
        this.idCategoria = idCategoria;
    }

    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
}
