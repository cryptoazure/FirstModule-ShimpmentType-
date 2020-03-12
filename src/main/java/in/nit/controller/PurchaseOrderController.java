package in.nit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.nit.model.PurchaseOrder;
import in.nit.service.IShipmentTypeService;
import in.nit.service.PurchaseOrderService;
import in.nit.util.commonUtil;

@Controller
@RequestMapping("/po")
public class PurchaseOrderController {

	@Autowired
	private PurchaseOrderService service;
	@Autowired
	private IShipmentTypeService shipTypeService;
	
	
	
	private void commonUi(Model model) {
		List<Object[]> shipList=shipTypeService.getShipIdAndShipCode();
		Map<Integer,String> shipMap=commonUtil.convert(shipList);
		model.addAttribute("shipMap",shipMap);
	}
	
	@RequestMapping("/register")
	public String showRegPage(Model model) {
		//FORM BACKING OBJECT
		model.addAttribute("purchaseOrder", new PurchaseOrder());
		commonUi(model);
		return "PurchaseOrderRegister";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savePurchaseOrder(@ModelAttribute PurchaseOrder purchaseOrder, Model model) {
		Integer poList = service.savePurchaseOrder(purchaseOrder);
		String message = "PurchaseOrder'" + poList + "'+saved...";
		model.addAttribute("message", message);
		//FORM BACKING OBJECT
				model.addAttribute("purchaseOrder", new PurchaseOrder());
				commonUi(model);
				return "PurchaseOrderRegister";
	}

	@RequestMapping("/all")
	public String getAllPurchaseOrder(Model model) {
		List<PurchaseOrder> list = service.getAllPurchaseOrder();
		model.addAttribute("list", list);
		return "PurchaseOrderData";
	}

	@RequestMapping("/delete")
	public String deletePurchaseOrder(@RequestParam("pid") Integer pid, Model model) {
		service.deletePurchaseOrder(pid);
		String message = "PurchaseOrder  '" +pid + "'   deleted";
		model.addAttribute("message", message);

		// fetch new data
		List<PurchaseOrder> list = service.getAllPurchaseOrder();
		model.addAttribute("list", list);
		return "PurchaseOrderData";

	}

	/*
	 * @RequestMapping("/edit") public String showEditPage(
	 * 
	 * @RequestParam("ppoId") Integer poId, Model model) { PurchaseOrder st =
	 * service.getOnePurchaseOrder(poId); model.addAttribute("PurchaseOrder", st);
	 * return "PurchaseOrderEdit"; }
	 * 
	 * @RequestMapping(value = "/update", method = RequestMethod.POST) public String
	 * updatePurchaseOrder(@ModelAttribute PurchaseOrder PurchaseOrder, Model model)
	 * { service.updatePurchaseOrder(PurchaseOrder); String msg = "PurchaseOrder '"
	 * + PurchaseOrder.getOrderCode() + "' updated"; model.addAttribute("list",
	 * msg); return "PurchaseOrderEdit"; }
	 * 
	 *//**
		 * view method
		 *//*
			 * @RequestMapping("/view") public String showOnePurchaseOrder(
			 * 
			 * @RequestParam("ppoId") Integer poId, Model model) { PurchaseOrder st =
			 * service.getOnePurchaseOrder(poId); model.addAttribute("pb", st); return
			 * "PurchaseOrderView";
			 * 
			 * }
			 */
}
