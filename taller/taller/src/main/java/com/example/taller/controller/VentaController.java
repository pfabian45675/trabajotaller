/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.taller.controller;

//import com.example.taller.model.Venta;
import com.example.taller.model.Venta;
import com.example.taller.repository.ClienteRepository;
import com.example.taller.repository.ProductoRepository;
import com.example.taller.repository.VentaRepository;
import com.example.taller.service.VentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.example.taller.service.VentaService;
//import java.util.List;
//import java.util.Optional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//OJOO ATENGTOE CON ESTOOOOO
/**
 *
 * @author FABIAN
 */
@Controller
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private VentaService ventaService;

    @GetMapping
    public String getAllVentas(Model model) {
        model.addAttribute("ventas", ventaRepository.findAll());
        return "ventas";
    }

    
    @GetMapping("/add")
    public String addVentaForm(Model model) {
        model.addAttribute("venta", new Venta());
        model.addAttribute("productos", productoRepository.findAll());
        model.addAttribute("clientes", clienteRepository.findAll());
        return "addVenta";
    }

    @PostMapping("/add")
    public String addVenta(@ModelAttribute Venta venta) {
        ventaRepository.save(venta);
        return "redirect:/ventas";
    }
    
    @GetMapping("/edit/{id}")
    public String editVentaForm(@PathVariable("id") Integer id, Model model) {
        Venta venta = ventaRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid venta Id:" + id));
        model.addAttribute("venta", venta);
        model.addAttribute("productos", productoRepository.findAll());
        model.addAttribute("clientes", clienteRepository.findAll());
        return "editVenta";
    }

    @PostMapping("/edit")
    public String updateVenta(@ModelAttribute Venta venta) {
        ventaRepository.save(venta);
        return "redirect:/ventas";
    }

    @GetMapping("/delete/{id}")
    public String deleteVenta(@PathVariable("id") Integer id) {
        ventaRepository.deleteById(id);
        return "redirect:/ventas";
    }
}
