package in.nit.service;

import java.util.List;

import in.nit.model.ShipmentType;
import in.nit.model.Uom;

public interface IUomTypeService {
	Integer saveUom(Uom um);
	List<Uom> getAllUom();
   public void deleteUomType(Integer ide);
   
   public Uom getUomType(Integer id);
   public void updateUomType(Uom ob);

   
}
	