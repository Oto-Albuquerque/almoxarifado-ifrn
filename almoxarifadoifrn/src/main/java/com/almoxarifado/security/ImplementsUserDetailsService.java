package com.almoxarifado.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.almoxarifadoifrn.almoxarifadoifrn.models.Adm;
import com.almoxarifadoifrn.almoxarifadoifrn.repository.AdmRepository;

@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService{

	@Autowired
	private AdmRepository ar;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Adm adm = ar.findByLogin(login);
		
		if(adm == null) {
			throw new UsernameNotFoundException("Administrador não encontrado!");
		}
		return adm;
	} 

}

