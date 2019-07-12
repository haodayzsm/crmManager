package top.haodayzsm.pojo;

import java.util.HashSet;
import java.util.Set;

public class Product implements java.io.Serializable{
	private Long product_id;
	private String name;
	private String number;
	private Double costPrice;			//成本价
	private Double wholesalePrice;		//批发价
	private Double retailPrice;			//零售价
	private Integer quantity=0;
	private Integer packing;
	private String specification;
	private Set<Color> color;
	private String classification;
	private Long classification_id;
	private String supplier;
	private Long supplier_id;
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}
	public Double getWholesalePrice() {
		return wholesalePrice;
	}
	public void setWholesalePrice(Double wholesalePrice) {
		this.wholesalePrice = wholesalePrice;
	}
	public Double getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public Set<Color> getColor() {
		return color;
	}
	public void setColor(Set<Color> color) {
		this.color = color;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public Long getClassification_id() {
		return classification_id;
	}
	public void setClassification_id(Long classification_id) {
		this.classification_id = classification_id;
	}
	public Long getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(Long supplier_id) {
		this.supplier_id = supplier_id;
	}
	public Integer getPacking() {
		return packing;
	}
	public void setPacking(Integer packing) {
		this.packing = packing;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
