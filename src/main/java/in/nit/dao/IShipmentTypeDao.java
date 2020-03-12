package in.nit.dao;

import java.util.List;

import in.nit.model.ShipmentType;

public interface IShipmentTypeDao {
	Integer saveShipmentType(ShipmentType ob);
	List<ShipmentType> getAllShipmentType();
	public void deleteShipmentType(Integer id);
	ShipmentType getOneShipmentType(Integer id);
	public void updateShipmentType(ShipmentType ob);
	//to get charts and Bars
	public List<Object[]> getShipmentModeCount();
	
	public List<Object[]> getShipIdAndShipCode();
	
	
}
