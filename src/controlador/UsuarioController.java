package controlador;

import modelo.dao.UsuarioDAO;
import modelo.dto.UsuarioDTO;
import util.SesionUsuario;

public class UsuarioController {

    private UsuarioDAO usuarioDAO;

    public UsuarioController() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public String registrarUsuario(String nombre, String correo, String password, String confirmarPassword) {

        if (nombre == null || nombre.trim().isEmpty()) {
            return "El nombre es obligatorio.";
        }

        if (correo == null || correo.trim().isEmpty()) {
            return "El correo es obligatorio.";
        }

        if (!correo.contains("@") || !correo.contains(".")) {
            return "Ingrese un correo válido.";
        }

        if (password == null || password.trim().isEmpty()) {
            return "La contraseña es obligatoria.";
        }

        if (password.length() < 4) {
            return "La contraseña debe tener al menos 4 caracteres.";
        }

        if (!password.equals(confirmarPassword)) {
            return "Las contraseñas no coinciden.";
        }

        if (usuarioDAO.existeCorreo(correo)) {
            return "El correo ya se encuentra registrado.";
        }

        UsuarioDTO usuario = new UsuarioDTO(nombre.trim(), correo.trim(), password);

        boolean registrado = usuarioDAO.registrar(usuario);

        if (registrado) {
            return "OK";
        } else {
            return "No se pudo registrar el usuario.";
        }
    }

    public String iniciarSesion(String correo, String password) {

        if (correo == null || correo.trim().isEmpty()) {
            return "El correo es obligatorio.";
        }

        if (password == null || password.trim().isEmpty()) {
            return "La contraseña es obligatoria.";
        }

        UsuarioDTO usuario = usuarioDAO.iniciarSesion(correo.trim(), password);

        if (usuario != null) {
            SesionUsuario.usuarioActual = usuario;
            return "OK";
        } else {
            return "Correo o contraseña incorrectos.";
        }
    }

    public void cerrarSesion() {
        SesionUsuario.usuarioActual = null;
    }
}
