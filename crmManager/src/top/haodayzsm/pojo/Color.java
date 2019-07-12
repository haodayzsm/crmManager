package top.haodayzsm.pojo;

public class Color implements java.io.Serializable{
	private Long color_id;
	private String name;
	private Integer ps;
	private Integer Quantity=0;			//库存数量
	private Integer costPrice;			//成本价
	private String product;
	private Long product_id;
	public Color(){}
	public Color(String name, Integer ps,  Integer costPrice, String product,
			Long product_id) {
		super();
		this.name = name;
		this.ps = ps;
		this.costPrice = costPrice;
		this.product = product;
		this.product_id = product_id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getQuantity() {
		return Quantity;
	}
	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	public Integer getPs() {
		return ps;
	}
	public void setPs(Integer ps) {
		this.ps = ps;
	}
	public Long getColor_id() {
		return color_id;
	}
	public void setColor_id(Long color_id) {
		this.color_id = color_id;
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
	public Integer getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(Integer costPrice) {
		this.costPrice = costPrice;
	}
}
