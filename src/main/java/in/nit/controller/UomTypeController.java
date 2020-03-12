package in.nit.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.Uom;
import in.nit.service.IUomTypeService;
import in.nit.util.ShipmentTypeUtil;
import in.nit.view.UomTypeExcelView;

@Controller
@RequestMapping("/uom")
public class UomTypeController {
	@Autowired
	private IUomTypeService service;
	
	@Autowired
	private ServletContext context;
	@Autowired
	private ShipmentTypeUtil util;

	/***
	 * Operation for Uom Type Module
	 * 
	 * @return
	 */

	@RequestMapping("/register")
	public String showUomTypePage(Model model) {
		//form backing object
		model.addAttribute("uom",new Uom());
		return "UomTypeRegister";
	}

	/*
	 * save operation for Uom module
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUom(
						  @ModelAttribute Uom uom, 
						  Model model) {
		Integer id = service.saveUom(uom);
		String message = "UomType  '" + id + "'     +saved...";
		model.addAttribute("message", message);

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
							  @RequestParam("uid")Integer id,
							  Model model ) {
		Uom um=service.getOneUom(id); 
		model.addAttribute("uom", um);
		return "UomTypeEdit";

	}
	
	@RequestMapping(value="/update" ,method=RequestMethod.POST)
	public String updateUomType(
			                    @ModelAttribute Uom uom, 
								Model model
			) {
		service.updateUomType(uom);
		String msg="UomType'"+uom.getUomId()+"' +updated...";
		model.addAttribute("list",msg);

		return "UomTypeEdit";
	}
	/**
	 * view method
	 */
	@RequestMapping("/view")
	public String showOneUomType(
								@RequestParam("uid")Integer id, 
								Model model) {
		Uom uid=service.getOneUom(id); 
		model.addAttribute("uom",uid); 
		return "UomTypeView";

	}

	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		ModelAndView m = new ModelAndView();
		m.setView(new UomTypeExcelView());
		// fetch from db
		List<Uom> list = service.getAllUom();
		m.addObject("list", list);
		return m;

	}
	@RequestMapping("/charts")
	public String showCharts() {
		List<Object[]> list=service.getUomTypeCount();
		String path = context.getRealPath("/");
		util.generatePie(path, list);
		util.generateBar(path, list);
		return "UomTypeCharts";
	}

}
