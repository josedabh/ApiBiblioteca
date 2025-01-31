package com.gestion.biblioteca.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gestion.biblioteca.entity.Libro;
import com.gestion.biblioteca.entity.Prestamo;
import com.gestion.biblioteca.entity.PrestamoId;
import com.gestion.biblioteca.entity.Usuario;
import com.gestion.biblioteca.repository.LibroRepository;
import com.gestion.biblioteca.repository.PrestamoRepository;
import com.gestion.biblioteca.repository.UsuarioRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class BibliotecaService {
	
	private LibroRepository libroRepository;
	
	private UsuarioRepository usuarioRepository;
	
	private PrestamoRepository prestamoRepository;
	
	//Prueba
	public List<Libro> findAll(){
		return libroRepository.findAll();
	}
	
	//Introduce datos en libros
	public Libro addLibro(Libro libro) {
		libroRepository.save(libro);
		return libro;
	}
	
	//Introduce datos en usuarios
	public Usuario addUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
		return usuario;
	}
	
	//Introduce datos en prestamo
	public Prestamo addPrestamo(Prestamo prestamo) {
		prestamoRepository.save(prestamo);
		return prestamo;
	}
	
	//Cambiar estado de un producto
	public Libro updateEstado(long idLibro) {
		Libro libroEstado = libroRepository.findById(idLibro).orElse(null);
		//Vemos si existe los estado o si el libro existe
		if(libroEstado.getEstado().contains("Disponible")) {
			libroEstado.setEstado("Prestado");
		} else if (libroEstado.getEstado().contains("Prestado")) {
			libroEstado.setEstado("Disponible");
		} else {
			throw new InternalError("El estado esta dudoso");
		}
		//Guardamos el estado del libro
		libroRepository.save(libroEstado);
		return libroEstado;
	}
	
	//Actualizar categoria usuario un 25%
	public Usuario updateCategory(long idUsuario) {
		Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
		//Actualizamos el valor de categoria
		double valorActualizado = 1.25*usuario.getCategoria();
		usuario.setCategoria(valorActualizado);
		//Guardamos el estado del libro
		usuarioRepository.save(usuario);
		return usuario;
	}

	//Actualizar la fecha fin de prestamo
	public Prestamo updateDate(long idUsuario, long idLibro, String fecha) {
	    // Definir el formato correcto
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");

	    try {
	        // Crear ID del préstamo
	        PrestamoId idPrestamo = new PrestamoId(idLibro, idUsuario);
	        Prestamo prestamo = prestamoRepository.findById(idPrestamo)
	                .orElseThrow(() -> new RuntimeException("Prestamo no encontrado"));

	        // Parsear y ajustar la fecha
	        LocalDateTime fechaFin = LocalDateTime.parse(fecha.replace("\"", ""), formatter);
	        prestamo.setFechaFin(fechaFin.truncatedTo(java.time.temporal.ChronoUnit.SECONDS));

	        return prestamo;
	    } catch (DateTimeParseException e) {
	        throw new RuntimeException("Error al parsear la fecha: " + fecha, e);
	    }
	}

	
	//Actualizar el numero de paginas
	public Libro updateNpaginas(long idLibro, int Npaginas) {
		Libro updateLibro = libroRepository.findById(idLibro).orElse(null);
		//Verifica si existe
		if(updateLibro!=null) {
			//Cambia el numero de paginas y lo retorna
			updateLibro.setNPaginas(Npaginas);
			libroRepository.save(updateLibro);
			return updateLibro;
		} else {
			//Lanza una excepcion
			throw new NullPointerException();
		}
	}

}
