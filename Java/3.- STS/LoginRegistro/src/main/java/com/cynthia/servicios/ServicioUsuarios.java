package com.cynthia.servicios;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.cynthia.modelos.LoginUsuario;
import com.cynthia.modelos.Usuario;
import com.cynthia.repositorios.RepositorioUsuarios;

@Service
public class ServicioUsuarios {

	@Autowired
	private RepositorioUsuarios repoUsuarios;
	
	//Método que me guarde el nuevo registro SIEMPRE Y CUANDO cumpla con todas las validaciones (incluyendo 2 validaciones manuales)
	public Usuario registrar(Usuario nuevoUsuario, BindingResult result) {
		//Comparar las contraseñas
		String password = nuevoUsuario.getPassword();
		String confirmacion = nuevoUsuario.getConfirmacion();
		if(!password.equals(confirmacion)) {
			//Si son diferentes password y confirmación
			result.rejectValue("confirmacion", "Matches", "Los passwords no coinciden"); //Crear un error
			//(atributo, clave, mensaje)
		}
		
		//Revisar que el email no esté registrando
		String email = nuevoUsuario.getEmail();
		//Objeto Usuario (registro de mi bd) o null
		Usuario existeUsuario = repoUsuarios.findByEmail(email);
		if(existeUsuario != null) {
			//Ese email ya existe en BD
			result.rejectValue("email", "Unique", "El email ya está registrado en el sistema, elija otro");
		}
		
		//Si no hay errores, entonces guardamos el usuario
		if(result.hasErrors()) {
			return null;
		} else {
			//No hay errores
			//Hasheo la contraseña
			String passwordHasheado = BCrypt.hashpw(password, BCrypt.gensalt());
			nuevoUsuario.setPassword(passwordHasheado); //Establezco el password hasheado como pw
			
			return repoUsuarios.save(nuevoUsuario);
		}
	}
	
	//Método que haga las validaciones del inicio de sesión
	public Usuario login(LoginUsuario usuarioIniciandoSesion, BindingResult result) {
		//Revisar que el email exista en mi BD
		String email = usuarioIniciandoSesion.getEmailLogin(); //Obtenemos el email con el que intenta iniciar sesión 
		Usuario existeUsuario = repoUsuarios.findByEmail(email); //Objeto usuario (registro bd) o null
		if(existeUsuario == null) {
			//No existe ningún usuario con ese correo
			result.rejectValue("emailLogin", "Unique", "E-mail no registrado");
		} else if(! BCrypt.checkpw(usuarioIniciandoSesion.getPasswordLogin(), existeUsuario.getPassword())) {
			//No coincide el password ingresado con el de la BD
			result.rejectValue("passwordLogin", "Matches", "Password incorrecto");
		}
		
		if(result.hasErrors()) {
			return null;
		} else {
			return existeUsuario;
		}
	}
	
}
