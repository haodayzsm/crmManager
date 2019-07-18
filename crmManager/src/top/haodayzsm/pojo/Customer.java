package top.haodayzsm.pojo;

import java.util.HashSet;
import java.util.Set;

public class Customer implements java.io.Serializable{
	private Long customer_id;
	private String name;
	private String tel;
	private String location;
	private String wechat;
	private Integer money;
	private String status="activation";
	private Set<Payment> payment=null;//¸¶¿îÁ÷Ë®
	private Set<Order> order=new HashSet<Order>();
	private Set<CustomerReturn> orderReturn=new HashSet<CustomerReturn>();
	
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
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public Set<Order> getOrder() {
		return order;
	}
	public void setOrder(Set<Order> order) {
		this.order = order;
	}
	public Set<CustomerReturn> getOrderReturn() {
		return orderReturn;
	}
	public void setOrderReturn(Set<CustomerReturn> orderReturn) {
		this.orderReturn = orderReturn;
	}
	public Long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}
	public Set<Payment> getPayment() {
		return payment;
	}
	public void setPayment(Set<Payment> payment) {
		this.payment = payment;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
