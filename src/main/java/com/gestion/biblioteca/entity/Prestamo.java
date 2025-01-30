package com.gestion.biblioteca.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRESTAMO", schema = "BIBLIOTECA")
public class Prestamo {
	
	@EmbeddedId
	private PrestamoId id;
	
	@ManyToOne
	@JoinColumn(name = "ID_LIBRO", insertable = false, updatable = false ,nullable = false)
	private Libro id_libro;
	
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO", insertable = false, updatable = false ,nullable = false)
	private Usuario id_usuario;
	
	@Column(name = "FECHA_INICIO", unique = true, nullable = true)
	private LocalDateTime fechaInicio;
	
	@Column(name = "FECHA_FIN",nullable = true)
	private LocalDateTime fechaFin;
	
}
