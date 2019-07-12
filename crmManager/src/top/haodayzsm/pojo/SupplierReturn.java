package top.haodayzsm.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SupplierReturn implements java.io.Serializable{
	private Long supplierReturn_id;
	private String number;
	private String Remarks;
	private Date date;
	private Double total;
	private Double payment;
	private String user;
	private Long user_id;
	private String supplier;
	private Long userpplier_id;
	private Set<StorageProduct> orderproduct=new HashSet<StorageProduct>();
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getRemarks() {
		return Remarks;
	}
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Double getPayment() {
		return payment;
	}
	public void setPayment(Double payment) {
		this.payment = payment;
	}
	public Set<StorageProduct> getOrderproduct() {
		return orderproduct;
	}
	public void setOrderproduct(Set<StorageProduct> orderproduct) {
		this.orderproduct = orderproduct;
	}
	public Long getSupplierReturn_id() {
		return supplierReturn_id;
	}
	public void setSupplierReturn_id(Long supplierReturn_id) {
		this.supplierReturn_id = supplierReturn_id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public Long getUserpplier_id() {
		return userpplier_id;
	}
	public void setUserpplier_id(Long userpplier_id) {
		this.userpplier_id = userpplier_id;
	}
}
