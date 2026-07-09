package controlador;

import java.util.List;
import modelo.dao.CategoriaDAO;
import modelo.dto.CategoriaDTO;

public class CategoriaController {

    private CategoriaDAO categoriaDAO;

    public CategoriaController() {
        this.categoriaDAO = new CategoriaDAO();
    }

    public List<CategoriaDTO> obtenerCategorias() {
        return categoriaDAO.listarTodas();
    }

    public CategoriaDTO obtenerCategoriaPorId(int idCategoria) {
        return categoriaDAO.buscarPorId(idCategoria);
    }

    public String registrarCategoria(String nombreCategoria) {

        if (nombreCategoria == null || nombreCategoria.trim().isEmpty()) {
            return "El nombre de la categoria es obligatorio.";
        }

        CategoriaDTO categoria = new CategoriaDTO(nombreCategoria.trim());

        boolean registrada = categoriaDAO.registrar(categoria);

        if (registrada) {
            return "OK";
        } else {
            return "No se pudo registrar la categoria.";
        }
    }
}
