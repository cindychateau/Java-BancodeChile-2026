package com.cynthia.modelos;

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="recetas")
public class Receta {
	
	@Id //Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-increment
	private Long id;
	
	@NotBlank
	@Size(min=5)
	private String nombre;
	
	@NotBlank
	@Size(min=10)
	private String descripcion;
	
	@NotBlank
	@Size(min=10)
	@Column(columnDefinition="TEXT")
	private String pasos;
	
	@NotBlank
	private String urlImagen;
	
	@Min(1)
	private Double tiempoPreparacion; //minutos
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuario_id")
	private Usuario creador;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="favoritos",
			joinColumns = @JoinColumn(name="receta_id"),
			inverseJoinColumns = @JoinColumn(name="usuario_id")
			)
	private List<Usuario> usuariosFavoritos;
	
	public Receta() {
		
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPasos() {
		return pasos;
	}

	public void setPasos(String pasos) {
		this.pasos = pasos;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public Double getTiempoPreparacion() {
		return tiempoPreparacion;
	}

	public void setTiempoPreparacion(Double tiempoPreparacion) {
		this.tiempoPreparacion = tiempoPreparacion;
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
	
	
	
	public Usuario getCreador() {
		return creador;
	}

	public void setCreador(Usuario creador) {
		this.creador = creador;
	}

	public List<Usuario> getUsuariosFavoritos() {
		return usuariosFavoritos;
	}

	public void setUsuariosFavoritos(List<Usuario> usuariosFavoritos) {
		this.usuariosFavoritos = usuariosFavoritos;
	}

	@PrePersist //Antes de crear el registro
	protected void onCreate() {
		this.createdAt = new Date(); //Genera una nueva fecha para createdAt (DEFAULT CURRENT_TIMESTAMP)
		this.updatedAt = this.createdAt;
	}
	
	@PreUpdate //Antes de actualizar el registro
	protected void onUpdate() {
		this.updatedAt = new Date(); //Genera una nueva fecha para updatedAt (DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP)
	}
	
}
