package top.haodayzsm.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Storage implements java.io.Serializable{
	private Long storage_id;		
	private String type;
	private String number;		
	private String Remarks;			//备注
	private Date date;				//时间
	private Integer total;			//总计
	private Integer money;			//付款金额
	private String supplier;		//供应商
	private Long supplier_id;		
	private String user;			//开单人
	private Long user_id;
	private Set<StorageProduct> orderProduct=new HashSet<StorageProduct>();
	public Long getStorage_id() {
		return storage_id;
	}
	public void setStorage_id(Long storage_id) {
		this.storage_id = storage_id;
	}
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
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
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
	public Set<StorageProduct> getOrderProduct() {
		return orderProduct;
	}
	public void setOrderProduct(Set<StorageProduct> orderProduct) {
		this.orderProduct = orderProduct;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
