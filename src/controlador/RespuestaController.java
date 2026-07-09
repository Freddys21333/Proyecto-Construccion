package controlador;

import java.util.List;
import modelo.dao.RespuestaDAO;
import modelo.dto.RespuestaDTO;
import util.SesionUsuario;

public class RespuestaController {

    private RespuestaDAO respuestaDAO;

    public RespuestaController() {
        this.respuestaDAO = new RespuestaDAO();
    }
    // Valida y registra una respuesta a un mensaje del foro.
    public String responderMensaje(int idMensaje, String contenido) {

        if (SesionUsuario.usuarioActual == null) {
            return "Debe iniciar sesion para responder un mensaje.";
        }

        if (idMensaje <= 0) {
            return "El mensaje no es valido.";
        }

        if (contenido == null || contenido.trim().isEmpty()) {
            return "La respuesta no puede estar vacia.";
        }

        RespuestaDTO respuesta = new RespuestaDTO(
                idMensaje,
                SesionUsuario.usuarioActual.getIdUsuario(),
                contenido.trim()
        );

        boolean registrada = respuestaDAO.registrar(respuesta);

        if (registrada) {
            return "OK";
        } else {
            return "No se pudo enviar la respuesta.";
        }
    }
    // Obtiene la lista de respuestas pertenecientes a un mensaje específico.
    public List<RespuestaDTO> listarRespuestas(int idMensaje) {
        return respuestaDAO.listarPorMensaje(idMensaje);
    }
    // Cuenta la cantidad de respuestas que tiene un mensaje específico.
    public int contarRespuestas(int idMensaje) {
        return respuestaDAO.contarPorMensaje(idMensaje);
    }
}
