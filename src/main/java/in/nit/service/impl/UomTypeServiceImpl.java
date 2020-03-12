package in.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IUomTypeDao;
import in.nit.model.Uom;
import in.nit.service.IUomTypeService;
@Service
public class UomTypeServiceImpl implements IUomTypeService {

	@Autowired
	private IUomTypeDao dao;
	@Transactional 
	public Integer saveUom(Uom um) {

		return dao.saveUom(um);
	}


	@Transactional(readOnly=true)
	public List<Uom> getAllUom() { 
		List<Uom> list=dao.getAllUom(); //
		Collections.sort(list,(o1,o2)->o1.getUomId()-o2.getUomId());
		return list;
	}



	@Transactional 
	public void deleteUomType(Integer ide) {
		dao.deleteUomType(ide);

	}

	@Transactional(readOnly=true)
	public Uom getOneUom(Integer id) {	

		return dao.getOneUom(id);

	}


	@Transactional
	public void updateUomType(Uom ob) {
		dao.updateUomType(ob);

	}

	
	@Transactional(readOnly = true)
	public List<Object[]> getUomTypeCount() {
		return dao.getUomTypeCount();
	}

	@Transactional(readOnly=true)
	public List<Object[]> getUomIdAndUomModel() {
		
		return dao.getUomIdAndUomModel();
	}

}
