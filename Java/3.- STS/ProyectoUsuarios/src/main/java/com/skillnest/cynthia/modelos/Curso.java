package com.skillnest.cynthia.modelos;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="cursos")
public class Curso {
	
	@Id //Primary Key o Clave primaria
	@GeneratedValue(strategy=GenerationType.IDENTITY) //AI: Autoincremento
	private Long id;
	
	@NotBlank //No puede estar vacío ni ser solo un espacio en blanco
	private String nombreCurso;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@OneToMany(mappedBy="curso", fetch=FetchType.LAZY)
	private List<Usuario> usuarios; //Todos los usuarios de un curso
	
	public Curso() {} //Constructor vacío

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
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
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
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
