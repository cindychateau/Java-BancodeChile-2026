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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="peliculas")
public class Pelicula {
	
	@Id //PK
    @GeneratedValue(strategy=GenerationType.IDENTITY) //AI
	private Long id;
	
	@NotBlank(message="Título obligatorio") //No en blanco
	@Size(min=2, message="Título debe tener al menos 2 caracteres") //cantidad de caracteres
	private String titulo;
	
	@NotNull //Cuando el tipo de dato es distinto a String, usamos NotNull para revisar que no esté vacío
	@Min(value=1900, message="El año mínimo es 1900") //Número mínimo
	@Max(2027) //Número máximo
	private Integer anio; 
	
	@NotBlank(message="Director obligatorio")
	private String director;
	
	@NotBlank(message="Sinopsis obligatorio")
	@Column(columnDefinition="TEXT")
	private String sinopsis; //larga
	
	@NotBlank(message="Imagen obligatoria")
	private String urlImagen;
	
	/*Cantidad en Stock Integer*/
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuario_id") //Clave foránea
	private Usuario creador; //El usuario que creó la peli
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="pelis_compradas",
			joinColumns=@JoinColumn(name="pelicula_id"),
			inverseJoinColumns=@JoinColumn(name="usuario_id")
			)
	private List<Usuario> compradores;
	
	public Pelicula() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
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

	public List<Usuario> getCompradores() {
		return compradores;
	}

	public void setCompradores(List<Usuario> compradores) {
		this.compradores = compradores;
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
