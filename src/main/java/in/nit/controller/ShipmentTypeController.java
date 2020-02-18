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
import in.nit.service.IShipmentTypeService;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {

	@Autowired
	private IShipmentTypeService service;

	/**
	 * shipment/register this method is used to display ShipmentType register page
	 * on URL:/register,GET
	 * shipment/register
	 * shipment/reguom
	 */

	/** 1.ShipmentTypeModule
	 * Method Format:- public String <anyMethodName>(){ return "PageName"; }
	 */

	@RequestMapping("/register")
	public String showRegPage(Model model) {
		//FORM BACKING OBJECT
		model.addAttribute("shipmentType",new ShipmentType());
		return "ShipmentTypeRegister";
	}
	/*
	 * save operation for ShipmentType module
	 */

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveShipmentType(@ModelAttribute ShipmentType shipmentType, Model model) {
		Integer id = service.saveShipmentType(shipmentType);
		String message = "ShipmentType '"+ id+ "'+saved...";
		model.addAttribute("msg", message);
		//FORM BACKING OBJECT
		model.addAttribute("shipmentType",new ShipmentType());

		return "ShipmentTypeRegister";
	}
	/*
	 * to fetch data from datbase
	 */
	@RequestMapping("/all")
	public String getAllShipmentType(Model model) {
		List<ShipmentType> list=service.getAllShipmentType();
		model.addAttribute("list",list);
				return "ShipmentTypeData";
	}
	/**
	 * delete operation for shipment Module
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/delete")
	public String deleteShipmentType(
									@RequestParam("sid")Integer id,
									Model model
									) {
		service.deleteShipmentType(id);
		String message="ShipmentType  '"+id+"'   deleted";
		model.addAttribute("message",message);
		
		//fetch new data
		List<ShipmentType> list=service.getAllShipmentType();
		model.addAttribute("list",list);
		return "ShipmentTypeData";
		
	}
	/**
	 * to get the edit page based on given id
	 * url:/edit
	 * 
	 */
	@RequestMapping("/edit")
	public String showEditPage(
								@RequestParam("sid")Integer id,
								Model model
			) {
		ShipmentType st=service.getOneShipmentType(id);
		model.addAttribute("shipmentType",st);
		return "ShipmentTypeEdit";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateShipmentType(@ModelAttribute ShipmentType shipmentType,
									Model model
			) {
		String msg="ShipmentType    '"+shipmentType.getShipId()+"' updated";
		model.addAttribute("list",msg);
		service.updateShipmentType(shipmentType);
		return "ShipmentTypeEdit";
	}
	
	
	
	/***
	 * Operation for Uom Type Module
	 * @return
	 */
	
	@RequestMapping("/reguom")
	public String showUomTypePage() {
		return "UomType";
	}
   
	/*
	 * save operation for Uom module
	 */
    @RequestMapping(value = "/saveuom", method = RequestMethod.POST)
	public String saveUom(@ModelAttribute Uom uom, 
							Model model) {
		Integer id = service.saveUom(uom);
		String message = "UomTyp  '"+ id+ "'     +saved...";
		model.addAttribute("uom", message);

		return "UomType";
	}
	/**
	 *  to get data from database for Uom module
	 * @param model
	 * @return
	 */
    @RequestMapping("/alluom")
	public String getAllUomType(Model model) {
		List<Uom> list=service.getAllUom();
		model.addAttribute("list",list);
				return "UomTypeData";
	}
    /*
     * Delete Operauon for Uom module
     * 
    
    */ 
	@RequestMapping("/alldelete")
	public String deleteUomType(
								@RequestParam("uid")Integer ide,
									Model model
									) {
		service.deleteUomType(ide);
		String message="UomType  '"+ide+"'   deleted";
		model.addAttribute("message",message);
		
		//fetch new data
		List<Uom> list=service.getAllUom();
		model.addAttribute("list",list);
				return "UomTypeData";
				}
	

    
}
