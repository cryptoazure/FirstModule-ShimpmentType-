package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IShipmentTypeDao;
import in.nit.model.ShipmentType;
import in.nit.model.Uom;

@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveShipmentType(ShipmentType ob) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(ob);
	}

	@Override
	public List<ShipmentType> getAllShipmentType() {

		return ht.loadAll(ShipmentType.class);
	}

	@Override
	public void deleteShipmentType(Integer id) {
		ht.delete(new ShipmentType(id));

	}

	@Override
	public ShipmentType getOneShipmentType(Integer id) {
		
		return ht.get(ShipmentType.class,id);
	}

	@Override
	public void updateShipmentType(ShipmentType ob) {
		ht.update(ob);
		
	}
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getShipmentModeCount() {
		String hql="select shipMode,count(shipMode) from in.nit.model.ShipmentType group by shipMode";
		return (List<Object[]>) ht.find(hql);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Object[]> getShipIdAndShipCode() {
		String hql=" select shipId,shipCode from " + ShipmentType.class.getName() +" where enbShip='YES' ";
		return (List<Object[]>) ht.find(hql);
	}
	
	 	

	

}
