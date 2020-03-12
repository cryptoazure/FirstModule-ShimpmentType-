package in.nit.dao;

import java.util.List;

import in.nit.model.Uom;

public interface IUomTypeDao {
	Integer saveUom(Uom um);
	List<Uom> getAllUom();
	public void deleteUomType(Integer ide);
	
	Uom getOneUom(Integer id);
	void updateUomType(Uom ob);
	public List<Object[]> getUomTypeCount();
	public List<Object[]> getUomIdAndUomModel();
}
