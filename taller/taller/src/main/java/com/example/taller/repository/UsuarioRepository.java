/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.taller.repository;

import com.example.taller.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author FABIAN
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByUsernameAndPassword(String username, String password);
}
