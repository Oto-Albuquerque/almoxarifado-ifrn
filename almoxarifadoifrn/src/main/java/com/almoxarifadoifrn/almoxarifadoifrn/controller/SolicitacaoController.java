package com.almoxarifadoifrn.almoxarifadoifrn.controller;

import java.util.Calendar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.almoxarifadoifrn.almoxarifadoifrn.models.Material;

import com.almoxarifadoifrn.almoxarifadoifrn.models.Solicitacao;
import com.almoxarifadoifrn.almoxarifadoifrn.models.Usuario;
import com.almoxarifadoifrn.almoxarifadoifrn.repository.MaterialRepository;

import com.almoxarifadoifrn.almoxarifadoifrn.repository.SolicitacaoRepository;
import com.almoxarifadoifrn.almoxarifadoifrn.repository.UsuarioRepository;

public class SolicitacaoController {
	@Autowired
	private UsuarioRepository ur;
	@Autowired
	private MaterialRepository mr;
	@Autowired
	private SolicitacaoRepository sor;

	@RequestMapping(value="/solicitarmaterial", method = RequestMethod.GET)
	public ModelAndView Solicitacao() {ModelAndView nv = new ModelAndView("Solicitacao/formSolicitacao");
		Iterable<Material> material = mr.findAll(); Iterable<Usuario> usuario = ur.findAll();
		nv.addObject("usuario", usuario); nv.addObject("material", material);
		return nv;}
	
	@RequestMapping(value="/solicitarmaterial", method = RequestMethod.POST)
	public String Solicitacao(@Valid Solicitacao solicitacao, BindingResult result, RedirectAttributes attributes){solicitacao.setDataSolicitação(Calendar.getInstance());
		if(result.hasErrors() ) {attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/solicitarmaterial";}
		sor.save(solicitacao);
		attributes.addFlashAttribute("mensagem", "Solicitação cadastrada com sucesso!");
		return "redirect:/solicitarmaterial";}
	
	@RequestMapping("/listasolicitacao")
	public ModelAndView listaSolicitacao() {ModelAndView nv = new ModelAndView("Solicitacao/listarSolicitacao");
		Iterable<Solicitacao> listasolicitacao = sor.findAll();
		nv.addObject("solicitacao", listasolicitacao);
		return nv;}
	
	@RequestMapping("/deferirsolicitacao")
	public String deferirSolicitacao(long codigo){Solicitacao solicitacao = sor.findByCodigo(codigo);
		solicitacao.setDataDeferimento(Calendar.getInstance());
		sor.save(solicitacao);
		return "redirect:/listasolicitacao";}}