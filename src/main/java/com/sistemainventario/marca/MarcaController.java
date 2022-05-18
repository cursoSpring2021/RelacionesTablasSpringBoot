package com.sistemainventario.marca;

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
public class MarcaController {
    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/marcas/nueva")
    public String mostrarFormularioDeCrearNuevaMarca(Model model) {
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        model.addAttribute("listaCategorias", listaCategorias);
        model.addAttribute("marca", new Marca());
        return "marca_formulario";
    }

    @PostMapping("/marcas/guardar")
    public String guardarMarca(Marca marca) {
        marcaRepository.save(marca);
        return "redirect:/";
    }

    @GetMapping("/marcas")
    public String listarMarcas(Model model) {
        List<Marca> listaMarcas = marcaRepository.findAll();
        model.addAttribute("listaMarcas", listaMarcas);
        return "marcas";

    }

    @GetMapping("/marcas/editar/{id}")
    public String mostarFormularioDeModificarMarca(@PathVariable Integer id, Model model) {
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        Marca marca = marcaRepository.findById(id).get();
        model.addAttribute("marca", marca);
        model.addAttribute("listaCategorias",listaCategorias);
        return "marca_formulario";
    }

    @GetMapping("/marcas/eliminar/{id}")
    public String eliminarMarca(@PathVariable Integer id){
        marcaRepository.deleteById(id);

        return "redirect:/";
    }

}
