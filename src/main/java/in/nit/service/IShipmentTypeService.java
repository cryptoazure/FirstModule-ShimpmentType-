package in.nit.service;

import java.util.List;

import in.nit.model.ShipmentType;
import in.nit.model.Uom;

public interface IShipmentTypeService {
	Integer saveShipmentType(ShipmentType ob);
	List<ShipmentType> getAllShipmentType();
	public void deleteShipmentType(Integer id);
	
	public ShipmentType getOneShipmentType(Integer id);
	public void updateShipmentType(ShipmentType ob);
	
	

}
	