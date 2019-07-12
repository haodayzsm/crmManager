package top.haodayzsm.pojo;

public class StorageProduct implements java.io.Serializable{
	private Long storageProduct_id;
	private Integer quantity;
	private Double unitPrice;
	private Double total;
	private Integer piece;
	private Integer packing;
	private String product;
	private Long product_id;
	private String color;
	private Long color_id;
	private String number;

	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Long getStorageProduct_id() {
		return storageProduct_id;
	}
	public void setStorageProduct_id(Long storageProduct_id) {
		this.storageProduct_id = storageProduct_id;
	}
	public Integer getPiece() {
		return piece;
	}
	public void setPiece(Integer piece) {
		this.piece = piece;
	}
	public Integer getPacking() {
		return packing;
	}
	public void setPacking(Integer packing) {
		this.packing = packing;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Long getColor_id() {
		return color_id;
	}
	public void setColor_id(Long color_id) {
		this.color_id = color_id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
}
