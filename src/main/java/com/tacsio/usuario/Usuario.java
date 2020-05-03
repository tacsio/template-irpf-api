package com.tacsio.usuario;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

@UserDefinition
// @Entity
// @Table(uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
public class Usuario extends PanacheEntity {

	@NotBlank
	private String name;

	@Username
	private String email;

	@Password
	@JsonIgnore
	private String password;

	@Roles
	private String role;

	protected Usuario() {	}

	public Usuario(@NotBlank String name, @Email String email, @NotBlank String rawPassword, String role) {
		this.name = name;
		this.email = email;
		this.password = BcryptUtil.bcryptHash(rawPassword);
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getRole() {
		return role;
	}
}