package com.tacsio.usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class NovoUsuarioDTO {
	
	@NotBlank
	private String name;

	@Email
	private String email;
	
	@NotBlank
	private String rawPassword;

	@NotBlank
	private String role;

	public NovoUsuarioDTO(@NotBlank String name, @Email String email, @NotBlank String rawPassword, @NotBlank String role) {
		this.name = name;
		this.email = email;
		this.rawPassword = rawPassword;
		this.role = role;
	}

	public Usuario toEntity() {
		return new Usuario(name, email, rawPassword, role);
	}
		
}