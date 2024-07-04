package com.bd.basico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bd.basico.modelo.TblProductoCL3;
import com.bd.basico.servicio.IProductoCL3Servicio;

@Controller
@RequestMapping("/vistas")
public class ProductoController {

    @Autowired
    private IProductoCL3Servicio productoServicio;

    @GetMapping("/listado")
    public String listarProductos(Model modelo) {
        List<TblProductoCL3> listado = productoServicio.ListadoProductos();
        modelo.addAttribute("listado", listado);
        return "Vistas/ListadoProducto"; // Asegúrate de que la ruta sea correcta aquí
    }

    @GetMapping("/registrar")
    public String registrarProducto(Model modelo) {
        TblProductoCL3 producto = new TblProductoCL3();
        modelo.addAttribute("producto", producto);
        return "Vistas/FrmCrearProducto"; // Asegúrate de que la ruta sea correcta aquí
    }

    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute TblProductoCL3 producto, Model modelo) {
        productoServicio.RegistrarProducto(producto);
        return "redirect:/vistas/ListadoProducto"; // Redirige a la página correcta después de guardar
    }

    @GetMapping("/editar/{id}")
    public String editarProducto(@PathVariable("id") Integer idProducto, Model modelo) {
        TblProductoCL3 producto = productoServicio.BuscarProductoPorId(idProducto);
        modelo.addAttribute("producto", producto);
        return "Vistas/FrmCrearProducto"; // Asegúrate de que la ruta sea correcta aquí
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") Integer idProducto, Model modelo) {
        productoServicio.EliminarProducto(idProducto);
        return "redirect:/vistas/ListadoProducto"; // 
    }
}
