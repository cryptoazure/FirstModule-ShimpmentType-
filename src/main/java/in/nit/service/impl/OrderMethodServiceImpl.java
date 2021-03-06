package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IOrderMethodDao;
import in.nit.model.OrderMethod;
import in.nit.service.IOrderMethodService;
@Service
public class OrderMethodServiceImpl implements IOrderMethodService {
	@Autowired
	private IOrderMethodDao dao;

	@Transactional
	public Integer saveOrderMethod(OrderMethod ob) {
		
		return dao.saveOrderMethod(ob);
	}
	
	
	@Transactional(readOnly = true)
	public List<Object[]> getOrderIdAndOrderCode(String type) {
		return dao.getOrderIdAndOrderCode("Sale");
	}
	 
}
