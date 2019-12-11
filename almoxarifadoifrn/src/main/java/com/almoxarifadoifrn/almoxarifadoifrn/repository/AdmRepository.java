package com.almoxarifadoifrn.almoxarifadoifrn.repository;

import org.springframework.data.repository.CrudRepository;

import com.almoxarifadoifrn.almoxarifadoifrn.models.Adm;

public interface AdmRepository extends CrudRepository <Adm, String>{
	Adm findByLogin(String login);
}
