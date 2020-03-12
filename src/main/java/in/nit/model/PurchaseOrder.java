package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class PurchaseOrder {
	@Id
	@GeneratedValue
	@Column(name="pid")
	private Integer poId;
	private Integer orderCode;
	private String refNum;
	private String qtyCheck;
	private String status;
	private String note;
	
	
	@ManyToOne
	@JoinColumn(name="sidFk")
	private ShipmentType ship;


	@Override
	public String toString() {
		return "PurchaseOrder [poId=" + poId + ", orderCode=" + orderCode + ", refNum=" + refNum + ", qtyCheck="
				+ qtyCheck + ", status=" + status + ", note=" + note + ", ship=" + ship + "]";
	}


	public Integer getPoId() {
		return poId;
	}


	public void setPoId(Integer poId) {
		this.poId = poId;
	}


	public Integer getOrderCode() {
		return orderCode;
	}


	public void setOrderCode(Integer orderCode) {
		this.orderCode = orderCode;
	}


	public String getRefNum() {
		return refNum;
	}


	public void setRefNum(String refNum) {
		this.refNum = refNum;
	}


	public String getQtyCheck() {
		return qtyCheck;
	}


	public void setQtyCheck(String qtyCheck) {
		this.qtyCheck = qtyCheck;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public ShipmentType getShip() {
		return ship;
	}


	public void setShip(ShipmentType ship) {
		this.ship = ship;
	}


	public PurchaseOrder() {
		super();
	}


	public PurchaseOrder(Integer poId) {
		super();
		this.poId = poId;
	}


	
	
}
