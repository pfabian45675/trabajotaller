/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.taller.repository;

import com.example.taller.model.Venta;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author FABIAN
 */
public interface VentaRepository extends JpaRepository<Venta, Integer> {
// No necesitas definir métodos customizados si solo quieres operaciones CRUD básicas
    // Si quieres un método customizado, define una consulta o usa @Query

}
