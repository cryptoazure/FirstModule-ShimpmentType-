package in.nit.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
@Entity
@Table(name="partab")
public class Part {


	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;

	@Column(name="pcode")
	private String partCode;
	@Column(name="pline")
	private Double partLine;
	@Column(name="pwdth")
	private  Double  partWid;
	@Column(name="phght")
	private  Double  partHgt;
	@Column(name="bcost")
	private Double baseCost;

	@Column(name="bcurncy")
	private String baseCurrency;
	@Column(name="note")
	private String desc;

	@ManyToOne
	@JoinColumn(name="uomFk")
	private Uom uomdb;

	@Override
	public String toString() {
		return "Part [id=" + id + ", partCode=" + partCode + ", partLine=" + partLine + ", partWid=" + partWid
				+ ", partHgt=" + partHgt + ", baseCost=" + baseCost + ", baseCurrency=" + baseCurrency + ", desc="
				+ desc + ", uomdb=" + uomdb + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPartCode() {
		return partCode;
	}

	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}

	public Double getPartLine() {
		return partLine;
	}

	public void setPartLine(Double partLine) {
		this.partLine = partLine;
	}

	public Double getPartWid() {
		return partWid;
	}

	public void setPartWid(Double partWid) {
		this.partWid = partWid;
	}

	public Double getPartHgt() {
		return partHgt;
	}

	public void setPartHgt(Double partHgt) {
		this.partHgt = partHgt;
	}

	public Double getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(Double baseCost) {
		this.baseCost = baseCost;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Uom getUomdb() {
		return uomdb;
	}

	public void setUomdb(Uom uomdb) {
		this.uomdb = uomdb;
	}

	public Part() {
		super();
	}

	public Part(Integer id) {
		super();
		this.id = id;
	}

}
