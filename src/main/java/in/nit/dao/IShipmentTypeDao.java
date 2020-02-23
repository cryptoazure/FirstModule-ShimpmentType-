package in.nit.dao;

import java.util.List;

import in.nit.model.ShipmentType;
import in.nit.model.Uom;

public interface IShipmentTypeDao {
	Integer saveShipmentType(ShipmentType ob);
	List<ShipmentType> getAllShipmentType();
	public void deleteShipmentType(Integer id);
	ShipmentType getOneShipmentType(Integer id);
	public void updateShipmentType(ShipmentType ob);
	
	
	
}
