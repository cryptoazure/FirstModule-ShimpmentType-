package in.nit.service;

import java.util.List;

import in.nit.model.Uom;

public interface IUomTypeService {
	Integer saveUom(Uom um);
	List<Uom> getAllUom();
	public void deleteUomType(Integer ide);

	Uom getOneUom(Integer id);
	public void updateUomType(Uom ob);
	public List<Object[]> getUomTypeCount();
	public List<Object[]> getUomIdAndUomModel();
}
