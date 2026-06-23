package com.skillnest.patitas.modelos;


import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Por favor proporciona tu nombre")
	@Size(min=3, message = "El nombre debe tener al menos 3 caracteres")
	private String nombre;
	
	@NotBlank(message = "Por favor proporciona tu apellido")
	@Size(min=2, message = "El apellido debe tener al menos 2 caracteres")
	private String apellido;
	
	@NotBlank(message = "Por favor ingresa un correo")
	@Email(message = "por favor ingresa correo válido")
	private String email;
	
	@NotBlank(message = "Por favor ingresa una contraseña")
	@Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
	private String password;
	
	@Transient
	@NotBlank(message = "Por favor confirma tu contraseña")
	private String confirmarPassword;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	@OneToMany(mappedBy = "publicadoPor", fetch = FetchType.LAZY)
	private List<Mascota> mascotas;
	

}
