package in.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.nit.model.ShipmentType;
import in.nit.model.Uom;
import in.nit.service.IUomTypeService;

@Controller
@RequestMapping("/uom")
public class UomTypeController {
	@Autowired
	private IUomTypeService service;

	/***
	 * Operation for Uom Type Module
	 * 
	 * @return
	 */

	@RequestMapping("/register")
	public String showUomTypePage() {
		return "UomTypeRegister";
	}

	/*
	 * save operation for Uom module
	 */
	@RequestMapping(value = "/saveuom", method = RequestMethod.POST)
	public String saveUom(@ModelAttribute Uom uom, Model model) {
		Integer id = service.saveUom(uom);
		String message = "UomType  '" + id + "'     +saved...";
		model.addAttribute("uom", message);

		return "UomTypeRegister";
	}

	/**
	 * to get data from database for Uom module
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/all")
	public String getAllUomType(Model model) {
		List<Uom> list = service.getAllUom();
		model.addAttribute("list", list);
		return "UomTypeData";
	}

	/*
	 * Delete Operauon for Uom module
	 * 
	 * 
	 */
	@RequestMapping("/delete")
	public String deleteUomType(@RequestParam("uid") Integer ide, Model model) {
		service.deleteUomType(ide);
		String message = "UomType  '" + ide + "'   deleted";
		model.addAttribute("message", message);

		// fetch new data
		List<Uom> list = service.getAllUom();
		model.addAttribute("list", list);
		return "UomTypeData";
	}
	
	  @RequestMapping("/edit") 
	  public String editUomType(
			  				   @RequestParam("sid")Integer id,
			  				   Model model ) {
		  Uom uid=service.getUomType(id); 
		  model.addAttribute("uom",uid); 
		  return "UomTypeEdit";
	  
	  }
	  @RequestMapping(value="/update" ,method=RequestMethod.POST)
	  public String updateUomType(
			  					  @ModelAttribute Uom uom,Model model
			  ) {
		  String msg="UomType   '"+uom.getUomId()+"' +updated";
		  model.addAttribute("list",msg);
		  service.updateUomType(uom);
		  return "UomTypeEdit";
	  }
	  

	}
