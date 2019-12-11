package com.almoxarifadoifrn.almoxarifadoifrn.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Material implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long codigo;
	@NotEmpty
	private String titulo;
	@NotEmpty
	private String descricao;
	private String cor;
	
	public long getCodigo() { 
		return codigo;
		}
	public void setCodigo(long codigo) { 
		this.codigo = codigo;
		}
	public String getTitulo() { 
		return titulo;
		}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
		}
	public String getDescricao() {
		return descricao;
		}
	public void setDescricao(String descricao) { 
		this.descricao = descricao;
		}
	public String getCor() { 
		return cor;
		}
	public void setCor(String cor) { 
		this.cor = cor;
		}
	}
