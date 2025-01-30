package com.gestion.biblioteca.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PrestamoId implements Serializable{

	private final static long serialVersionUID = 1L;
	
	private long id_libro;
	
	private long id_usuario;
	
}
