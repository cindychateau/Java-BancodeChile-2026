package com.skillnest.patitas.modelos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public class LoginUsuario {
	
	@NotBlank(message = "Por favor ingresa tu correo")
	@Email(message = "por favor ingresa un correo válido")
	private String email;
	
	@NotBlank(message = "Por favor ingresa tu contraseña")
	private String password;
	
	public LoginUsuario() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
	
	
