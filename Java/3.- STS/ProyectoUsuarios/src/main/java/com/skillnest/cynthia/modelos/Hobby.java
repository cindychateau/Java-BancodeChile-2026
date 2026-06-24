package com.skillnest.cynthia.modelos;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="hobbies")
public class Hobby {
	
	@Id //Primary Key o Clave primaria
	@GeneratedValue(strategy=GenerationType.IDENTITY) //AI: Autoincremento
	private Long id;
	
	@NotBlank
	private String pasatiempo;
	
	@Column(updatable=false) // Este atributo no es puede actualizar
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="usuarios_tienen_hobbies",
			joinColumns = @JoinColumn(name="hobby_id"),
			inverseJoinColumns = @JoinColumn(name="usuario_id")
			)
	private List<Usuario> usuarios;
	
	public Hobby() {} //Constructor vacío

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPasatiempo() {
		return pasatiempo;
	}

	public void setPasatiempo(String pasatiempo) {
		this.pasatiempo = pasatiempo;
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
