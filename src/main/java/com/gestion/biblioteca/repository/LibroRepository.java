package com.gestion.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.biblioteca.entity.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long>{

}
