package com.skillnest.cynthia.modelos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity //Es un objeto de mi base de datos
@Table(name="usuarios") //Nombre de la tabla
public class Usuario {
	
	@Id //Primary Key o Clave primaria
	@GeneratedValue(strategy=GenerationType.IDENTITY) //AI: Autoincremento
	private Long id;
	
	@NotNull //No puede ser vacío
	@Size(min=2, max=15, message="El nombre debe tener entre 2 y 15 caracteres")
	private String nombre;
	
	@NotNull
	@Size(min=2, max=60)
	private String apellido;
	
	@NotNull //@NotEmpty
	@Email //Valida que sea un correo electrónico correcto
	private String email;
	
	//2026-06-18
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="curso_id") //Clave foránea
	private Curso curso;
	
	//Constructor vacío
	public Usuario() {
		
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	//ANTES de crear un nuevo registro
	@PrePersist
	protected void onCreate() {
       this.createdAt = new Date(); //createdAt = CURRENT_TIMESTAMP
       this.updatedAt = this.createdAt;
	}
	
	//ANTES de que actualice un registro
	@PreUpdate
	protected void onUpdate() {
       this.updatedAt = new Date(); //updatedAt = CURRENT_TIMESTAMP
	}
	
}
