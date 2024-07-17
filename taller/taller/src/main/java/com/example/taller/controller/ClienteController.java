package com.example.taller.controller;


import com.example.taller.model.Cliente;
import com.example.taller.model.Usuario;
import com.example.taller.repository.ClienteRepository;
import com.example.taller.repository.UsuarioRepository;
import com.example.taller.service.ClienteService;
import com.example.taller.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author FABIAN
 */
@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public String getAllClientes(Model model) {
        model.addAttribute("clientes", clienteRepository.findAll());
        return "clientes";
    }

    @GetMapping("/add")
    public String addClienteForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "addCliente";
    }

    @PostMapping("/add")
    public String addCliente(@ModelAttribute Cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/edit/{id}")
    public String editClienteForm(@PathVariable Integer id, Model model) {
        model.addAttribute("cliente", clienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid cliente Id:" + id)));
        return "editCliente";
    }

    @PostMapping("/edit")
    public String editCliente(@ModelAttribute Cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/delete/{id}")
    public String deleteCliente(@PathVariable Integer id) {
        clienteRepository.deleteById(id);
        return "redirect:/clientes";
    }
}