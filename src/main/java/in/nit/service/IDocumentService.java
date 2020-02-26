package in.nit.service;

import java.util.List;

import in.nit.model.Document;

public interface IDocumentService {
	public Integer saveDocument(Document doc);
	public List<Object[]> getFieldAndNames();
	public Document getOneDocument(Integer id);
}
