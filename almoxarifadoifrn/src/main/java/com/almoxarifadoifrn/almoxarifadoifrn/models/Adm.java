package com.almoxarifadoifrn.almoxarifadoifrn.models;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Adm implements UserDetails{
	
	@Id
	private String login; private String senha; private String nome;
	public String getNome() { return nome;}
	public void setNome(String nome) { this.nome = nome;}
	public String getLogin() { return login;}
	public void setLogin(String login) { this.login = login;}
	public String getSenha() {return senha;}
	public void setSenha(String senha) { this.senha = senha;}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { return null; }
	@Override
	public String getPassword() { return senha;}
	@Override
	public String getUsername() { return login; }
	@Override
	public boolean isAccountNonExpired() { return true;}
	@Override
	public boolean isAccountNonLocked() { return true;}
	@Override
	public boolean isCredentialsNonExpired() { return true;}
	@Override
	public boolean isEnabled() { return true;}}

