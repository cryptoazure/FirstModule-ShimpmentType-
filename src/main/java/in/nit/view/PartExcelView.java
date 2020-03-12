package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.model.Part;

public class PartExcelView  extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, 
			                          Object> model, 
			                          Workbook workbook, 
			                          HttpServletRequest request,
			                          HttpServletResponse response) throws Exception {
		//filename
		response.addHeader("Content-Disposition", "attachment:filename=shipment.xlsx");
		Sheet s=workbook.createSheet("Part Name");
		//construct-row-0
	     setHeader(s);
		//read model data
		@SuppressWarnings("unchecked")
		List<Part> list=(List<Part>)model.get("list");
		  setBody(s,list);
	}
	private void setHeader(Sheet s) {
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("PART CODE");
		r.createCell(1).setCellValue("PART LINE");
		r.createCell(2).setCellValue("PART WIDTH");
		r.createCell(3).setCellValue("PART HEIGHT");
		r.createCell(4).setCellValue("BASE COST");
		r.createCell(5).setCellValue("BASE CURRENCY");
		r.createCell(6).setCellValue("NOTE");
	
	}
	private void setBody(Sheet s,List<Part> list) {
		int count=0;
		for(Part st:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(st.getId());
			r.createCell(1).setCellValue(st.getPartCode());
			r.createCell(2).setCellValue(st.getPartLine());
			r.createCell(3).setCellValue(st.getPartWid());
			r.createCell(4).setCellValue(st.getBaseCost());
			r.createCell(5).setCellValue(st.getBaseCurrency());
			r.createCell(6).setCellValue(st.getBaseCurrency());
			
		}
	}

}
