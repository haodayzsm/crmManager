package top.haodayzsm.pojo;

import java.util.Date;

public class SupplierPayment implements java.io.Serializable{
	private Long supplierPayment_id;
	private Date date;
	private Integer money;
	private String supplier;
	private Long supplier_id;
	public SupplierPayment (){}

	public SupplierPayment(Date date, Integer money, String supplier, Long supplier_id) {
		super();
		this.date = date;
		this.money = money;
		this.supplier = supplier;
		this.supplier_id = supplier_id;
	}

	public Long getSupplierPayment_id() {
		return supplierPayment_id;
	}
	public void setSupplierPayment_id(Long supplierPayment_id) {
		this.supplierPayment_id = supplierPayment_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public Long getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(Long supplier_id) {
		this.supplier_id = supplier_id;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}

	
}
