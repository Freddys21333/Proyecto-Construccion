package modelo.dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.dto.UsuarioDTO;
import util.HashUtil;

public class UsuarioDAO {
    //Registra un nuevo usuario en la base de datos.
    //Utiliza PreparedStatement para evitar inyección SQL.
    public boolean registrar(UsuarioDTO usuario) {
        String sql = "INSERT INTO usuarios (nombre, correo, password) VALUES (?, ?, ?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            String passwordHash = HashUtil.sha256(usuario.getPassword());

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, passwordHash);

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
            return false;
        }
    }
    // Valida el inicio de sesión del usuario mediante correo y contraseña.
    public UsuarioDTO iniciarSesion(String correo, String password) {
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND password = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            //Se aplica el mismo hash a la contraseña ingresada para compararla con la guardada.
            String passwordHash = HashUtil.sha256(password);

            ps.setString(1, correo);
            ps.setString(2, passwordHash);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                UsuarioDTO usuario = new UsuarioDTO();

                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setPassword(rs.getString("password"));
                usuario.setFechaRegistro(rs.getString("fecha_registro"));

                return usuario;
            }

        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión: " + e.getMessage());
        }

        return null;
    }
    // Verifica si un correo ya se encuentra registrado en la base de datos.
    public boolean existeCorreo(String correo) {
        String sql = "SELECT id_usuario FROM usuarios WHERE correo = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, correo);

            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            System.out.println("Error al verificar correo: " + e.getMessage());
            return false;
        }
    }
    // Busca un usuario específico mediante su identificador.
    public UsuarioDTO buscarPorId(int idUsuario) {
        String sql = "SELECT * FROM usuarios WHERE id_usuario = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idUsuario);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                UsuarioDTO usuario = new UsuarioDTO();

                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setPassword(rs.getString("password"));
                usuario.setFechaRegistro(rs.getString("fecha_registro"));

                return usuario;
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar usuario: " + e.getMessage());
        }

        return null;
    }
}
