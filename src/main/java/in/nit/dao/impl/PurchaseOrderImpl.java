package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.PurchaseOrderDao;
import in.nit.model.PurchaseOrder;

@Repository
public class PurchaseOrderImpl implements PurchaseOrderDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer savePurchaseOrder(PurchaseOrder po) {

	return (Integer) ht.save(po);
	}
	
	@Override
	public List<PurchaseOrder> getAllPurchaseOrder() {

		return ht.loadAll(PurchaseOrder.class);
	}

	@Override
	public void deletePurchaseOrder(Integer id) {
		ht.delete(new PurchaseOrder(id));

	}

	/*
	 * @Override public PurchaseOrder getOnePurchaseOrder(Integer id) {
	 * 
	 * return ht.get(PurchaseOrder.class,id); }
	 * 
	 * @Override public void updatePurchaseOrder(PurchaseOrder pb) { ht.update(pb);
	 * 
	 * }
	 */

}
