package in.nit.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="whtab")
public class WhUserType {
	@Id
	@GeneratedValue
	private Integer whId;
	private String useType;
	private String useCode;
	private String useFor;
	private String useMail;
	private String useCont;
	private String useId;
	private String ifOther;
	private String idNum;
	public WhUserType() {
		super();
	}
	@Override
	public String toString() {
		return "WHUserType [whId=" + whId + ", useType=" + useType + ", useCode=" + useCode + ", useFor=" + useFor
				+ ", useMail=" + useMail + ", useCont=" + useCont + ", useId=" + useId + ", ifOther=" + ifOther
				+ ", idNum=" + idNum + "]";
	}
	public Integer getWhId() {
		return whId;
	}
	public void setWhId(Integer whId) {
		this.whId = whId;
	}
	public String getUseType() {
		return useType;
	}
	public void setUseType(String useType) {
		this.useType = useType;
	}
	public String getUseCode() {
		return useCode;
	}
	public void setUseCode(String useCode) {
		this.useCode = useCode;
	}
	public String getUseFor() {
		return useFor;
	}
	public void setUseFor(String useFor) {
		this.useFor = useFor;
	}
	public String getUseMail() {
		return useMail;
	}
	public void setUseMail(String useMail) {
		this.useMail = useMail;
	}
	public String getUseCont() {
		return useCont;
	}
	public void setUseCont(String useCont) {
		this.useCont = useCont;
	}
	public String getUseId() {
		return useId;
	}
	public void setUseId(String useId) {
		this.useId = useId;
	}
	public String getIfOther() {
		return ifOther;
	}
	public void setIfOther(String ifOther) {
		this.ifOther = ifOther;
	}
	public String getIdNum() {
		return idNum;
	}
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	
}
