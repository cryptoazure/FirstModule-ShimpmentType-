package in.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.PurchaseOrderDao;
import in.nit.model.PurchaseOrder;
import in.nit.service.PurchaseOrderService;
@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
  @Autowired
	private PurchaseOrderDao dao;
	@Override
	@Transactional
	public Integer savePurchaseOrder(PurchaseOrder po) {
		return dao.savePurchaseOrder(po);
		}


	@Transactional
	public void deletePurchaseOrder(Integer id) {
		dao.deletePurchaseOrder(id);

	}
	
	 @Transactional(readOnly=true) 
	 public List<PurchaseOrder> getAllPurchaseOrder() {
	  
	  List<PurchaseOrder> list=dao.getAllPurchaseOrder();
	  Collections.sort(list,(o1,o2)->o1.getOrderCode()-o2.getOrderCode());
	  return list; 
	  }
	 

	
	  
	/*
	 * @Transactional public PurchaseOrder getOnePurchaseOrder(Integer id) {
	 * 
	 * return dao.getOnePurchaseOrder(id); }
	 * 
	 * @Transactional public void updatePurchaseOrder(PurchaseOrder pb) {
	 * dao.updatePurchaseOrder(pb);
	 * 
	 * }
	 */
	 

}
