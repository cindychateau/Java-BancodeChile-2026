package com.skillnest.patitas.modelos;


import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;



@Entity
@Table(name = "mascotas")
public class Mascota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Por favor proporciona el nombre")
	@Size(min = 3, message = "El nombre debe tener al menos 3 caracteres")
	private String nombre;
	
	@NotBlank(message = "Por favor proporciona la especie")
	@Size(min = 3, message = "La especie debe tener al menos 3 caracteres")
	private String especie;
	
	@NotBlank(message = "Por favor proporciona la raza")
	private String raza;
	
	@NotNull(message = "Por favor proporciona la edad")
	@Positive(message= "La edad debe ser un número positivo")
	private Integer edad;
	
	@NotBlank(message = "Por favor proporciona la descripción")
	@Size(min = 10, message = "La descripción debe tener al menos 10 caracteres")
	private String descripcion;
	
	@NotBlank(message = "por favor proporciona la URL de la imagen")
	@Pattern(regexp =  "(?i).+\\.(jpg|jpeg|png|gif|webp)$", message = "La URL debe terminar en una extensión de imagen")
	private String urlImagen;
	
	private boolean esterilizado;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario publicadoPor;
	
	public Mascota() {}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
		this.updatedAt = this.createdAt;
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
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

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripción) {
		this.descripcion = descripción;
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

	public Usuario getPublicadoPor() {
		return publicadoPor;
	}

	public void setPublicadoPor(Usuario publicadoPor) {
		this.publicadoPor = publicadoPor;
	}
	
	public boolean isEsterilizado() {
		return esterilizado;
	}
	
	public void setEsterilizado(boolean esterilizado) {
		this.esterilizado = esterilizado;
	}
	
	
}
