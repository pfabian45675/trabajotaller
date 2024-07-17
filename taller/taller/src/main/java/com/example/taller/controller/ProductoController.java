/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.taller.controller;

//import com.example.taller.service.ProductoService;

import com.example.taller.model.Producto;
import com.example.taller.repository.ProductoRepository;
import com.example.taller.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;


//import java.util.List;
//import java.util.Optional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import com.example.taller.model.Producto;

/**
 *
 * @author FABIAN
 */
@Controller
@RequestMapping("/productos")
public class ProductoController {

     @Autowired
    private ProductoService productoService;

    @GetMapping("/view")
    public String viewProductos(Model model) {
        List<Producto> productos = productoService.getAllProductos(); // Asegúrate de usar el servicio para obtener los productos
        model.addAttribute("productos", productos);
        return "productos"; // Devuelve la vista productos.html
    }

    @GetMapping("/add")
    public String addProductoForm(Model model) {
        model.addAttribute("producto", new Producto());
        return "addProducto"; // Devuelve la vista addProducto.html
    }

    @PostMapping("/add")
    public String addProducto(@ModelAttribute Producto producto) {
        productoService.saveProducto(producto);
        return "redirect:/productos/view";
    }
    @GetMapping("/edit/{id}")
    public String editProductoForm(@PathVariable("id") Integer id, Model model) {
        Producto producto = productoService.getProductoById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid producto Id:" + id));
        model.addAttribute("producto", producto);
        return "editProducto"; // Devuelve la vista editProducto.html
    }

    @PostMapping("/edit")
    public String updateProducto(@ModelAttribute Producto producto) {
        productoService.saveProducto(producto);
        return "redirect:/productos/view";
    }

    @GetMapping("/delete/{id}")
    public String deleteProducto(@PathVariable("id") Integer id) {
        productoService.deleteProducto(id);
        return "redirect:/productos/view";
    }
    
}