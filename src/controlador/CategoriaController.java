package controlador;

import java.util.List;
import modelo.dao.CategoriaDAO;
import modelo.dto.CategoriaDTO;

public class CategoriaController {

    private CategoriaDAO categoriaDAO;

    public CategoriaController() {
        this.categoriaDAO = new CategoriaDAO();
    }
    // Obtiene todas las categorías registradas en la base de datos.
    public List<CategoriaDTO> obtenerCategorias() {
        return categoriaDAO.listarTodas();
    }
    // Busca una categoría específica mediante su identificador.
    public CategoriaDTO obtenerCategoriaPorId(int idCategoria) {
        return categoriaDAO.buscarPorId(idCategoria);
    }
    // Valida y registra una nueva categoría.
    public String registrarCategoria(String nombreCategoria) {

        if (nombreCategoria == null || nombreCategoria.trim().isEmpty()) {
            return "El nombre de la categoria es obligatorio.";
        }
        // Crea el DTO con el nombre de la categoría ingresada.
        CategoriaDTO categoria = new CategoriaDTO(nombreCategoria.trim());

        boolean registrada = categoriaDAO.registrar(categoria);

        if (registrada) {
            return "OK";
        } else {
            return "No se pudo registrar la categoria.";
        }
    }
}
