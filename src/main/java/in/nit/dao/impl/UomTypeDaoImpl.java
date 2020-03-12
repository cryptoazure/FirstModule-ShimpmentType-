package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IUomTypeDao;
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
		ht.delete(new Uom());	
	}
	
	@Override
	public Uom getOneUom(Integer id) {

		return ht.get(Uom.class,id);
	}



	public void updateUomType(Uom ob) {
     ht.update(ob);
		
	}

	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getUomTypeCount() {
		String hql = "select uomType,count(uomType) from in.nit.model.Uom group by uomType";
		
		return (List<Object[]>) ht.find(hql);

	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Object[]> getUomIdAndUomModel() {
		String hql=" select  uomId , uomMod from in.nit.model.Uom";
		@SuppressWarnings({ "unchecked", "unused" })
		List<Object[]> list=(List<Object[]>) ht.find(hql);
		return list;
	}

}