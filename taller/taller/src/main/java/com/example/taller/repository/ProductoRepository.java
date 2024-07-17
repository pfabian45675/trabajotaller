/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.taller.repository;

import com.example.taller.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author FABIAN
 */
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    // No necesitas un método especial para obtener todos los productos, 
    // JpaRepository ya proporciona un método `findAll()`.
}
