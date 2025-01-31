package com.gestion.biblioteca.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.biblioteca.entity.Libro;
import com.gestion.biblioteca.entity.Prestamo;
import com.gestion.biblioteca.entity.Usuario;
import com.gestion.biblioteca.service.BibliotecaService;

import lombok.AllArgsConstructor;

//No equivocarme con controller
@RestController
@RequestMapping("/api/biblioteca")
@AllArgsConstructor
public class BibliotecaController {
	
	private BibliotecaService bibliotecaService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Libro> findAll(){
		return bibliotecaService.findAll();
	}
	
	//Añade libros
	@PostMapping(path = "/libro",produces = MediaType.APPLICATION_JSON_VALUE)
	public Libro addLibro(@RequestBody Libro libro) {
		return bibliotecaService.addLibro(libro);
	}
	
	//Añade usuarios
	@PostMapping(path = "/usuario",produces = MediaType.APPLICATION_JSON_VALUE)
	public Usuario addUsuario(@RequestBody Usuario usuario) {
		return bibliotecaService.addUsuario(usuario);
	}
	
	//Añade prestamo
	@PostMapping(path = "/prestamo",produces = MediaType.APPLICATION_JSON_VALUE)
	public Prestamo addPrestamo(@RequestBody Prestamo prestamo) {
		return bibliotecaService.addPrestamo(prestamo);
	}

	//Actualiza el Estado en biblioteca
	@PutMapping(path = "/libro/{idLibro}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Libro actualizarEstado(@PathVariable long idLibro) {
		return bibliotecaService.updateEstado(idLibro);
	}
	
	//Actualiza la categoria usuario
	@PutMapping(path = "/usuario/{idUsuario}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Usuario actualizarCategoria(@PathVariable long idUsuario) {
		return bibliotecaService.updateCategory(idUsuario);
	}
	
	//Actualiza la fecha de fin del prestamo
	@PutMapping(path = "/prestamo/{idUsuario}/{idLibro}"
			, produces = MediaType.APPLICATION_JSON_VALUE)
	public Prestamo actualizarFechaFin(@PathVariable long idUsuario
			,@PathVariable long idLibro, @RequestBody String fecha) {
		return bibliotecaService.updateDate(idUsuario, idLibro, fecha);
	}
	
	//Actualiza el numero de paginas
	@PutMapping(path = "/libro/{idLibro}/{Npaginas}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Libro actualizarNpaginas(@PathVariable long idLibro, @PathVariable int Npaginas) {
		return bibliotecaService.updateNpaginas(idLibro,Npaginas);
	}
}
