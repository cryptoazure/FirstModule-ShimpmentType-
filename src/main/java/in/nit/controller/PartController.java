package in.nit.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.Part;
import in.nit.service.IOrderMethodService;
import in.nit.service.IPartService;
import in.nit.service.IUomTypeService;
import in.nit.util.PartUtil;
import in.nit.util.commonUtil;
import in.nit.view.PartExcelView;
import in.nit.view.PartPdfView;

@Controller
@RequestMapping("/part")
public class PartController {

	@Autowired
	private IPartService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private PartUtil util;
	@Autowired
	private IUomTypeService uomService;

	public void commonUi(Model model) {
	List<Object[]> uomList=	uomService.getUomIdAndUomModel();
	Map<Integer,String> uomMap=commonUtil.convert(uomList);
	model.addAttribute("uomMap", uomMap);
		
	}
	
	@RequestMapping("/register")
	public String showRegPage(Model model) {
		// FORM BACKING OBJECT
		model.addAttribute("part", new Part());
		commonUi(model);
		return "PartRegister";
	}
	/*
	 * save operation for Part module
	 */

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savePart(
						   @ModelAttribute Part part,
						   Model model) {
		Integer id = service.savePart(part);
		model.addAttribute("message","Part created:"+id);
		// FORM BACKING OBJECT
		model.addAttribute("part", new Part());
		commonUi(model);
		return "PartRegister";
	}

	/*
	 * to fetch data from database
	 */
	@RequestMapping("/all")
	public String getAllPart(Model model) {
		List<Part> list = service.getAllPart();
		model.addAttribute("list", list);
		return "PartData";
	}

	/**
	 * delete operation for shipment Module
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/delete")
	public String deletePart(@RequestParam("sid") Integer id, Model model) {
		service.deletePart(id);
		String message = "Part  '" + id + "'   deleted";
		model.addAttribute("message", message);

		// fetch new data
		List<Part> list = service.getAllPart();
		model.addAttribute("list", list);
		return "PartData";

	}

	/**
	 * to get the edit page based on given id url:/edit
	 * 
	 */
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("sid") Integer id, Model model) {
		Part st = service.getOnePart(id);
		model.addAttribute("Part", st);
		return "PartEdit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePart(@ModelAttribute Part part, Model model) {
		service.updatePart(part);
		String msg = "Part '" + part.getId() + "' updated";
		model.addAttribute("list", msg);
		return "PartEdit";
	}

	/**
	 * view method
	 */
	@RequestMapping("/view")
	public String showOnePart(@RequestParam("sid") Integer id, Model model) {
		Part st = service.getOnePart(id);
		model.addAttribute("ob", st);
		return "PartView";

	}

	/**
	 * Excel method method Type:GET,URL:/excel
	 * 
	 */
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		ModelAndView m = new ModelAndView();
		m.setView(new PartExcelView());
		// fetch from db
		List<Part> list = service.getAllPart();
		m.addObject("list", list);
		return m;

	}

	/**
	 * add method for PDF View
	 * 
	 */
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {
		ModelAndView m = new ModelAndView();
		m.setView(new PartPdfView());
		List<Part> list = service.getAllPart();
		m.addObject("list", list);
		return m;

	}

	@RequestMapping("/charts")
	public String showCharts() {
		List<Object[]> list = service.getPartModeCount();
		String path = context.getRealPath("/");
		util.generatePie(path, list);
		util.generateBar(path, list);
		return "PartCharts";
	}
}
