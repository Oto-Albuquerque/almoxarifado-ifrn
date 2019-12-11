package com.almoxarifadoifrn.almoxarifadoifrn.repository;

import org.springframework.data.repository.CrudRepository;

import com.almoxarifadoifrn.almoxarifadoifrn.models.Material;

public interface MaterialRepository extends CrudRepository <Material, String> {
	Material findByCodigo(long codigo);
	
}
