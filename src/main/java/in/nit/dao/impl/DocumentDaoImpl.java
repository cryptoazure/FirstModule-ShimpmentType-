package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IDocumentDao;
import in.nit.model.Document;
@Repository
public class DocumentDaoImpl implements IDocumentDao {

	@Autowired
	private HibernateTemplate ht;
	
	public Integer saveDocument(Document doc) {
		
		return (Integer) ht.save(doc);
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Object[]> getFieldAndNames() {
		String hql="select fileId,fileName from in.nit.model.Document";
		return ( List<Object[]> )ht.find(hql);
	}

	public Document getOneDocument(Integer id) {
		return ht.get(Document.class,id);
	}

}
