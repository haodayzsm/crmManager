package top.haodayzsm.pojo;

public class OrderProduct implements java.io.Serializable{
	private Long orderProduct_id;
	private Integer quantity;		//数量
	private Double unitPrice;		//单价
	private Double total;			//合计金额
	private Integer piece;		//件数
	private Integer packing;	//包装数量
	private String product;		//商品名字
	private Long product_id;
	private String color;		//商品色号
	private Long color_id;
	public Long getOrderProduct_id() {
		return orderProduct_id;
	}
	public void setOrderProduct_id(Long orderProduct_id) {
		this.orderProduct_id = orderProduct_id;
	}
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

}
