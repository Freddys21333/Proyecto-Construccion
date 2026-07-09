package modelo.dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.dto.RespuestaDTO;

public class RespuestaDAO {
    // Registra una nueva respuesta asociada a un mensaje del foro.
    public boolean registrar(RespuestaDTO respuesta) {
        String sql = "INSERT INTO respuestas (id_mensaje, id_usuario, contenido) VALUES (?, ?, ?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, respuesta.getIdMensaje());
            ps.setInt(2, respuesta.getIdUsuario());
            ps.setString(3, respuesta.getContenido());

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            System.out.println("Error al registrar respuesta: " + e.getMessage());
            return false;
        }
    }
    // Lista todas las respuestas pertenecientes a un mensaje específico.
    public List<RespuestaDTO> listarPorMensaje(int idMensaje) {
        List<RespuestaDTO> respuestas = new ArrayList<>();
        String sql = "SELECT r.*, u.nombre AS nombre_usuario "
                + "FROM respuestas r "
                + "INNER JOIN usuarios u ON r.id_usuario = u.id_usuario "
                + "WHERE r.id_mensaje = ? "
                + "ORDER BY r.fecha_respuesta ASC";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idMensaje);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                RespuestaDTO respuesta = new RespuestaDTO();

                respuesta.setIdRespuesta(rs.getInt("id_respuesta"));
                respuesta.setIdMensaje(rs.getInt("id_mensaje"));
                respuesta.setIdUsuario(rs.getInt("id_usuario"));
                respuesta.setContenido(rs.getString("contenido"));
                respuesta.setFechaRespuesta(rs.getString("fecha_respuesta"));
                respuesta.setNombreUsuario(rs.getString("nombre_usuario"));

                respuestas.add(respuesta);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar respuestas: " + e.getMessage());
        }

        return respuestas;
    }
    // Cuenta cuántas respuestas tiene un mensaje del foro.
    public int contarPorMensaje(int idMensaje) {
        String sql = "SELECT COUNT(*) AS total FROM respuestas WHERE id_mensaje = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idMensaje);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("total");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al contar respuestas: " + e.getMessage());
        }

        return 0;
    }
}
