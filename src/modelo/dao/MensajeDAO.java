package modelo.dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.dto.MensajeDTO;

public class MensajeDAO {

    // Consulta base reutilizada por los distintos listados: trae el mensaje
    // junto con el nombre del autor y el nombre de la categoria mediante JOIN.
    private static final String SELECT_BASE =
            "SELECT m.*, u.nombre AS nombre_usuario, c.nombre_categoria AS nombre_categoria "
            + "FROM mensajes m "
            + "INNER JOIN usuarios u ON m.id_usuario = u.id_usuario "
            + "INNER JOIN categorias c ON m.id_categoria = c.id_categoria ";

    public boolean registrar(MensajeDTO mensaje) {
        String sql = "INSERT INTO mensajes (titulo, contenido, id_usuario, id_categoria) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, mensaje.getTitulo());
            ps.setString(2, mensaje.getContenido());
            ps.setInt(3, mensaje.getIdUsuario());
            ps.setInt(4, mensaje.getIdCategoria());

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            System.out.println("Error al registrar mensaje: " + e.getMessage());
            return false;
        }
    }

    public List<MensajeDTO> listarTodos() {
        List<MensajeDTO> mensajes = new ArrayList<>();
        String sql = SELECT_BASE + "ORDER BY m.fecha_publicacion DESC";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                mensajes.add(mapearMensaje(rs));
            }

        } catch (SQLException e) {
            System.out.println("Error al listar mensajes: " + e.getMessage());
        }

        return mensajes;
    }

    public List<MensajeDTO> listarPorCategoria(int idCategoria) {
        List<MensajeDTO> mensajes = new ArrayList<>();
        String sql = SELECT_BASE + "WHERE m.id_categoria = ? ORDER BY m.fecha_publicacion DESC";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCategoria);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                mensajes.add(mapearMensaje(rs));
            }

        } catch (SQLException e) {
            System.out.println("Error al listar mensajes por categoria: " + e.getMessage());
        }

        return mensajes;
    }

    public List<MensajeDTO> listarPorUsuario(int idUsuario) {
        List<MensajeDTO> mensajes = new ArrayList<>();
        String sql = SELECT_BASE + "WHERE m.id_usuario = ? ORDER BY m.fecha_publicacion DESC";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idUsuario);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                mensajes.add(mapearMensaje(rs));
            }

        } catch (SQLException e) {
            System.out.println("Error al listar mensajes por usuario: " + e.getMessage());
        }

        return mensajes;
    }

    public boolean eliminar(int idMensaje) {
        String sql = "DELETE FROM mensajes WHERE id_mensaje = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idMensaje);

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar mensaje: " + e.getMessage());
            return false;
        }
    }

    private MensajeDTO mapearMensaje(ResultSet rs) throws SQLException {
        MensajeDTO mensaje = new MensajeDTO();

        mensaje.setIdMensaje(rs.getInt("id_mensaje"));
        mensaje.setTitulo(rs.getString("titulo"));
        mensaje.setContenido(rs.getString("contenido"));
        mensaje.setIdUsuario(rs.getInt("id_usuario"));
        mensaje.setIdCategoria(rs.getInt("id_categoria"));
        mensaje.setFechaPublicacion(rs.getString("fecha_publicacion"));
        mensaje.setNombreUsuario(rs.getString("nombre_usuario"));
        mensaje.setNombreCategoria(rs.getString("nombre_categoria"));

        return mensaje;
    }
}
