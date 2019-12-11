package com.almoxarifadoifrn.almoxarifadoifrn.repository;

import org.springframework.data.repository.CrudRepository;

import com.almoxarifadoifrn.almoxarifadoifrn.models.Usuario;

public interface UsuarioRepository extends CrudRepository <Usuario, String>{
	Usuario findByLogin(long login);

}