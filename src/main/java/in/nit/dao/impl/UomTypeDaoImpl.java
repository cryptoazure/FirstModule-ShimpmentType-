package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IUomTypeDao;
import in.nit.model.ShipmentType;
import in.nit.model.Uom;

@Repository
public class UomTypeDaoImpl implements IUomTypeDao {

	@Autowired
	private HibernateTemplate ht;


	@Override 
	public Integer saveUom(Uom um) {

		return (Integer) ht.save(um); }


	@Override
	public List<Uom> getAllUom() {
		// TODO Auto-generated method stub
		return ht.loadAll(Uom.class); 
	}



	@Override 
	public void deleteUomType(Integer ide) {
		ht.delete(new Uom(ide));	
	}
	
	@Override
	public Uom getUomType(Integer id) {

		return ht.get(Uom.class,id);
	}



	public void updateUomType(Uom ob) {
     ht.update(ob);
		
	}


}