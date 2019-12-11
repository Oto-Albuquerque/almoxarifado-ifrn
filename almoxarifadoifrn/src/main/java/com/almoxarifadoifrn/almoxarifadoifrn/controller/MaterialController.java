package com.almoxarifadoifrn.almoxarifadoifrn.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.almoxarifadoifrn.almoxarifadoifrn.models.Material;
import com.almoxarifadoifrn.almoxarifadoifrn.repository.MaterialRepository;

@Controller
public class MaterialController {
	@Autowired
	private MaterialRepository mr;

	@RequestMapping(value="/cadastromaterial", method=RequestMethod.GET)
	public String material(){
		return "Material/formMaterial";
	}
	
	@RequestMapping(value="/cadastromaterial", method=RequestMethod.POST)
	public String material(@Valid Material material, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastromaterial";
		}
	
		mr.save(material);
		attributes.addFlashAttribute("mensagem", "Material cadastrado com sucesso!");
		return "redirect:/cadastromaterial";
	}
	@RequestMapping("/listamaterialADM")
	public ModelAndView listamaterialADM() {
		ModelAndView nv = new ModelAndView("Material/listarMaterial");
		Iterable<Material> listamaterial = mr.findAll();
		nv.addObject("material", listamaterial);
		return nv;
	}
	@RequestMapping("/listamaterial*")
	public ModelAndView listamaterialSER() {
		ModelAndView nv = new ModelAndView("Material/listarMaterialSER");
		Iterable<Material> listamaterial = mr.findAll();
		nv.addObject("material", listamaterial);
		return nv;
	}
	
	@RequestMapping("/listamaterial")
	public ModelAndView listamaterial() {
		ModelAndView nv = new ModelAndView("Material/listarMaterialPUB");
		Iterable<Material> listamaterial = mr.findAll();
		nv.addObject("material", listamaterial);
		return nv;
	}
	
	@RequestMapping("/deletarmaterial")
	public String deletarMaterial(long codigo){
		Material material = mr.findByCodigo(codigo);
		mr.delete(material);
		return "redirect:/listamaterialADM";
	}
}
