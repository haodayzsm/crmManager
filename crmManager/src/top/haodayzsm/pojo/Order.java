package top.haodayzsm.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Order implements java.io.Serializable{
	private Long aorder_id;
	private String number;
	private String remarks;
	private Date date;
	private Integer total;
	private Integer money;
	private String type;
	private String user;
	private Long user_id;
	private String customer;
	private Long customer_id;
	private Set<OrderProduct> orderProduct=new HashSet<OrderProduct>();
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getAorder_id() {
		return aorder_id;
	}
	public void setAorder_id(Long order_id) {
		this.aorder_id = order_id;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public Long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getUser() {
		return user;
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
	public Set<OrderProduct> getOrderProduct() {
		return orderProduct;
	}
	public void setOrderProduct(Set<OrderProduct> orderProduct) {
		this.orderProduct = orderProduct;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
