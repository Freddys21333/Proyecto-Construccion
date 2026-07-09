package controlador;

import java.util.List;
import modelo.dao.MensajeDAO;
import modelo.dto.MensajeDTO;
import util.SesionUsuario;

public class MensajeController {

    private MensajeDAO mensajeDAO;

    public MensajeController() {
        this.mensajeDAO = new MensajeDAO();
    }

    public String publicarMensaje(String titulo, String contenido, int idCategoria) {

        if (SesionUsuario.usuarioActual == null) {
            return "Debe iniciar sesion para publicar un mensaje.";
        }

        if (titulo == null || titulo.trim().isEmpty()) {
            return "El titulo es obligatorio.";
        }

        if (contenido == null || contenido.trim().isEmpty()) {
            return "El contenido es obligatorio.";
        }

        if (idCategoria <= 0) {
            return "Debe seleccionar una categoria.";
        }

        MensajeDTO mensaje = new MensajeDTO(
                titulo.trim(),
                contenido.trim(),
                SesionUsuario.usuarioActual.getIdUsuario(),
                idCategoria
        );

        boolean publicado = mensajeDAO.registrar(mensaje);

        if (publicado) {
            return "OK";
        } else {
            return "No se pudo publicar el mensaje.";
        }
    }

    public List<MensajeDTO> listarMensajes() {
        return mensajeDAO.listarTodos();
    }

    public List<MensajeDTO> listarMensajesPorCategoria(int idCategoria) {
        if (idCategoria <= 0) {
            return mensajeDAO.listarTodos();
        }
        return mensajeDAO.listarPorCategoria(idCategoria);
    }

    public List<MensajeDTO> listarMensajesPorUsuario(int idUsuario) {
        return mensajeDAO.listarPorUsuario(idUsuario);
    }

    public String eliminarMensaje(int idMensaje) {
        boolean eliminado = mensajeDAO.eliminar(idMensaje);

        if (eliminado) {
            return "OK";
        } else {
            return "No se pudo eliminar el mensaje.";
        }
    }
}
