package modelo.dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.dto.CategoriaDTO;

public class CategoriaDAO {
    // Registra una nueva categoría en la base de datos.
    public boolean registrar(CategoriaDTO categoria) {
        String sql = "INSERT INTO categorias (nombre_categoria) VALUES (?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, categoria.getNombreCategoria());

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            System.out.println("Error al registrar categoria: " + e.getMessage());
            return false;
        }
    }
    // Lista todas las categorías disponibles para clasificar los mensajes del foro.
    public List<CategoriaDTO> listarTodas() {
        List<CategoriaDTO> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categorias ORDER BY nombre_categoria";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                CategoriaDTO categoria = new CategoriaDTO();

                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNombreCategoria(rs.getString("nombre_categoria"));

                categorias.add(categoria);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar categorias: " + e.getMessage());
        }

        return categorias;
    }
    // Busca una categoría específica mediante su identificador.
    public CategoriaDTO buscarPorId(int idCategoria) {
        String sql = "SELECT * FROM categorias WHERE id_categoria = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCategoria);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                CategoriaDTO categoria = new CategoriaDTO();

                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNombreCategoria(rs.getString("nombre_categoria"));

                return categoria;
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar categoria: " + e.getMessage());
        }

        return null;
    }
}
