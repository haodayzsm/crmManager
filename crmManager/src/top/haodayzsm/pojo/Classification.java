package top.haodayzsm.pojo;

import java.util.HashSet;
import java.util.Set;

public class Classification implements java.io.Serializable{
	private Long classification_id;
	private String name;
	private String remarks;
	private Set<Product> product=new HashSet<Product>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Product> getProduct() {
		return product;
	}
	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	public Long getClassification_id() {
		return classification_id;
	}
	public void setClassification_id(Long classification_id) {
		this.classification_id = classification_id;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
