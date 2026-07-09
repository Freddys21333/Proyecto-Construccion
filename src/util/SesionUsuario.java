package util;

import modelo.dto.UsuarioDTO;

public class SesionUsuario {
    // Variable global utilizada para mantener la sesión del usuario actual.
    // Permite acceder a los datos del usuario desde diferentes ventanas del sistema.
    public static UsuarioDTO usuarioActual = null;

}
