package com.almoxarifadoifrn.almoxarifadoifrn.models;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Solicitacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long codigo;
	private Calendar dataSolicitacao;
	private Calendar dataDeferimento;
	@ManyToOne
	private Material material;
	
	public long getCodigo() { return codigo;}
	public void setCodigo(long codigo) { this.codigo = codigo;}
	public Calendar getDataSolicitacao() { return dataSolicitacao;}
	public void setDataSolicitação(Calendar dataSolicitacao) { this.dataSolicitacao = dataSolicitacao;}
	public Calendar getDataDeferimento() { return dataDeferimento;}
	public void setDataDeferimento(Calendar dataDeferimento) { this.dataDeferimento = dataDeferimento;}

	public Material getMaterial() { return material;}
	public void setMaterial(Material material) { this.material = material;}}