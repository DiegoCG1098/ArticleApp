package com.hampcode.articlesapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hampcode.articlesapp.common.PageInitPagination;
import com.hampcode.articlesapp.service.SupplierService;

@Controller
@RequestMapping({ "/", "/home" })

public class HomeController {

	@Autowired
	private SupplierService supplierService;

	@Autowired
	private PageInitPagination pageInitPagination;

	protected static final String INDEX_VIEW = "index"; 

	protected static final String SUPPLIER_VIEW = "suppliers/showSupplier"; // view template for single article

	
	@GetMapping
	public ModelAndView getIndex() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("articlesList", supplierService.getAll());
		modelAndView.setViewName(INDEX_VIEW);

		return modelAndView;
	}
	
	
	@GetMapping("/{id}")
	public String getSupplierById(@PathVariable(value = "id") Long supplierId, Model model) {
		model.addAttribute("supplier", supplierService.findById(supplierId));
		return SUPPLIER_VIEW;
	}
	
	
	

}
