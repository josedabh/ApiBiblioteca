package com.gestion.biblioteca.repository;

import org.springframework.data.repository.CrudRepository;

import com.gestion.biblioteca.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
