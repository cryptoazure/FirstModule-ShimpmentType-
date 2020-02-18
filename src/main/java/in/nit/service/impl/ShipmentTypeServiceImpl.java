package in.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IShipmentTypeDao;
import in.nit.model.ShipmentType;
import in.nit.model.Uom;
import in.nit.service.IShipmentTypeService;
@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {

	@Autowired
	private IShipmentTypeDao dao;


	@Transactional
	public Integer saveShipmentType(ShipmentType ob) {
		return dao.saveShipmentType(ob);

	}

	@Transactional(readOnly=true)
	public List<ShipmentType> getAllShipmentType() {

		List<ShipmentType> list=dao.getAllShipmentType();
		Collections.sort(list,(o1,o2)->o1.getShipId()-o2.getShipId());
		return list;
	}
	@Transactional
	public void deleteShipmentType(Integer id) {
		dao.deleteShipmentType(id);

	}

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



	@Transactional public void deleteUomType(Integer ide) {
		dao.deleteUomType(ide);

	}

	@Transactional
	public ShipmentType getOneShipmentType(Integer id) {

		return dao.getOneShipmentType(id);
	}

	@Transactional	
	public void updateShipmentType(ShipmentType ob) {
		dao.updateShipmentType(ob);
		
	}




}
