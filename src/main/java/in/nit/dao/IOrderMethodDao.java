package in.nit.dao;

import java.util.List;

import in.nit.model.OrderMethod;

public interface IOrderMethodDao {
	Integer saveOrderMethod(OrderMethod ob);
    public List<Object[]> getOrderIdAndOrderCode(String mode);

}
