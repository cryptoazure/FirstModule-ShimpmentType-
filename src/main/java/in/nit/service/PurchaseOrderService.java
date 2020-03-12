package in.nit.service;

import java.util.List;

import in.nit.model.PurchaseOrder;

public interface PurchaseOrderService {

		public Integer savePurchaseOrder(PurchaseOrder po);
		List<PurchaseOrder> getAllPurchaseOrder();
		public void deletePurchaseOrder(Integer id);
		
	/*
	 * public PurchaseOrder getOnePurchaseOrder(Integer id); public void
	 * updatePurchaseOrder(PurchaseOrder ob);
	 */
}
