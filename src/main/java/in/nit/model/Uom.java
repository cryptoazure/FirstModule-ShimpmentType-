package in.nit.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="uomtab")
public class Uom {
	
	
	@Id
	@GeneratedValue
	@Column(name="uid")
	private Integer uomId;
	
	@Column(name="utype")
	private String uomType;
	
	@Column(name="umod")
	private String uomMod;
	
	@Column(name="udesc")
	private String uomDesc;
	
	
	public Integer getUomId() {
		return uomId;
	}
	public void setUomId(Integer uomId) {
		this.uomId = uomId;
	}
	public String getUomType() {
		return uomType;
	}
	public void setUomType(String uomType) {
		this.uomType = uomType;
	}
	public String getUomMod() {
		return uomMod;
	}
	public void setUomMod(String uomMod) {
		this.uomMod = uomMod;
	}
	public String getUomDesc() {
		return uomDesc;
	}
	public void setUomDesc(String uomDesc) {
		this.uomDesc = uomDesc;
	}
	@Override
	public String toString() {
		return "Uom [uomId=" + uomId + ", uomType=" + uomType + ", uomMod=" + uomMod + ", uomDesc=" + uomDesc + "]";
	}
	public Uom() {
		super();
	}
	
	
}
