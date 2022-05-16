package com.sistemainventario.producto;

import com.sistemainventario.categoria.Categoria;
import com.sistemainventario.categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("productos/nuevo")

    public String mostrarFromularioDeNuevoProducto(Model model) {
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        model.addAttribute("producto", new Producto());
        model.addAttribute("listaCategorias", listaCategorias);
        return "producto_formulario";

    }

    @PostMapping("/productos/guardar")
    public String guardarProducto(Producto producto) {
        productoRepository.save(producto);
        return "redirect:/";

    }

    @GetMapping("/productos")
    public String listarProductos(Model model) {
        List<Producto> listaProductos = productoRepository.findAll();
        model.addAttribute("listaProductos", listaProductos);
        return "productos";
    }

    @GetMapping("/productos/editar/{id}")
    public String mostrarFormularioDeModificarProducto(@PathVariable Integer id, Model model) {
        Producto producto = productoRepository.findById(id).get();
        model.addAttribute("producto", producto);
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        model.addAttribute("listaCategorias",listaCategorias);
        return "producto_formulario";
    }

    @GetMapping("/productos/eliminar/{id}")

    public String eliminarProducto(@PathVariable Integer id, Model model){
        productoRepository.deleteById(id);

        return "redirect:/productos";
    }

}
