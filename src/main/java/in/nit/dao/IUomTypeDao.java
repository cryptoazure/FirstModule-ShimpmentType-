package in.nit.dao;

import java.util.List;

import in.nit.model.Uom;

public interface IUomTypeDao {
	Integer saveUom(Uom um);
	List<Uom> getAllUom();
	public void deleteUomType(Integer ide);
	
	Uom getUomType(Integer id);
	void updateUomType(Uom ob);

}
