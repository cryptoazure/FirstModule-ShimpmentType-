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

import in.nit.model.ShipmentType;
import in.nit.service.IShipmentTypeService;
import in.nit.util.ShipmentTypeUtil;
import in.nit.view.ShipmentTypeExcelView;
import in.nit.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {

	@Autowired
	private IShipmentTypeService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private ShipmentTypeUtil util;

	/**
	 * shipment/register this method is used to display ShipmentType register page
	 * on URL:/register,GETO shipment/register shipment/reguom
	 */

	/**
	 * 1.ShipmentTypeModule Method Format:- public String <anyMethodName>(){ return
	 * "PageName"; }
	 */

	@RequestMapping("/register")
	public String showRegPage(Model model) {
		// FORM BACKING OBJECT
		model.addAttribute("shipmentType", new ShipmentType());
		return "ShipmentTypeRegister";
	}
	/*
	 * save operation for ShipmentType module
	 */

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveShipmentType(@ModelAttribute ShipmentType shipmentType, Model model) {
		Integer id = service.saveShipmentType(shipmentType);
		String message = "ShipmentType '" + id + "'+saved...";
		model.addAttribute("msg", message);
		// FORM BACKING OBJECT
		model.addAttribute("shipmentType", new ShipmentType());

		return "ShipmentTypeRegister";
	}

	/*
	 * to fetch data from database
	 */
	@RequestMapping("/all")
	public String getAllShipmentType(Model model) {
		List<ShipmentType> list = service.getAllShipmentType();
		model.addAttribute("list", list);
		return "ShipmentTypeData";
	}

	/**
	 * delete operation for shipment Module
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/delete")
	public String deleteShipmentType(@RequestParam("sid") Integer id, Model model) {
		service.deleteShipmentType(id);
		String message = "ShipmentType  '" + id + "'   deleted";
		model.addAttribute("message", message);

		// fetch new data
		List<ShipmentType> list = service.getAllShipmentType();
		model.addAttribute("list", list);
		return "ShipmentTypeData";

	}

	/**
	 * to get the edit page based on given id url:/edit
	 * 
	 */
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("sid") Integer id, Model model) {
		ShipmentType st = service.getOneShipmentType(id);
		model.addAttribute("shipmentType", st);
		return "ShipmentTypeEdit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateShipmentType(@ModelAttribute ShipmentType shipmentType, Model model) {
		service.updateShipmentType(shipmentType);
		String msg = "ShipmentType '" + shipmentType.getShipId() + "' updated";
		model.addAttribute("list", msg);
		return "ShipmentTypeEdit";
	}

	/**
	 * view method
	 */
	@RequestMapping("/view")
	public String showOneShipmentType(@RequestParam("sid") Integer id, Model model) {
		ShipmentType st = service.getOneShipmentType(id);
		model.addAttribute("ob", st);
		return "ShipmentTypeView";

	}

	/**
	 * Excel method method Type:GET,URL:/excel
	 * 
	 */
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		ModelAndView m = new ModelAndView();
		m.setView(new ShipmentTypeExcelView());
		// fetch from db
		List<ShipmentType> list = service.getAllShipmentType();
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
		m.setView(new ShipmentTypePdfView());
		List<ShipmentType> list = service.getAllShipmentType();
		m.addObject("list", list);
		return m;

	}

	@RequestMapping("/charts")
	public String showCharts() {
		List<Object[]> list = service.getShipmentModeCount();
		String path = context.getRealPath("/");
		util.generatePie(path, list);
		util.generateBar(path, list);
		return "ShipmentTypeCharts";
	}
}
