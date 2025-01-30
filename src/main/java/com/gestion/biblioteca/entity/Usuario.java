package com.gestion.biblioteca.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
@Table(name = "USUARIO", schema = "BIBLIOTECA")
public class Usuario {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "NOMBRE",length = 30)
	private String nombre;
	
	@Column(name = "APELLIDO1",length = 20)
	private String apellido1;
	
	@Column(name = "APELLIDO2",length = 20)
	private String apellido2;
	
	@Column(name = "CIUDAD",length = 20)
	private String ciudad;

	@Column(name = "CATEGORIA")
	private double categoria;
	
	@Column(name = "FECHA_INGRESO")
	@Temporal(TemporalType.DATE)
	private Date fechaIngreso;

}
