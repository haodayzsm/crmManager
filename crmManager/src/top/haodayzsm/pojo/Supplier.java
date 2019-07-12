package top.haodayzsm.pojo;

import java.util.HashSet;
import java.util.Set;

public class Supplier implements java.io.Serializable{
	private Long supplier_id;
	private String name;
	private String location;
	private Integer money;
	private Set<Product> product=new HashSet<Product>();
	private Set<SupplierReturn> supplierReturn = new HashSet<SupplierReturn>();
	private Set<Storage> storage=new HashSet<Storage>();
	private Set<SupplierPayment> supplierPayment=null;
	public Long getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(Long supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	public Set<Product> getProduct() {
		return product;
	}
	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	public Set<SupplierReturn> getSupplierReturn() {
		return supplierReturn;
	}
	public void setSupplierReturn(Set<SupplierReturn> supplierReturn) {
		this.supplierReturn = supplierReturn;
	}
	public Set<Storage> getStorage() {
		return storage;
	}
	public void setStorage(Set<Storage> storage) {
		this.storage = storage;
	}
	public Set<SupplierPayment> getSupplierPayment() {
		return supplierPayment;
	}
	public void setSupplierPayment(Set<SupplierPayment> supplierPayment) {
		this.supplierPayment = supplierPayment;
	}

}
