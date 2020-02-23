package in.nit.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="omtab")
public class OrderMethod {
	@Id
	@GeneratedValue(generator="oid")
	@GenericGenerator(name="oid", strategy="increment")
	@Column(name="oid")
    private Integer orderId;
	@Column(name="mode")
	private String orderMode;
	@Column(name="code")
	private String OrderCode;
	@Column(name="otype")
	private String orderType;
	
	//for list type of variable
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="oacttab",joinColumns=@JoinColumn(name="oid"))
	@Column(name="oacpt")
	private List<String> orderAccept;
	@Column(name="omdsc")
	private String description;
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrderMode() {
		return orderMode;
	}
	public void setOrderMode(String orderMode) {
		this.orderMode = orderMode;
	}
	public String getOrderCode() {
		return OrderCode;
	}
	public void setOrderCode(String orderCode) {
		OrderCode = orderCode;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public List<String> getOrderAccept() {
		return orderAccept;
	}
	public void setOrderAccept(List<String> orderAccept) {
		this.orderAccept = orderAccept;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
