package top.haodayzsm.pojo;

public class OrderProduct implements java.io.Serializable{
	private Long orderProduct_id;
	private Integer quantity;		//����
	private Double unitPrice;		//����
	private Double total;			//�ϼƽ��
	private Integer piece;		//����
	private Integer packing;	//��װ����
	private String product;		//��Ʒ����
	private Long product_id;
	private String color;		//��Ʒɫ��
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
