package com.gestion.biblioteca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "LIBRO", schema = "BIBLIOTECA")
public class Libro {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "AUTOR",length = 20,unique = true)
	private String autor;
	
	@Column(name = "TITULO",length = 30)
	private String titulo;
	
	@Column(name = "ESTADO",length = 20,nullable = false)
	private String estado;
	
	@Column(name="N_PAGINAS",nullable = false)
	private int nPaginas;

}
