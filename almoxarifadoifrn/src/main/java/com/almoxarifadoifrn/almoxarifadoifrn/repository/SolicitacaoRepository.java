package com.almoxarifadoifrn.almoxarifadoifrn.repository;

import org.springframework.data.repository.CrudRepository;

import com.almoxarifadoifrn.almoxarifadoifrn.models.Solicitacao;

public interface SolicitacaoRepository extends CrudRepository <Solicitacao, String>{
	Solicitacao findByCodigo(Long codigo);
}
