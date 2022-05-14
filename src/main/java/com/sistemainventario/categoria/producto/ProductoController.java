package com.sistemainventario.categoria.producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistemainventario.categoria.Categoria;
import com.sistemainventario.categoria.CategoriaRepository;

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

}
