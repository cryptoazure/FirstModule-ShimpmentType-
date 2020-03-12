package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IOrderMethodDao;
import in.nit.model.OrderMethod;
@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao{
	
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveOrderMethod(OrderMethod ob) {
	
		return (Integer) ht.save(ob);
	}
	
	@SuppressWarnings("unchecked")

	@Override
	public List<Object[]> getOrderIdAndOrderCode(String mode) {

		String hql = " select orderId,orderCode from in.nit.model.OrderMethod where OrderMod==?0  ";

		@SuppressWarnings("deprecation")
		List<Object[]> list = (List<Object[]>) ht.find(hql);
		return list;
	}

}
