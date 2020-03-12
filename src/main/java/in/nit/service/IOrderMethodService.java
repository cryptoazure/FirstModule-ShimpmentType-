package in.nit.service;

import java.util.List;

import in.nit.model.OrderMethod;

public interface IOrderMethodService {
	Integer saveOrderMethod(OrderMethod ob);
	public List<Object[]> getOrderIdAndOrderCode(String mode);

}
