package com.gestion.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.biblioteca.entity.Prestamo;
import com.gestion.biblioteca.entity.PrestamoId;

public interface PrestamoRepository extends JpaRepository<Prestamo, PrestamoId> {

}
