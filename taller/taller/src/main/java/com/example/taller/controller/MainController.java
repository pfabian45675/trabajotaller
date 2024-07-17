/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.taller.controller;

import com.example.taller.model.Cliente;
import com.example.taller.model.Producto;
import com.example.taller.model.Usuario;
import com.example.taller.model.Venta;
import com.example.taller.repository.ClienteRepository;
import com.example.taller.repository.ProductoRepository;
import com.example.taller.repository.VentaRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author FABIAN
 */
@Controller
public class MainController {

   @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/clientes-view")
    public String clientes() {
        return "clientes";
    }

    @GetMapping("/productos-view")
    public String productos() {
        return "productos";
    }

    @GetMapping("/ventas-view")
    public String ventas() {
        return "ventas";
    }

     @GetMapping("/main")
    public String mainPage() {
        return "main";
    }
}